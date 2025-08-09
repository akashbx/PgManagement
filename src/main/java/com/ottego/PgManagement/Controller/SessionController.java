package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.model.Caretaker;
import com.ottego.PgManagement.model.Owner;
import com.ottego.PgManagement.repository.CaretakerRepository;
import com.ottego.PgManagement.repository.OwnerRepository;
import com.ottego.PgManagement.security.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    private final JwtUtil jwtUtil;
    private final OwnerRepository ownerRepository;
    private final CaretakerRepository caretakerRepository;

    public SessionController(JwtUtil jwtUtil,
                             OwnerRepository ownerRepository,
                             CaretakerRepository caretakerRepository) {
        this.jwtUtil = jwtUtil;
        this.ownerRepository = ownerRepository;
        this.caretakerRepository = caretakerRepository;
    }

    @GetMapping
    public ResponseEntity<?> getSession(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body("Need Authorization");
        }

        try {
            String token = authHeader.substring(7);
            Claims claims = jwtUtil.extractAllClaims(token);

            Integer id = claims.get("id", Number.class).intValue();
            String phone = claims.getSubject();
            String role = claims.get("role", String.class);

            if ("OWNER".equalsIgnoreCase(role)) {
                Owner owner = ownerRepository.findById(id).orElseThrow();
                return ResponseEntity.ok(new SessionResponse(owner.getId(), owner.getPhone(), owner.getName(), role, null));
            }
            else if ("CARETAKER".equalsIgnoreCase(role)) {
                Caretaker caretaker = caretakerRepository.findById(id).orElseThrow();
                Integer pgId = caretaker.getPg() != null ? caretaker.getPg().getId() : null;
                return ResponseEntity.ok(new SessionResponse(caretaker.getId(), caretaker.getPhone(), caretaker.getName(), role, pgId));
            }

            return ResponseEntity.status(404).body("User not found");

        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid or expired token");
        }
    }

    record SessionResponse(Integer id, Long phone, String name, String role, Integer pgId) {}
}
