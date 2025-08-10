package com.ottego.PgManagement.service;

import com.ottego.PgManagement.model.Caretaker;
import com.ottego.PgManagement.model.Guest;
import com.ottego.PgManagement.model.Owner;
import com.ottego.PgManagement.repository.CaretakerRepository;
import com.ottego.PgManagement.repository.GuestRepository;
import com.ottego.PgManagement.repository.OwnerRepository;
import com.ottego.PgManagement.security.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {

    private final OwnerRepository ownerRepository;
    private final CaretakerRepository caretakerRepository;
    private final GuestRepository guestRepository;
    private final JwtUtil jwtUtil;

    public AuthService(OwnerRepository ownerRepository,
                       CaretakerRepository caretakerRepository,
                       GuestRepository guestRepository,
                       JwtUtil jwtUtil) {
        this.ownerRepository = ownerRepository;
        this.caretakerRepository = caretakerRepository;
        this.guestRepository = guestRepository;
        this.jwtUtil = jwtUtil;
    }

    public Map<String, Object> login(Long phone, String password) {
        Map<String, Object> response = new HashMap<>();

        // OWNER login
        Optional<Owner> ownerOpt = ownerRepository.findByPhone(phone);
        if (ownerOpt.isPresent()) {
            Owner owner = ownerOpt.get();
            if (!owner.getPassword().equals(password)) {
                throw new RuntimeException("Invalid password");
            }
            String token = jwtUtil.generateToken(
                    Long.valueOf(owner.getId()),
                    String.valueOf(owner.getPhone()),
                    "OWNER"
            );

            response.put("id", owner.getId());
            response.put("phone", owner.getPhone());
            response.put("role", "OWNER");
            response.put("name", owner.getName());
            response.put("token", token);
            return response;
        }

        // CARETAKER login
        Optional<Caretaker> caretakerOpt = caretakerRepository.findByPhone(phone);
        if (caretakerOpt.isPresent()) {
            Caretaker caretaker = caretakerOpt.get();
            if (!caretaker.getPassword().equals(password)) {
                throw new RuntimeException("Invalid password");
            }
            String token = jwtUtil.generateToken(
                    Long.valueOf(caretaker.getId()),
                    String.valueOf(caretaker.getPhone()),
                    "CARETAKER"
            );

            response.put("id", caretaker.getId());
            response.put("phone", caretaker.getPhone());
            response.put("role", "CARETAKER");
            response.put("name", caretaker.getName());
            if (caretaker.getPg() != null) {
                response.put("pg_id", caretaker.getPg().getId());
            }
            response.put("token", token);
            return response;
        }

        // GUEST login
        Optional<Guest> guestOpt = guestRepository.findByPhone(phone);
        if (guestOpt.isPresent()) {
            Guest guest = guestOpt.get();
            if (!guest.getPassword().equals(password)) {
                throw new RuntimeException("Invalid password");
            }
            String token = jwtUtil.generateToken(
                    Long.valueOf(guest.getId()),
                    String.valueOf(guest.getPhone()),
                    "GUEST"
            );

            response.put("id", guest.getId());
            response.put("phone", guest.getPhone());
            response.put("role", "GUEST");
            response.put("name", guest.getName());
            response.put("token", token);
            return response;
        }

        throw new RuntimeException("User not found with given phone");
    }
}
