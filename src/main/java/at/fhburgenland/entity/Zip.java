package at.fhburgenland.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "zip")

public class Zip {
    @Id
    @Column(name = "zipcode", length = 10)
    private String zipcode;

    @Setter
    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @OneToMany(mappedBy = "zip")
    private List<Guest> guests = new ArrayList<>();

    protected Zip() {
    }

    public Zip(String zipcode, String city) {
        this.zipcode = zipcode;
        this.city = city;
    }
}

