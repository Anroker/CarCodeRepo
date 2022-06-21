package pl.arcsoftware.carcoderepo.payload.request.car;

public class CarUpdateRequest {

    private String model;
    private String engine;
    private String vin;
    private short year_of_production;

    public String getVin() {
        return vin;
    }

    public CarUpdateRequest setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public short getYear_of_production() {
        return year_of_production;
    }

    public CarUpdateRequest setYear_of_production(short year_of_production) {
        this.year_of_production = year_of_production;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarUpdateRequest setModel(String model) {
        this.model = model;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public CarUpdateRequest setEngine(String engine) {
        this.engine = engine;
        return this;
    }
}
