package monitoring_api_business.Service.Implementation;

import java.util.List;
import monitoring_api_business.Infrastructure.RuleSet;
import monitoring_api_business.Model.Implementation.Order;
import monitoring_api_business.Model.Implementation.State;
import monitoring_api_business.Model.Implementation.StateDiagram;
import monitoring_api_business.Repository.Contract.IOrderRepository;
import monitoring_api_business.Repository.Contract.IStateRepository;
import monitoring_api_business.Service.Contract.AService;

public final class StateDiagramService extends AService<StateDiagram, String, StateDiagram> {

  private final IStateRepository _stateRepository;
  private final IOrderRepository _orderRepository;

  public StateDiagramService(IOrderRepository orderRepository, IStateRepository stateRepository,
      RuleSet ruleSet) {
    super(ruleSet, ruleSet.CacheKeyPrefix());

    _stateRepository = stateRepository;
    _orderRepository = orderRepository;
  }


  @Override
  protected final StateDiagram GetEntityById(String id) {

    StateDiagram stateDiagram = new StateDiagram(1);

    Order order = _orderRepository.GetOrderByProcessingId(id);
    List<State> states = _stateRepository.GetAllByOrderProcessingId(id);

    StateDiagramSegmentUpdate(stateDiagram, states);

    return stateDiagram;
  }

  @Override
  protected final StateDiagram GetResultByFilter(String filter) {

    StateDiagram stateDiagram = new StateDiagram(1);
    List<Order> orders = _orderRepository.GetByFilter(filter);

    for (Order order : orders
    ) {
      List<State> states = _stateRepository.GetAllByOrderProcessingId(order.getProcessingId());

      StateDiagramSegmentUpdate(stateDiagram, states);
    }

    return stateDiagram;
  }

  @Override
  protected final StateDiagram GetAll() {
    StateDiagram stateDiagram = new StateDiagram(1);
    List<Order> orders = _orderRepository.GetAll();

    for (Order order : orders
    ) {
      List<State> states = _stateRepository.GetAllByOrderProcessingId(order.getProcessingId());

      StateDiagramSegmentUpdate(stateDiagram, states);
    }

    return stateDiagram;
  }

  private void StateDiagramSegmentUpdate(StateDiagram stateDiagram,
      List<State> states) {
    for (State state : states
    ) {
        stateDiagram.updateStateList(state.getType());
      }
  }
}

//select count(*), stateName from orderstates where [lefilter] groupby stateName