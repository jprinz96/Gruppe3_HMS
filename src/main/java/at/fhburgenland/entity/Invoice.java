package at.fhburgenland.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @Column(name = "invoice_id", length = 20)
    private String invoiceId;

    @Setter
    @OneToOne
    @JoinColumn(name = "reservation_id", nullable = false, unique = true)
    private Reservation reservation;

    @Setter
    @Column(name = "invoicedate", nullable = false)
    private LocalDate invoiceDate;

    @Setter
    @Column(name = "totalamount_eur", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmountEur;

    @Setter
    @Column(name = "paymentstatus", nullable = false, length = 20)
    private String paymentStatus;

    protected Invoice() {
    }

    public Invoice(String invoiceId, Reservation reservation, LocalDate invoiceDate,
                   BigDecimal totalAmountEur, String paymentStatus) {
        this.invoiceId = invoiceId;
        this.reservation = reservation;
        this.invoiceDate = invoiceDate;
        this.totalAmountEur = totalAmountEur;
        this.paymentStatus = paymentStatus;
    }
}