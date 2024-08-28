package com.ottego.PgManagement.model;

import com.ottego.PgManagement.model.Enum.ComplaintType;
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
@Table(name = "complaints")
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ComplaintType type;

    @NotBlank
    private String description;
    private Boolean closed;

    @ManyToOne
    @JoinColumn(name = "stay_id")
    private Stay stay;

    @OneToMany(mappedBy = "complaint",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ComplaintAction> complaintAction = new ArrayList<>();
}
