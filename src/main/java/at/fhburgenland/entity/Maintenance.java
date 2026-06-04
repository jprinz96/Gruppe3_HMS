package at.fhburgenland.entity;

import at.fhburgenland.enums.MaintenanceStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.time.LocalDate;
import java.util.List;

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
    private MaintenanceStatus maintenanceStatus;

    protected Maintenance() {
    }

    public Maintenance(Staff staff, Room room, LocalDate maintenanceDate, String description, MaintenanceStatus maintenanceStatus) {
        this.staff = staff;
        this.room = room;
        this.maintenanceDate = maintenanceDate;
        this.description = description;
        this.maintenanceStatus = maintenanceStatus;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "maintenanceId='" + maintenanceId + '\'' +
                ", staff=" + staff.getStaffId() +
                ", room=" + room.getRoomId() +
                ", maintenanceDate=" + maintenanceDate +
                ", description='" + description + '\'' +
                ", maintenanceStatus=" + maintenanceStatus +
                '}';
    }

}