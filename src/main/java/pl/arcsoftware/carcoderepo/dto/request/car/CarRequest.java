package pl.arcsoftware.carcoderepo.dto.request.car;

import javax.validation.constraints.NotBlank;

public class CarRequest {

    @NotBlank
    private String model;

    @NotBlank
    private String engine;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

}
