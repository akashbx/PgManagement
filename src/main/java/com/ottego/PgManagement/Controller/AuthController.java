package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Dto.LoginResponse;
import com.ottego.PgManagement.Request.LoginRequest;
import com.ottego.PgManagement.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
        Map<String, Object> loginData = authService.login(request.getPhone(), request.getPassword());
        return ResponseEntity.ok(loginData);
    }

}
