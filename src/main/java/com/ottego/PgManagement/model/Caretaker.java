package com.ottego.PgManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "caretakers")
public class Caretaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private Long phone;

    @NotNull
    private String password; // Plain text if you don’t want encoding

    @OneToOne
    @JoinColumn(name = "pg_id")
    private Pg pg; // Link caretaker to a PG
}
