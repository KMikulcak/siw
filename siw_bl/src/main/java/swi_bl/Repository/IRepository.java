package swi_bl.Repository;

import java.util.List;
import swi_bl.Model.IEntity;

interface IRepository<Entity extends IEntity> {

  public Entity Get(int id);

  public List<Entity> GetAll();

  public List<Entity> GetByFilter(String filter);
}
