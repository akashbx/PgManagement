package com.ottego.PgManagement.model;

import com.ottego.PgManagement.model.Enum.PaymentMode;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments",
        uniqueConstraints ={
        @UniqueConstraint(columnNames = "transaction_id")
})

public  class Payment  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String transaction_id;

    private Integer amount;

    @Enumerated(EnumType.STRING)
    private PaymentMode payment_mode;

    @CreationTimestamp
    private String created_at;

    @UpdateTimestamp
    private String updated_at;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

}
