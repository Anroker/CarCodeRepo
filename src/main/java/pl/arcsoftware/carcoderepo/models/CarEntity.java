package pl.arcsoftware.carcoderepo.models;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "car", schema = "public", catalog = "carhistorytempDB")
public class CarEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "vin", nullable = true, length = 45)
    private String vin;
    @Basic
    @Column(name = "year_of_production", nullable = true, length = 4)
    private String yearOfProduction;
//    @Basic
//    @Column(name = "model_id", nullable = true)
//    private Long modelId;
//    @Basic
//    @Column(name = "engine_id", nullable = true)
//    private Long engineId;
//    @Basic
//    @Column(name = "user_id", nullable = true)
//    private Long userId;
    @Basic
    @Column(name = "created_at", nullable = true)
    private OffsetDateTime createdAt;
    @Basic
    @Column(name = "modified_at", nullable = true)
    private OffsetDateTime modifiedAt;
    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private ModelEntity model;
    @ManyToOne
    @JoinColumn(name = "engine_id", referencedColumnName = "id")
    private EngineEntity engineByEngineId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UsersEntity user;
/*    @OneToMany(mappedBy = "carByCarId")
    private Collection<FuelNoteEntity> fuelNotesById;
    @OneToMany(mappedBy = "carByCarId")
    private Collection<MaintenanceEntity> maintenancesById;*/

    public Long getId() {
        return id;
    }

    public CarEntity setId(Long id) {
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



    public Object getCreatedAt() {
        return createdAt;
    }

    public CarEntity setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Object getModifiedAt() {
        return modifiedAt;
    }

    public CarEntity setModifiedAt(OffsetDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

/*    public ModelEntity getModelByModelId() {
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
    }*/

    public UsersEntity getUsersByUserId() {
        return user;
    }

    public CarEntity setUsersByUserId(UsersEntity usersByUserId) {
        this.user = usersByUserId;
        return this;
    }

/*    public Collection<FuelNoteEntity> getFuelNotesById() {
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
    }*/

    public ModelEntity getModel() {
        return model;
    }

    public CarEntity setModel(ModelEntity modelByModelId) {
        this.model = modelByModelId;
        return this;
    }

    public EngineEntity getEngineByEngineId() {
        return engineByEngineId;
    }

    public CarEntity setEngineByEngineId(EngineEntity engineByEngineId) {
        this.engineByEngineId = engineByEngineId;
        return this;
    }

    public UsersEntity getUser() {
        return user;
    }

    public CarEntity setUser(UsersEntity user) {
        this.user = user;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEntity carEntity = (CarEntity) o;
        return Objects.equals(id, carEntity.id) && Objects.equals(vin, carEntity.vin) && Objects.equals(yearOfProduction, carEntity.yearOfProduction) && Objects.equals(createdAt, carEntity.createdAt) && Objects.equals(modifiedAt, carEntity.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vin, yearOfProduction, createdAt, modifiedAt);
    }
}
