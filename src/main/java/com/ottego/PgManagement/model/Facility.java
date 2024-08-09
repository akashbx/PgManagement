package com.ottego.PgManagement.model;

import com.ottego.PgManagement.model.Enum.PgFacility;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facilities")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private PgFacility name;
    @ManyToOne
    @JoinColumn(name = "pg_id")
    private Pg pg;
}
