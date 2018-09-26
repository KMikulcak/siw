package swi_bl.Service;

import java.util.ArrayList;
import java.util.List;
import swi_bl.Infrastructure.RuleSet;
import swi_bl.Model.Order;
import swi_bl.Model.State;
import swi_bl.Model.StateDiagram;
import swi_bl.Repository.IOrderRepository;
import swi_bl.Repository.IStateRepository;

public class StateDiagramService extends AService<StateDiagram, String, StateDiagram> {

  private final IStateRepository _stateRepository;
  private final IOrderRepository _orderRepository;

  public StateDiagramService(IOrderRepository orderRepository, IStateRepository stateRepository,
      RuleSet ruleSet) {
    super(ruleSet, ruleSet.CacheKeyPrefix());

    _stateRepository = stateRepository;
    _orderRepository = orderRepository;
  }


  @Override
  StateDiagram GetEntityById(String id) {

    StateDiagram stateDiagram = new StateDiagram(1);
    Order order = _orderRepository.GetOrderByProcessingId(id);
    List<State> states = _stateRepository.GetAllByOrderProcessingId(id);

    StateDiagramSegmentBuilder(stateDiagram, order, states);

    return stateDiagram;
  }

  @Override
  StateDiagram GetResultByFilter(String filter) {

    StateDiagram stateDiagram = new StateDiagram(1);
    List<Order> orders = _orderRepository.GetByFilter(filter);

    for (Order order:orders
    ) {
      List<State> states = _stateRepository.GetAllByOrderProcessingId(order.ProcessingId());

      StateDiagramSegmentBuilder(stateDiagram, order, states);
    }

    return stateDiagram;
  }

  private void StateDiagramSegmentBuilder(StateDiagram stateDiagram, Order order, List<State> states){
    for (State state:states
    ) {
      switch (state.Type()){
        case Ordered:
          stateDiagram.addOrdered(state, 1, 0);
          break;
        case Enriched:
          stateDiagram.addEnriched(state, 1, 0);
          break;
        case Generated:
          stateDiagram.addGenerated(state, 1, 0);
          break;
        case Injected:
          stateDiagram.addInjected(state, 1, 0);
          break;
        case OrderedError:
          stateDiagram.addOrdered(state, 0, 1);
          break;
        case EnrichedError:
          stateDiagram.addEnriched(state, 0, 1);
          break;
        case GeneratedError:
          stateDiagram.addGenerated(state, 0, 1);
          break;
        case InjectedError:
          stateDiagram.addInjected(state, 0, 1);
          break;
      }
    }
  }
}
