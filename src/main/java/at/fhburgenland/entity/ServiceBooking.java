package at.fhburgenland.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "service_booking")
public class ServiceBooking {

    @Id
    @Column(name = "servicebooking_id", length = 20)
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

    public ServiceBooking(String serviceBookingId, Reservation reservation, Service service,
                          Staff staff, LocalDate bookingDate, int quantity) {
        this.serviceBookingId = serviceBookingId;
        this.reservation = reservation;
        this.service = service;
        this.staff = staff;
        this.bookingDate = bookingDate;
        this.quantity = quantity;
    }
}