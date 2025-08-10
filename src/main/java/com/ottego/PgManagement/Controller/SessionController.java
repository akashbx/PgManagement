package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.model.Caretaker;
import com.ottego.PgManagement.model.Guest;
import com.ottego.PgManagement.model.Owner;
import com.ottego.PgManagement.repository.CaretakerRepository;
import com.ottego.PgManagement.repository.GuestRepository;
import com.ottego.PgManagement.repository.OwnerRepository;
import com.ottego.PgManagement.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    private final JwtUtil jwtUtil;
    private final OwnerRepository ownerRepository;
    private final CaretakerRepository caretakerRepository;
    private final GuestRepository guestRepository;

    public SessionController(
            JwtUtil jwtUtil,
            OwnerRepository ownerRepository,
            CaretakerRepository caretakerRepository,
            GuestRepository guestRepository
    ) {
        this.jwtUtil = jwtUtil;
        this.ownerRepository = ownerRepository;
        this.caretakerRepository = caretakerRepository;
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public ResponseEntity<?> getSession(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body("Missing or invalid Authorization header");
        }

        String token = authHeader.substring(7);

        Long userId = Long.valueOf(jwtUtil.extractUserId(token));
        String phone = jwtUtil.extractPhone(token);
        String role = jwtUtil.extractRole(token);

        Map<String, Object> response = new HashMap<>();
        response.put("id", userId);
        response.put("phone", phone);
        response.put("role", role);

        switch (role) {
            case "OWNER":
                ownerRepository.findById(Math.toIntExact(userId)).ifPresent(owner ->
                        response.put("name", owner.getName())
                );
                break;

            case "CARETAKER":
                caretakerRepository.findById(Math.toIntExact(userId)).ifPresent(caretaker -> {
                    response.put("name", caretaker.getName());
                    if (caretaker.getPg() != null) {
                        response.put("pg_id", caretaker.getPg().getId());
                    }
                });
                break;

            case "GUEST":
                guestRepository.findById(Math.toIntExact(userId)).ifPresent(guest ->
                        response.put("name", guest.getName())
                );
                break;
        }

        return ResponseEntity.ok(response);
    }
}
