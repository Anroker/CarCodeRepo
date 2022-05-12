package pl.arcsoftware.carcoderepo.payload.request.car;

public class CarUpdateRequest {

    private String model;
    private String engine;

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
