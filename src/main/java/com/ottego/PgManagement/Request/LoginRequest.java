package com.ottego.PgManagement.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private Long phone;
    private String password;
}

