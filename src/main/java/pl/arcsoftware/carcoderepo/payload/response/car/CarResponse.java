package pl.arcsoftware.carcoderepo.payload.response.car;

import com.fasterxml.jackson.annotation.JsonInclude;

public class CarResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String okResponse;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    private String model;

    private String engine;

    public CarResponse(String okResponse, String model, String engine) {
        this.okResponse = okResponse;
        this.model = model;
        this.engine = engine;
    }

    public CarResponse() {
    }

    public String getOkResponse() {
        return okResponse;
    }

    public CarResponse setOkResponse(String okResponse) {
        this.okResponse = okResponse;
        return this;
    }

    public Long getId() {
        return id;
    }

    public CarResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarResponse setModel(String model) {
        this.model = model;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public CarResponse setEngine(String engine) {
        this.engine = engine;
        return this;
    }
}
