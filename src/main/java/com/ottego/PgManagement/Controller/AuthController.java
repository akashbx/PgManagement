package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Dto.LoginResponse;
import com.ottego.PgManagement.Request.LoginRequest;
import com.ottego.PgManagement.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request.getPhone(), request.getPassword()));
    }
}
