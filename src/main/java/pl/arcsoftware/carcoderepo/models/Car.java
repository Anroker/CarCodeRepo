package pl.arcsoftware.carcoderepo.models;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user_car")
public class Car {
    @Id
    @SequenceGenerator(name = "user_car_id_seq",
            sequenceName = "user_car_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_car_id_seq")
    private Long id;

    private String model;

    private String engine;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "year_of_production")
    private short year_of_production;

    @Size(min = 17, max = 17)
    private String vin;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public short getYear_of_production() {
        return year_of_production;
    }

    public Car setYear_of_production(short yearOfProduction) {
        this.year_of_production = yearOfProduction;
        return this;
    }

    public String getVin() {
        return vin;
    }

    public Car setVin(String vin) {
        this.vin = vin;
        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", engine='" + engine + '\'' +
                ", user=" + user.getUsername() +
                ", year_of_production=" + year_of_production +
                ", vin='" + vin + '\'' +
                '}';
    }
}
