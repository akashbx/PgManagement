package com.ottego.PgManagement.model;

import com.ottego.PgManagement.model.Enum.MealType;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private MealType type;

    private Integer price;

    @CreationTimestamp
    private LocalDateTime created_at;

    @Timestamp
    private String served_at;

    @ManyToOne
    @JoinColumn(columnDefinition = "pg_id")
    private Pg pg;


    @ManyToMany
    @JoinTable(
            name = "meals_dishes",
            joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id"))
    List<Dish> dishes;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Diner> diners = new ArrayList<>();

    public int calculateMealCost() {
        switch (this.type) {
            case BREAKFAST:
                return 50;
            case LUNCH:
                return 70;
            case DINNER:
                return 80;
            default:
                return 0;
        }
    }
}

