package at.fhburgenland.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "event")
public class Event {

    @Id
    @Column(name = "event_id", length = 10)
    private String eventId;

    @Setter
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Setter
    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Setter
    @Column(name = "min_participants", nullable = false)
    private int minParticipants;

    @Setter
    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @ManyToMany
    @JoinTable(
            name = "event_registration",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id")
    )
    private List<Guest> guests = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "event_staff_allocation",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id")
    )
    private List<Staff> staffMembers = new ArrayList<>();

    protected Event() {
    }

    public Event(String eventId, String title, LocalDate eventDate,
                 int minParticipants, String status) {
        this.eventId = eventId;
        this.title = title;
        this.eventDate = eventDate;
        this.minParticipants = minParticipants;
        this.status = status;
    }
}