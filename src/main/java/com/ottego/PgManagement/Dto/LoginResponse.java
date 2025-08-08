package com.ottego.PgManagement.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    private Integer id;
    private Long phone;
    private String token;
    private String role;
}
