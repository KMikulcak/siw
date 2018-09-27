package swi_dal.Mapping.Contract;

import java.util.List;
import monitoring_api_business.Model.Contract.IEntity;

public interface IMapper<Dto, Entity extends IEntity> {

  public Entity MapDto(Dto dto);

  public List<Entity> MapDto(List<Dto> dtos);

  public Dto MapEntity(Entity entity);

  public List<Dto> MapEntity(List<Entity> entities);
}
