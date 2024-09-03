package com.ottego.PgManagement.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Timestamp;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @NotNull
    @CreatedDate
    private LocalDate checkIn;

    @Nullable

    private LocalDate checkOut;

    @OneToMany(mappedBy = "stay", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Complaint> complaint = new ArrayList<>();

    @OneToMany(mappedBy = "stay", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> invoice = new ArrayList<>();

    @OneToMany(mappedBy ="stay", cascade =CascadeType.ALL, orphanRemoval =true)
    private List<Diner> diners = new ArrayList<>();
    public int getmonth() {
        return checkIn.getMonthValue();
    }
}
