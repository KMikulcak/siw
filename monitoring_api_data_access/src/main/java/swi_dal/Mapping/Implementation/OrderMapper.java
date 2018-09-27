package swi_dal.Mapping.Implementation;

import java.util.ArrayList;
import java.util.List;
import swi_dal.Dto.Order;
import swi_dal.Mapping.Contract.IMapper;

public class OrderMapper implements IMapper<Order, monitoring_api_business.Model.Implementation.Order> {

  @Override
  public monitoring_api_business.Model.Implementation.Order MapDto(Order order) {
    return new monitoring_api_business.Model.Implementation.Order(order.Id(), order.ProcessingId());
  }

  @Override
  public List<monitoring_api_business.Model.Implementation.Order> MapDto(List<Order> orders) {
    List<monitoring_api_business.Model.Implementation.Order> entities = new ArrayList<monitoring_api_business.Model.Implementation.Order>();
    for (Order order : orders) {
      entities.add(MapDto(order));
    }
    return entities;
  }

  @Override
  public Order MapEntity(monitoring_api_business.Model.Implementation.Order entity) {
    return null;
  }

  @Override
  public List<Order> MapEntity(List<monitoring_api_business.Model.Implementation.Order> orders) {
    return null;
  }
}
