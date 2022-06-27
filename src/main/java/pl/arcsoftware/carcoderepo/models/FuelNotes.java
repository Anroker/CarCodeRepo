package pl.arcsoftware.carcoderepo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "fuel_notes")
public class FuelNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private BigDecimal fuel;

    @NotBlank
    private Integer distance;

    @NotBlank
    private LocalDateTime created_at;

    @NotBlank
    private LocalDateTime modified_at;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public Long getId() {
        return id;
    }

    public FuelNotes setId(Long id) {
        this.id = id;
        return this;
    }

    public BigDecimal getFuel() {
        return fuel;
    }

    public FuelNotes setFuel(BigDecimal fuel) {
        this.fuel = fuel;
        return this;
    }

    public Integer getDistance() {
        return distance;
    }

    public FuelNotes setDistance(Integer distance) {
        this.distance = distance;
        return this;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public FuelNotes setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
        return this;
    }

    public LocalDateTime getModified_at() {
        return modified_at;
    }

    public FuelNotes setModified_at(LocalDateTime modified_at) {
        this.modified_at = modified_at;
        return this;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
