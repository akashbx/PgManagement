package com.ottego.PgManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToOne
    @MapsId
    @JoinColumn(name = "pg_id")
    private Pg pg;
}
