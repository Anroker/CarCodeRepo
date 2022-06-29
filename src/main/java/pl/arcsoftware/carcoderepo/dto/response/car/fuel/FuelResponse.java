package pl.arcsoftware.carcoderepo.dto.response.car.fuel;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

public class FuelResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String response;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;


    private BigDecimal fuel;


    private Integer distance;

    public FuelResponse() {
    }

    public FuelResponse(String response, BigDecimal fuel, Integer distance) {
        this.response = response;
        this.fuel = fuel;
        this.distance = distance;
    }

    public String getResponse() {
        return response;
    }

    public FuelResponse setResponse(String response) {
        this.response = response;
        return this;
    }

    public Long getId() {
        return id;
    }

    public FuelResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public BigDecimal getFuel() {
        return fuel;
    }

    public FuelResponse setFuel(BigDecimal fuel) {
        this.fuel = fuel;
        return this;
    }

    public Integer getDistance() {
        return distance;
    }

    public FuelResponse setDistance(Integer distance) {
        this.distance = distance;
        return this;
    }
}
