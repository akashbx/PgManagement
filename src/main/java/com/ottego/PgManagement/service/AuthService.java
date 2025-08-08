package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.LoginResponse;
import com.ottego.PgManagement.model.Caretaker;
import com.ottego.PgManagement.model.Owner;
import com.ottego.PgManagement.repository.CaretakerRepository;
import com.ottego.PgManagement.repository.OwnerRepository;
import com.ottego.PgManagement.security.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final OwnerRepository ownerRepository;
    private final CaretakerRepository caretakerRepository;
    private final JwtUtil jwtUtil;

    public AuthService(OwnerRepository ownerRepository, CaretakerRepository caretakerRepository, JwtUtil jwtUtil) {
        this.ownerRepository = ownerRepository;
        this.caretakerRepository = caretakerRepository;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponse login(Long phone, String password) {
        // Owner login
        Optional<Owner> ownerOpt = ownerRepository.findByPhone(phone);
        if (ownerOpt.isPresent()) {
            Owner owner = ownerOpt.get();
            if (!owner.getPassword().equals(password)) {
                throw new RuntimeException("Invalid password");
            }
            String token = jwtUtil.generateToken(Long.valueOf(owner.getId()), String.valueOf(owner.getPhone()), "OWNER");
            return new LoginResponse(owner.getId(), owner.getPhone(), token, "OWNER");
        }

        // Caretaker login
        Optional<Caretaker> caretakerOpt = caretakerRepository.findByPhone(phone);
        if (caretakerOpt.isPresent()) {
            Caretaker caretaker = caretakerOpt.get();
            if (!caretaker.getPassword().equals(password)) {
                throw new RuntimeException("Invalid password");
            }
            String token = jwtUtil.generateToken(Long.valueOf(caretaker.getId()), String.valueOf(caretaker.getPhone()), "CARETAKER");
            return new LoginResponse(caretaker.getId(), caretaker.getPhone(), token, "CARETAKER");
        }

        throw new RuntimeException("User not found with given phone");
    }
}
