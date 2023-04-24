package pl.arcsoftware.carcoderepo.models.newModels;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "model", schema = "public", catalog = "carhistorytempDB")
public class ModelEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Basic
    @Column(name = "mark", nullable = true, length = 45)
    private String mark;
    @Basic
    @Column(name = "brand_id", nullable = true)
    private Integer brandId;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Object createdAt;
    @Basic
    @Column(name = "modified_at", nullable = true)
    private Object modifiedAt;
    @OneToMany(mappedBy = "modelByModelId")
    private Collection<CarEntity> carsById;
    @OneToMany(mappedBy = "modelByModelId")
    private Collection<EngineEntity> enginesById;
    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private BrandEntity brandByBrandId;
    @OneToMany(mappedBy = "modelByModelId")
    private Collection<ModelEngineEntity> modelEnginesById;

    public Integer getId() {
        return id;
    }

    public ModelEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ModelEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getMark() {
        return mark;
    }

    public ModelEntity setMark(String mark) {
        this.mark = mark;
        return this;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public ModelEntity setBrandId(Integer brandId) {
        this.brandId = brandId;
        return this;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public ModelEntity setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Object getModifiedAt() {
        return modifiedAt;
    }

    public ModelEntity setModifiedAt(Object modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    public Collection<EngineEntity> getEnginesById() {
        return enginesById;
    }

    public ModelEntity setEnginesById(Collection<EngineEntity> enginesById) {
        this.enginesById = enginesById;
        return this;
    }

    public BrandEntity getBrandByBrandId() {
        return brandByBrandId;
    }

    public ModelEntity setBrandByBrandId(BrandEntity brandByBrandId) {
        this.brandByBrandId = brandByBrandId;
        return this;
    }

    public Collection<ModelEngineEntity> getModelEnginesById() {
        return modelEnginesById;
    }

    public ModelEntity setModelEnginesById(Collection<ModelEngineEntity> modelEnginesById) {
        this.modelEnginesById = modelEnginesById;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelEntity that = (ModelEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(mark, that.mark) && Objects.equals(brandId, that.brandId) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mark, brandId, createdAt, modifiedAt);
    }

    public Collection<CarEntity> getCarsById() {
        return carsById;
    }

    public ModelEntity setCarsById(Collection<CarEntity> carsById) {
        this.carsById = carsById;
        return this;
    }

}
