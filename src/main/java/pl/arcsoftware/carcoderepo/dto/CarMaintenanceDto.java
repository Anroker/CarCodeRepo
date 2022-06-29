package pl.arcsoftware.carcoderepo.dto;

import pl.arcsoftware.carcoderepo.models.Car;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

public class CarMaintenanceDto implements Serializable {
    private final Integer id;
    private final OffsetDateTime createdAt;
    private final OffsetDateTime modifiedAt;
    private final BigDecimal cost;
    private final String description;
    private final String invoicePath;
    private final Car car;

    public CarMaintenanceDto(Integer id, OffsetDateTime createdAt, OffsetDateTime modifiedAt, BigDecimal cost, String description, String invoicePath, Car car) {
        this.id = id;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.cost = cost;
        this.description = description;
        this.invoicePath = invoicePath;
        this.car = car;
    }

    public Integer getId() {
        return id;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getModifiedAt() {
        return modifiedAt;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public String getInvoicePath() {
        return invoicePath;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarMaintenanceDto entity = (CarMaintenanceDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.modifiedAt, entity.modifiedAt) &&
                Objects.equals(this.cost, entity.cost) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.invoicePath, entity.invoicePath) &&
                Objects.equals(this.car, entity.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, modifiedAt, cost, description, invoicePath, car);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "createdAt = " + createdAt + ", " +
                "modifiedAt = " + modifiedAt + ", " +
                "cost = " + cost + ", " +
                "description = " + description + ", " +
                "invoicePath = " + invoicePath + ", " +
                "car = " + car + ")";
    }
}
