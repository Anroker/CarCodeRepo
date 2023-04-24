package pl.arcsoftware.carcoderepo.dto.request.car.fuel;

import java.math.BigDecimal;

public class FuelCreateRequest {


    private BigDecimal fuel;


    private Long distance;

    public BigDecimal getFuel() {
        return fuel;
    }

    public FuelCreateRequest setFuel(BigDecimal fuel) {
        this.fuel = fuel;
        return this;
    }

    public Long getDistance() {
        return distance;
    }

    public FuelCreateRequest setDistance(Long distance) {
        this.distance = distance;
        return this;
    }
}
