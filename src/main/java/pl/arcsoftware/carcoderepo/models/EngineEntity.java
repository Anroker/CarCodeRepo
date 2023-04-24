package pl.arcsoftware.carcoderepo.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "engine", schema = "public", catalog = "carhistorytempDB")
public class EngineEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "code", nullable = true, length = 45)
    private String code;
    @Basic
    @Column(name = "size", nullable = true, precision = 0)
    private BigInteger size;
//    @Basic
//    @Column(name = "model_id", nullable = true)
//    private Integer modelId;
    @Basic
    @Column(name = "created_at", nullable = true)
    private OffsetDateTime createdAt;
    @Basic
    @Column(name = "modified_at", nullable = true)
    private OffsetDateTime modifiedAt;
    @OneToMany(mappedBy = "engineByEngineId")
    private Collection<CarEntity> carsById;
    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private ModelEntity modelByModelId;

    public Integer getId() {
        return id;
    }

    public EngineEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public EngineEntity setCode(String code) {
        this.code = code;
        return this;
    }

    public BigInteger getSize() {
        return size;
    }

    public EngineEntity setSize(BigInteger size) {
        this.size = size;
        return this;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public EngineEntity setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Object getModifiedAt() {
        return modifiedAt;
    }

    public EngineEntity setModifiedAt(OffsetDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    public Collection<CarEntity> getCarsById() {
        return carsById;
    }

    public EngineEntity setCarsById(Collection<CarEntity> carsById) {
        this.carsById = carsById;
        return this;
    }

    public ModelEntity getModelByModelId() {
        return modelByModelId;
    }

    public EngineEntity setModelByModelId(ModelEntity modelByModelId) {
        this.modelByModelId = modelByModelId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EngineEntity that = (EngineEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(code, that.code) && Objects.equals(size, that.size) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, size, createdAt, modifiedAt);
    }

}
