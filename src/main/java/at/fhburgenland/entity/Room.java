package at.fhburgenland.entity;

import at.fhburgenland.enums.RoomCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Entity
@Table(name = "room")
public class Room {

    @Id
    @Column(name = "room_id", length = 10)
    private String roomId;

    @Setter
    @Column(name = "roomnumber", nullable = false, unique = true)
    private int roomNumber;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, length = 20)
    private RoomCategory category;

    @Setter
    @Column(name = "pricepernight_eur", nullable = false, precision = 8, scale = 2)
    private BigDecimal pricePerNightEur;

    protected Room() {
    }

    public Room(String roomId, int roomNumber, RoomCategory category, BigDecimal pricePerNightEur) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.category = category;
        this.pricePerNightEur = pricePerNightEur;
    }

}
