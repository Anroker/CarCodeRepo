package pl.arcsoftware.carcoderepo.payload.response;

public class CarResponse {

    private String okResponse;

    private String model;

    private String engine;

    public CarResponse(String okResponse, String model, String engine) {
        this.okResponse = okResponse;
        this.model = model;
        this.engine = engine;
    }

    public String getOkResponse() {
        return okResponse;
    }

    public void setOkResponse(String okResponse) {
        this.okResponse = okResponse;
    }

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
