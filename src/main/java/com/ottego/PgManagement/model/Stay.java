package com.ottego.PgManagement.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


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

    @ManyToOne
    @JoinColumn(columnDefinition = "guest_id")
    private Guest guest;

    @NotBlank
    @CreationTimestamp
    private String checkIn;

    @Nullable

    private String checkOut;

    @OneToMany(mappedBy = "stay", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Complaint> complaint = new ArrayList<>();

    @OneToMany(mappedBy = "stay", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> invoice = new ArrayList<>();

    @OneToMany(mappedBy ="stay", cascade =CascadeType.ALL, orphanRemoval =true)
    private List<Diner> diners = new ArrayList<>();
}
