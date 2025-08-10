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
@Table(
        name = "diners",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"stay_id", "meal_id"})}
)
public class Diner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String item;

    private Integer price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DinerStatus status = DinerStatus.REGISTERED; // default

    @ManyToOne
    @JoinColumn(name = "stay_id")
    private Stay stay;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;

    public enum DinerStatus {
        REGISTERED, PRESENT, ABSENT
    }
}
