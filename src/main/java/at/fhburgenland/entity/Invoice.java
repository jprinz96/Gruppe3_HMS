package at.fhburgenland.entity;

import at.fhburgenland.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @Generated(event = EventType.INSERT)
    @Column(name = "invoice_id", length = 20, insertable = false, updatable = false)
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
    private PaymentStatus paymentStatus;

    protected Invoice() {
    }

    public Invoice(Reservation reservation, LocalDate invoiceDate, BigDecimal totalAmountEur,  PaymentStatus paymentStatus) {
        this.reservation = reservation;
        this.invoiceDate = invoiceDate;
        this.totalAmountEur = totalAmountEur;
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId='" + invoiceId + '\'' +
                ", reservation=" + reservation.getReservationId() +
                ", invoiceDate=" + invoiceDate +
                ", totalAmountEur=" + totalAmountEur +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}