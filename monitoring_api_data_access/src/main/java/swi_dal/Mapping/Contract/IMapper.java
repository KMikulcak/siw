package swi_dal.Mapping.Contract;

import java.util.List;
import monitoring_api_business.Model.Contract.IModel;
import swi_dal.Entity.Contract.BaseEntity;

public interface IMapper<Entity extends BaseEntity, Model extends IModel> {

  public Model MapEntity(Entity entity);

  public List<Model> MapEntity(List<Entity> entities);

  public Entity MapModel(Model model);

  public List<Entity> MapModel(List<Model> models);
}
