package com.ottego.PgManagement.model;

import com.ottego.PgManagement.Dto.PgDto;
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
    private Integer id;

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

    @OneToMany(mappedBy = "pg", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms = new ArrayList<>();


    @OneToMany(mappedBy ="pg", cascade =CascadeType.ALL, orphanRemoval =true)
    private List<Meal> meals = new ArrayList<>();

    @OneToMany(mappedBy = "pg", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Facility> facility = new ArrayList<>();

    public PgDto getRemapper() {
        return PgDto.from(this);
    }
}
