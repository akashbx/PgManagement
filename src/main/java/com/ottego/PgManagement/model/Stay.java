package com.ottego.PgManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "stays")
public class Stay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(columnDefinition = "bed_id")
    private Bed bed;

    @OneToOne
    @JoinColumn(columnDefinition = "guest_id")
    private Guest guest;

    @NotBlank
    private String checkIn;

    private String checkOut;

    @OneToMany(mappedBy = "stay", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Complaint> complaint = new ArrayList<>();

    @OneToMany(mappedBy = "stay", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> invoice = new ArrayList<>();
}
