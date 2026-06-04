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
@Table(name = "maintenance")
public class Maintenance {

    @Id
    @Generated(event = EventType.INSERT)
    @Column(name = "maintenance_id", length = 10, insertable = false, updatable = false)
    private String maintenanceId;

    @Setter
    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    @Setter
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Setter
    @Column(name = "maintenance_date", nullable = false)
    private LocalDate maintenanceDate;

    @Setter
    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Setter
    @Column(name = "status", nullable = false, length = 20)
    private String status;

    protected Maintenance() {
    }

    public Maintenance(Staff staff, Room room, LocalDate maintenanceDate, String description, String status) {
        this.staff = staff;
        this.room = room;
        this.maintenanceDate = maintenanceDate;
        this.description = description;
        this.status = status;
    }
}