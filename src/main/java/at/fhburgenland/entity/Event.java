package at.fhburgenland.entity;

import at.fhburgenland.enums.EventStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Table(name = "event")
public class Event {

    @Id
    @Generated(event = EventType.INSERT)
    @Column(name = "event_id", length = 10, insertable = false, updatable = false)
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
    private EventStatus eventStatus;

    @ManyToMany
    @JoinTable(
            name = "event_registration",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id")
    )
    private Set<Guest> guests = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "event_staff_allocation",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id")
    )
    private Set<Staff> staffMembers = new HashSet<>();

    protected Event() {
    }

    public Event(String title, LocalDate eventDate, int minParticipants, EventStatus eventStatus) {
        this.title = title;
        this.eventDate = eventDate;
        this.minParticipants = minParticipants;
        this.eventStatus = eventStatus;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", minParticipants=" + minParticipants +
                ", status='" + eventStatus + '\'' +
                '}';
    }
}