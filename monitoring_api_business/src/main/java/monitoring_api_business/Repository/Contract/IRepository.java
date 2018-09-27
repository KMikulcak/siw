package monitoring_api_business.Repository.Contract;

import java.util.List;
import monitoring_api_business.Model.Contract.IEntity;

interface IRepository<Entity extends IEntity> {

  public Entity Get(int id);

  public List<Entity> GetAll();

  public List<Entity> GetByFilter(String filter);
}
