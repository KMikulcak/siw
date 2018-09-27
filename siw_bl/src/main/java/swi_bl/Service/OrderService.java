package swi_bl.Service;

import java.util.List;
import swi_bl.Infrastructure.RuleSet;
import swi_bl.Model.Order;
import swi_bl.Repository.IOrderRepository;

public final class OrderService extends AService<Order, Integer, List<Order>> {
  private final IOrderRepository _orderRepository;

  public OrderService(IOrderRepository orderRepository, RuleSet ruleSet) {
    super(ruleSet, ruleSet.CacheKeyPrefix());

    _orderRepository = orderRepository;
  }

  @Override
  Order GetEntityById(Integer id) {
    return _orderRepository.Get(id);
  }

  @Override
  List<Order> GetResultByFilter(String filter) {
    return _orderRepository.GetByFilter(filter);
  }

  @Override
  List<Order> GetAll() {
    return _orderRepository.GetAll();
  }
}
