package com.ottego.PgManagement.model;

import com.ottego.PgManagement.model.Enum.Cuisine;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Cuisine cuisine;

    @NotBlank
    private String name;

    private String description;

    @NotBlank
    private String price;

    @ManyToOne
    @JoinColumn(columnDefinition = "meal_id")
    private Meal meal;
}
