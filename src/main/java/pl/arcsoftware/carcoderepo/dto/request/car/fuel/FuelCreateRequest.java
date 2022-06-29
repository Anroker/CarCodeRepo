package pl.arcsoftware.carcoderepo.dto.request.car.fuel;

import java.math.BigDecimal;

public class FuelCreateRequest {


    private BigDecimal fuel;


    private Integer distance;

    public BigDecimal getFuel() {
        return fuel;
    }

    public FuelCreateRequest setFuel(BigDecimal fuel) {
        this.fuel = fuel;
        return this;
    }

    public Integer getDistance() {
        return distance;
    }

    public FuelCreateRequest setDistance(Integer distance) {
        this.distance = distance;
        return this;
    }
}
