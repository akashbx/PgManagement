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
    private Integer id;

    @NotBlank
    private String name;

    @OneToOne(mappedBy = "pg", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

    @NotBlank
    private String phone;

    @NotBlank
    public String image;


    @OneToOne(mappedBy = "pg", cascade = CascadeType.ALL)
    private Caretaker caretaker;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(mappedBy = "pg", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms = new ArrayList<>();

    @OneToMany(mappedBy ="pg", cascade =CascadeType.ALL, orphanRemoval =true)
    private List<Meal> meals = new ArrayList<>();

    @OneToMany(mappedBy = "pg", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Facility> facility = new ArrayList<>();

    @OneToMany(mappedBy = "pg", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dish> dishes = new ArrayList<>();
}
