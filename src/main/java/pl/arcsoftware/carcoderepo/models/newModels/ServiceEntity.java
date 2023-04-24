package pl.arcsoftware.carcoderepo.models.newModels;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "service", schema = "public", catalog = "carhistorytempDB")
public class ServiceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Object createdAt;
    @Basic
    @Column(name = "modified_at", nullable = true)
    private Object modifiedAt;
    @OneToMany(mappedBy = "serviceByServiceId")
    private Collection<MaintenanceEntity> maintenancesById;

    public Integer getId() {
        return id;
    }

    public ServiceEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ServiceEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public ServiceEntity setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Object getModifiedAt() {
        return modifiedAt;
    }

    public ServiceEntity setModifiedAt(Object modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    public Collection<MaintenanceEntity> getMaintenancesById() {
        return maintenancesById;
    }

    public ServiceEntity setMaintenancesById(Collection<MaintenanceEntity> maintenancesById) {
        this.maintenancesById = maintenancesById;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceEntity that = (ServiceEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdAt, modifiedAt);
    }


}
