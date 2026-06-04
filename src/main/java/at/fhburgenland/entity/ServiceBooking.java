package at.fhburgenland.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "service_booking")
public class ServiceBooking {

    @Id
    @Generated(event = EventType.INSERT)
    @Column(name = "servicebooking_id", length = 20, insertable = false, updatable = false)
    private String serviceBookingId;

    @Setter
    @ManyToOne
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;

    @Setter
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @Setter
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @Setter
    @Column(name = "bookingdate", nullable = false)
    private LocalDate bookingDate;

    @Setter
    @Column(name = "quantity", nullable = false)
    private int quantity;

    protected ServiceBooking() {
    }

    public ServiceBooking(Reservation reservation, Service service, Staff staff, LocalDate bookingDate, int quantity) {
        this.reservation = reservation;
        this.service = service;
        this.staff = staff;
        this.bookingDate = bookingDate;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ServiceBooking{" +
                "serviceBookingId='" + serviceBookingId + '\'' +
                ", reservation=" + reservation.getReservationId() +
                ", service=" + service.getServiceId() +
                ", staff=" + (staff != null ? staff.getStaffId() : null) +
                ", bookingDate=" + bookingDate +
                ", quantity=" + quantity +
                '}';
    }
}