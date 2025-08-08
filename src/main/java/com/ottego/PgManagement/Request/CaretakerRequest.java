package com.ottego.PgManagement.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaretakerRequest {
    private String name;
    private Long phone;
    private String password;
    private Integer pg_id;
}
