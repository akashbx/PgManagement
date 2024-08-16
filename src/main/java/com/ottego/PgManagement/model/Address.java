package com.ottego.PgManagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.concurrent.Future;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "pg_id")
    private Integer id;
    private String hn;
    private String area;
    private String street;
    private String city;
    private String state;
    private String zip;
    private Long latitude;
    private Long longitude;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pg_id")
    private Pg pg;
}
