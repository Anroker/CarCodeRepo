package pl.arcsoftware.carcoderepo.models;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "fuel_notes")
public class FuelNotes {
    @Id
    @SequenceGenerator(name = "fuel_notes_id_seq", sequenceName = "fuel_notes_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fuel_notes_id_seq")
    private Long id;

    private BigDecimal fuel;

    private Integer distance;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "modified_at")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public FuelNotes setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public FuelNotes setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
