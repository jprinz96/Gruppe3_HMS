package at.fhburgenland.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Set<Guest> guests = new HashSet<>();

    protected Zip() {
    }

    public Zip(String zipcode, String city) {
        this.zipcode = zipcode;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Zip{" +
                "city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}

