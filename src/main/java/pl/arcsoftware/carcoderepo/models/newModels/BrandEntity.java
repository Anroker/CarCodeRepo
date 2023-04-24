package pl.arcsoftware.carcoderepo.models.newModels;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "brand", schema = "public", catalog = "carhistorytempDB")
public class BrandEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Basic
    @Column(name = "created_at", nullable = true)
    private OffsetDateTime createdAt;
    @Basic
    @Column(name = "modified_at", nullable = true)
    private OffsetDateTime modifiedAt;
    @OneToMany(mappedBy = "brandByBrandId")
    private Collection<ModelEntity> modelsById;

    public Integer getId() {
        return id;
    }

    public BrandEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BrandEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public BrandEntity setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Object getModifiedAt() {
        return modifiedAt;
    }

    public BrandEntity setModifiedAt(OffsetDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    public Collection<ModelEntity> getModelsById() {
        return modelsById;
    }

    public BrandEntity setModelsById(Collection<ModelEntity> modelsById) {
        this.modelsById = modelsById;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandEntity that = (BrandEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdAt, modifiedAt);
    }
}
