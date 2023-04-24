package pl.arcsoftware.carcoderepo.dto.request.car;

import javax.validation.constraints.NotBlank;

public class CarRequest {

    @NotBlank
    private Long model_id;

    @NotBlank
    private Long brand_id;

    @NotBlank
    private String name;

    @NotBlank
    private String mark;

    public Long getModel_id() {
        return model_id;
    }

    public CarRequest setModel_id(Long model_id) {
        this.model_id = model_id;
        return this;
    }

    public Long getBrand_id() {
        return brand_id;
    }

    public CarRequest setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CarRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getMark() {
        return mark;
    }

    public CarRequest setMark(String mark) {
        this.mark = mark;
        return this;
    }
}
