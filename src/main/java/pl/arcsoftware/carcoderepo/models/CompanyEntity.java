/*
package pl.arcsoftware.carcoderepo.models.newModels;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "company", schema = "public", catalog = "carhistorytempDB")
public class CompanyEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Basic
    @Column(name = "address", nullable = true, length = 4000)
    private String address;
    @Basic
    @Column(name = "created_at", nullable = true)
    private OffsetDateTime createdAt;
    @Basic
    @Column(name = "modified_at", nullable = true)
    private OffsetDateTime modifiedAt;
    @OneToMany(mappedBy = "companyByCompanyId")
    private Collection<MaintenanceEntity> maintenancesById;

    public Long getId() {
        return id;
    }

    public CompanyEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CompanyEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CompanyEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public CompanyEntity setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Object getModifiedAt() {
        return modifiedAt;
    }

    public CompanyEntity setModifiedAt(OffsetDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    public Collection<MaintenanceEntity> getMaintenancesById() {
        return maintenancesById;
    }

    public CompanyEntity setMaintenancesById(Collection<MaintenanceEntity> maintenancesById) {
        this.maintenancesById = maintenancesById;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyEntity that = (CompanyEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, createdAt, modifiedAt);
    }

}
*/
