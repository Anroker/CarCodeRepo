/*
package pl.arcsoftware.carcoderepo.models.newModels;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "model_engine", schema = "public", catalog = "carhistorytempDB")
public class ModelEngineEntity {
    @Basic
    @Column(name = "model_id", nullable = true)
    private Integer modelId;
    @Basic
    @Column(name = "engine_id", nullable = true)
    private Integer engineId;
    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private ModelEntity modelByModelId;
    @ManyToOne
    @JoinColumn(name = "engine_id", referencedColumnName = "id")
    private EngineEntity engineByEngineId;

    public Integer getModelId() {
        return modelId;
    }

    public ModelEngineEntity setModelId(Integer modelId) {
        this.modelId = modelId;
        return this;
    }

    public Integer getEngineId() {
        return engineId;
    }

    public ModelEngineEntity setEngineId(Integer engineId) {
        this.engineId = engineId;
        return this;
    }

    public ModelEntity getModelByModelId() {
        return modelByModelId;
    }

    public ModelEngineEntity setModelByModelId(ModelEntity modelByModelId) {
        this.modelByModelId = modelByModelId;
        return this;
    }

    public EngineEntity getEngineByEngineId() {
        return engineByEngineId;
    }

    public ModelEngineEntity setEngineByEngineId(EngineEntity engineByEngineId) {
        this.engineByEngineId = engineByEngineId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelEngineEntity that = (ModelEngineEntity) o;
        return Objects.equals(modelId, that.modelId) && Objects.equals(engineId, that.engineId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelId, engineId);
    }

}
*/
