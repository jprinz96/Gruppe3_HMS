package at.fhburgenland.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

@Getter
@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @Generated(event = EventType.INSERT)
    @Column(name = "staff_id", length = 10, insertable = false, updatable = false)
    private String staffId;

    @Setter
    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;

    @Setter
    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;

    @Setter
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Setter
    @Column(name = "phonenumber", length = 30)
    private String phonenumber;

    @Setter
    @Column(name = "role", nullable = false, length = 50)
    private String role;

    protected Staff() {
    }

    public Staff(String firstname, String lastname, String email, String phonenumber, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.role = role;
    }
}