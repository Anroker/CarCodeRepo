/*
package pl.arcsoftware.carcoderepo.models;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private String engine;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity usersEntity;

    @Column(name = "year_of_production")
    private short year_of_production;

    @Size(min = 17, max = 17)
    private String vin;

    public Long getId() {
        return id;
    }

    public Car setId(Long id) {
        this.id = id;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public Car setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public UsersEntity getUser() {
        return usersEntity;
    }

    public Car setUser(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
        return this;
    }

    public short getYear_of_production() {
        return year_of_production;
    }

    public Car setYear_of_production(short year_of_production) {
        this.year_of_production = year_of_production;
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
                ", user=" + usersEntity.getUsername() +
                ", year_of_production=" + year_of_production +
                ", vin='" + vin + '\'' +
                '}';
    }
}
*/
