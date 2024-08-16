package com.ottego.PgManagement.model;

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
@Table(name = "diners")
public class Diner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String item;

    private Integer price;


    @ManyToOne
    @JoinColumn(columnDefinition = "stay_id")
    private Stay stay;

    @ManyToOne
    @JoinColumn(columnDefinition = "meal_id")
    private Meal meal;
}
