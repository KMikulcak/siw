package swi_dal.Mapping;

import java.util.ArrayList;
import java.util.List;
import swi_dal.Dto.Order;

public class OrderMapper implements IMapper<Order, swi_bl.Model.Order> {

  @Override
  public swi_bl.Model.Order MapDto(Order order) {
    return new swi_bl.Model.Order(order.Id(), order.ProcessingId());
  }

  @Override
  public List<swi_bl.Model.Order> MapDto(List<Order> orders) {
    List<swi_bl.Model.Order> entities = new ArrayList<swi_bl.Model.Order>();
    for (Order order : orders) {
      entities.add(MapDto(order));
    }
    return entities;
  }

  @Override
  public Order MapEntity(swi_bl.Model.Order entity) {
    return null;
  }

  @Override
  public List<Order> MapEntity(List<swi_bl.Model.Order> orders) {
    return null;
  }
}
