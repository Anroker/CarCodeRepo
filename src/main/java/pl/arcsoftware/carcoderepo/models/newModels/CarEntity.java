package pl.arcsoftware.carcoderepo.models.newModels;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "car", schema = "public", catalog = "carhistorytempDB")
public class CarEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "vin", nullable = true, length = 45)
    private String vin;
    @Basic
    @Column(name = "year_of_production", nullable = true, length = 4)
    private String yearOfProduction;
    @Basic
    @Column(name = "model_id", nullable = true)
    private Integer modelId;
    @Basic
    @Column(name = "engine_id", nullable = true)
    private Integer engineId;
    @Basic
    @Column(name = "user_id", nullable = true)
    private Integer userId;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Object createdAt;
    @Basic
    @Column(name = "modified_at", nullable = true)
    private Object modifiedAt;
    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private ModelEntity modelByModelId;
    @ManyToOne
    @JoinColumn(name = "engine_id", referencedColumnName = "id")
    private EngineEntity engineByEngineId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UsersEntity usersByUserId;
    @OneToMany(mappedBy = "carByCarId")
    private Collection<FuelNoteEntity> fuelNotesById;
    @OneToMany(mappedBy = "carByCarId")
    private Collection<MaintenanceEntity> maintenancesById;

    public Integer getId() {
        return id;
    }

    public CarEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getVin() {
        return vin;
    }

    public CarEntity setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public String getYearOfProduction() {
        return yearOfProduction;
    }

    public CarEntity setYearOfProduction(String yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
        return this;
    }

    public Integer getModelId() {
        return modelId;
    }

    public CarEntity setModelId(Integer modelId) {
        this.modelId = modelId;
        return this;
    }

    public Integer getEngineId() {
        return engineId;
    }

    public CarEntity setEngineId(Integer engineId) {
        this.engineId = engineId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public CarEntity setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public CarEntity setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Object getModifiedAt() {
        return modifiedAt;
    }

    public CarEntity setModifiedAt(Object modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    public ModelEntity getModelByModelId() {
        return modelByModelId;
    }

    public CarEntity setModelByModelId(ModelEntity modelByModelId) {
        this.modelByModelId = modelByModelId;
        return this;
    }

    public EngineEntity getEngineByEngineId() {
        return engineByEngineId;
    }

    public CarEntity setEngineByEngineId(EngineEntity engineByEngineId) {
        this.engineByEngineId = engineByEngineId;
        return this;
    }

    public UsersEntity getUsersByUserId() {
        return usersByUserId;
    }

    public CarEntity setUsersByUserId(UsersEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
        return this;
    }

    public Collection<FuelNoteEntity> getFuelNotesById() {
        return fuelNotesById;
    }

    public CarEntity setFuelNotesById(Collection<FuelNoteEntity> fuelNotesById) {
        this.fuelNotesById = fuelNotesById;
        return this;
    }

    public Collection<MaintenanceEntity> getMaintenancesById() {
        return maintenancesById;
    }

    public CarEntity setMaintenancesById(Collection<MaintenanceEntity> maintenancesById) {
        this.maintenancesById = maintenancesById;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEntity carEntity = (CarEntity) o;
        return Objects.equals(id, carEntity.id) && Objects.equals(vin, carEntity.vin) && Objects.equals(yearOfProduction, carEntity.yearOfProduction) && Objects.equals(modelId, carEntity.modelId) && Objects.equals(engineId, carEntity.engineId) && Objects.equals(userId, carEntity.userId) && Objects.equals(createdAt, carEntity.createdAt) && Objects.equals(modifiedAt, carEntity.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vin, yearOfProduction, modelId, engineId, userId, createdAt, modifiedAt);
    }
}
