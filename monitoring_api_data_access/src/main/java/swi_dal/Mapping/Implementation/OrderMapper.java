package swi_dal.Mapping.Implementation;

import java.util.ArrayList;
import java.util.List;
import swi_dal.Entity.Implementation.Order;
import swi_dal.Mapping.Contract.IMapper;

public class OrderMapper implements IMapper<Order, monitoring_api_business.Model.Implementation.Order> {

  @Override
  public monitoring_api_business.Model.Implementation.Order MapEntity(Order order) {
    return new monitoring_api_business.Model.Implementation.Order(order.getId(), order.getProcessingId());
  }

  @Override
  public List<monitoring_api_business.Model.Implementation.Order> MapEntity(List<Order> orders) {
    List<monitoring_api_business.Model.Implementation.Order> entities = new ArrayList<monitoring_api_business.Model.Implementation.Order>();
    for (Order order : orders) {
      entities.add(MapEntity(order));
    }
    return entities;
  }

  @Override
  public Order MapModel(monitoring_api_business.Model.Implementation.Order order) {
    return null;
  }

  @Override
  public List<Order> MapModel(List<monitoring_api_business.Model.Implementation.Order> orders) {
    return null;
  }
}
