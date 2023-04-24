package pl.arcsoftware.carcoderepo.models.newModels;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "fuel_note", schema = "public", catalog = "carhistorytempDB")
public class FuelNoteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "car_id", nullable = true)
    private Integer carId;
    @Basic
    @Column(name = "volume", nullable = true, precision = 2)
    private BigDecimal volume;
    @Basic
    @Column(name = "distance", nullable = true)
    private Integer distance;
    @Basic
    @Column(name = "car_mileage", nullable = true)
    private Integer carMileage;
    @Basic
    @Column(name = "cost", nullable = true, precision = 2)
    private BigDecimal cost;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Object createdAt;
    @Basic
    @Column(name = "modified_at", nullable = true)
    private Object modifiedAt;
    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private CarEntity carByCarId;

    public Integer getId() {
        return id;
    }

    public FuelNoteEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getCarId() {
        return carId;
    }

    public FuelNoteEntity setCarId(Integer carId) {
        this.carId = carId;
        return this;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public FuelNoteEntity setVolume(BigDecimal volume) {
        this.volume = volume;
        return this;
    }

    public Integer getDistance() {
        return distance;
    }

    public FuelNoteEntity setDistance(Integer distance) {
        this.distance = distance;
        return this;
    }

    public Integer getCarMileage() {
        return carMileage;
    }

    public FuelNoteEntity setCarMileage(Integer carMileage) {
        this.carMileage = carMileage;
        return this;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public FuelNoteEntity setCost(BigDecimal cost) {
        this.cost = cost;
        return this;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public FuelNoteEntity setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Object getModifiedAt() {
        return modifiedAt;
    }

    public FuelNoteEntity setModifiedAt(Object modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    public CarEntity getCarByCarId() {
        return carByCarId;
    }

    public FuelNoteEntity setCarByCarId(CarEntity carByCarId) {
        this.carByCarId = carByCarId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuelNoteEntity that = (FuelNoteEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(carId, that.carId) && Objects.equals(volume, that.volume) && Objects.equals(distance, that.distance) && Objects.equals(carMileage, that.carMileage) && Objects.equals(cost, that.cost) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carId, volume, distance, carMileage, cost, createdAt, modifiedAt);
    }

}
