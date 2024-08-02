package com.ottego.PgManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pgs")
public class Pg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // Changed to Long for better practice with ID fields
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String zip;
    @NotBlank
    private String phone;
    @NotBlank
    private String caretaker;

    @ManyToMany
    @JoinTable(
            name = "pg_room",
            joinColumns = @JoinColumn(name = "pg_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private final List<Room> rooms = new ArrayList<>();
}
