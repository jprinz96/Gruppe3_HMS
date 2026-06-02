package at.fhburgenland.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Entity
@Table(name = "service")
public class Service {

    @Id
    @Column(name = "service_id", length = 10)
    private String serviceId;

    @Setter
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Setter
    @Column(name = "description", length = 255)
    private String description;

    @Setter
    @Column(name = "price_eur", nullable = false, precision = 8, scale = 2)
    private BigDecimal priceEur;

    protected Service() {
    }

    public Service(String serviceId, String name, String description, BigDecimal priceEur) {
        this.serviceId = serviceId;
        this.name = name;
        this.description = description;
        this.priceEur = priceEur;
    }
}