package monitoring_api_business.Service.Implementation;

import java.util.List;
import monitoring_api_business.Infrastructure.RuleSet;
import monitoring_api_business.Model.Implementation.Order;
import monitoring_api_business.Repository.Contract.IOrderRepository;
import monitoring_api_business.Service.Contract.AService;

public final class OrderService extends AService<Order, Integer, List<Order>> {

  private final IOrderRepository _orderRepository;

  public OrderService(IOrderRepository orderRepository, RuleSet ruleSet) {
    super(ruleSet, ruleSet.CacheKeyPrefix());

    _orderRepository = orderRepository;
  }

  @Override
  protected final Order GetEntityById(Integer id) {
    return _orderRepository.Get(id);
  }

  @Override
  protected final List<Order> GetResultByFilter(String filter) {
    return _orderRepository.GetByFilter(filter);
  }

  @Override
  protected final List<Order> GetAll() {
    return _orderRepository.GetAll();
  }
}
