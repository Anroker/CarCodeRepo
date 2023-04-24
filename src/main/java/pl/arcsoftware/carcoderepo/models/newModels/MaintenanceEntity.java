/*
package pl.arcsoftware.carcoderepo.models.newModels;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "maintenance", schema = "public", catalog = "carhistorytempDB")
public class MaintenanceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "car_id", nullable = true, insertable = false, updatable = false)
    private Integer carId;
    @Basic
    @Column(name = "company_id", nullable = true, insertable = false, updatable = false)
    private Integer companyId;
    @Basic
    @Column(name = "service_id", nullable = true, insertable = false, updatable = false)
    private Integer serviceId;
    @Basic
    @Column(name = "rate", nullable = true)
    private Integer rate;
    @Basic
    @Column(name = "car_mileage", nullable = true)
    private Integer carMileage;
    @Basic
    @Column(name = "created_at", nullable = true)
    private OffsetDateTime createdAt;
    @Basic
    @Column(name = "modified_at", nullable = true)
    private OffsetDateTime modifiedAt;
    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private CarEntity carByCarId;
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private CompanyEntity companyByCompanyId;
    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private ServiceEntity serviceByServiceId;

    public Integer getId() {
        return id;
    }

    public MaintenanceEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getCarId() {
        return carId;
    }

    public MaintenanceEntity setCarId(Integer carId) {
        this.carId = carId;
        return this;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public MaintenanceEntity setCompanyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public MaintenanceEntity setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public Integer getRate() {
        return rate;
    }

    public MaintenanceEntity setRate(Integer rate) {
        this.rate = rate;
        return this;
    }

    public Integer getCarMileage() {
        return carMileage;
    }

    public MaintenanceEntity setCarMileage(Integer carMileage) {
        this.carMileage = carMileage;
        return this;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public MaintenanceEntity setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Object getModifiedAt() {
        return modifiedAt;
    }

    public MaintenanceEntity setModifiedAt(OffsetDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    public CarEntity getCarByCarId() {
        return carByCarId;
    }

    public MaintenanceEntity setCarByCarId(CarEntity carByCarId) {
        this.carByCarId = carByCarId;
        return this;
    }

    public CompanyEntity getCompanyByCompanyId() {
        return companyByCompanyId;
    }

    public MaintenanceEntity setCompanyByCompanyId(CompanyEntity companyByCompanyId) {
        this.companyByCompanyId = companyByCompanyId;
        return this;
    }

    public ServiceEntity getServiceByServiceId() {
        return serviceByServiceId;
    }

    public MaintenanceEntity setServiceByServiceId(ServiceEntity serviceByServiceId) {
        this.serviceByServiceId = serviceByServiceId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaintenanceEntity that = (MaintenanceEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(carId, that.carId) && Objects.equals(companyId, that.companyId) && Objects.equals(serviceId, that.serviceId) && Objects.equals(rate, that.rate) && Objects.equals(carMileage, that.carMileage) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carId, companyId, serviceId, rate, carMileage, createdAt, modifiedAt);
    }
}
*/
