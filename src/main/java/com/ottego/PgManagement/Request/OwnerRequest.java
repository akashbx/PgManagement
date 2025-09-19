package com.ottego.PgManagement.Request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OwnerRequest {
    private Integer id;
    private String name;
    private String email;
    private Long phone;
    private String password;
}
