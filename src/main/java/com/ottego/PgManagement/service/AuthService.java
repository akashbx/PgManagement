package com.ottego.PgManagement.service;

import com.ottego.PgManagement.Dto.LoginResponse;
import com.ottego.PgManagement.model.Owner;
import com.ottego.PgManagement.repository.OwnerRepository;
import com.ottego.PgManagement.security.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final OwnerRepository ownerRepository;
    private final JwtUtil jwtUtil;

    public AuthService(OwnerRepository ownerRepository, JwtUtil jwtUtil) {
        this.ownerRepository = ownerRepository;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponse login(Long phone, String password) {
        Owner owner = ownerRepository.findByPhone(phone)
                .orElseThrow(() -> new RuntimeException("Invalid phone or password"));

        // Compare plain text password (⚠️ Not secure for production)
        if (!owner.getPassword().equals(password)) {
            throw new RuntimeException("Invalid phone or password");
        }

        String token = jwtUtil.generateToken(phone.toString());
        return new LoginResponse(owner.getId(), owner.getPhone(), token);
    }
}
