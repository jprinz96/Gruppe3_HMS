package at.fhburgenland.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "guest")
@Getter
public class Guest {

    @Id
    @Column(name = "guest_id", length = 10)
    private String guestId;

    @Setter
    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;

    @Setter
    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;

    @Setter
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Setter
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Setter
    @Column(name = "phonenumber", length = 30)
    private String phonenumber;

    @Setter
    @Column(name = "street", length = 100)
    private String street;

    @Setter
    @Column(name = "housenumber", length = 10)
    private String houseNumber;

    @Setter
    @ManyToOne
    @JoinColumn(name = "zipcode", nullable = false)
    private Zip zip;

    protected Guest() {
    }

    public Guest(String guestId, String firstname, String lastname, LocalDate birthdate, String email, String phonenumber, String street, String houseNumber, Zip zip) {
        this.guestId = guestId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.email = email;
        this.phonenumber = phonenumber;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zip = zip;
    }
}
