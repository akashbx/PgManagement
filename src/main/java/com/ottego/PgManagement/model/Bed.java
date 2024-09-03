package com.ottego.PgManagement.model;

import com.ottego.PgManagement.model.Enum.BedStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "beds")
public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull
    private BedStatus status;

    @NotBlank
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(mappedBy = "bed", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Stay> stays = new ArrayList<>();
}
