package at.fhburgenland.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name = "reservation_id", length = 20)
    private String reservationId;

    @Setter
    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;

    @Setter
    @Column(name = "checkindate", nullable = false)
    private LocalDate checkinDate;

    @Setter
    @Column(name = "checkoutdate", nullable = false)
    private LocalDate checkoutDate;

    @Setter
    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @ManyToMany
    @JoinTable(
            name = "room_reservation",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private List<Room> rooms = new ArrayList<>();

    protected Reservation() {
    }

    public Reservation(String reservationId, Guest guest, LocalDate checkinDate,
                       LocalDate checkoutDate, String status) {
        this.reservationId = reservationId;
        this.guest = guest;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.status = status;
    }
}