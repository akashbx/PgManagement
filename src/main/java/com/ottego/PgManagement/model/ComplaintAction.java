package com.ottego.PgManagement.model;

import com.ottego.PgManagement.model.Enum.ActionStatus;
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
@Table(name = "ComplaintAction")
public class ComplaintAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ActionStatus status;

    @NotBlank
    private String description;

    @ManyToOne
    @JoinColumn(name = "complaint_id")
    private Complaint complaint;
}
