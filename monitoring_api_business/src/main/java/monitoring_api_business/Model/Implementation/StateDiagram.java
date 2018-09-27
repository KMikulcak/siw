package monitoring_api_business.Model.Implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import monitoring_api_business.Model.Contract.IEntity;
import monitoring_api_business.Model.Implementation.State.StateType;

public class StateDiagram implements IEntity {

  private List<StateDiagramPoint> _stateList;
  private int _id;

  public StateDiagram(int id) {
    _id = id;
    _stateList = new ArrayList<StateDiagramPoint>(
        Arrays.asList(new StateDiagramPoint(StateType.Ordered, 0),
            new StateDiagramPoint(StateType.Generated, 0),
            new StateDiagramPoint(StateType.Enriched, 0),
            new StateDiagramPoint(StateType.Injected, 0),
            new StateDiagramPoint(StateType.OrderedError, 0),
            new StateDiagramPoint(StateType.GeneratedError, 0),
            new StateDiagramPoint(StateType.EnrichedError, 0),
            new StateDiagramPoint(StateType.InjectedError, 0)
        ));
  }

  @Override
  public int getId() {
    return _id;
  }

  public List<StateDiagramPoint> getStateList() {
    return _stateList;
  }

  public void updateStateList(StateType stateType) {
    _stateList.stream()
        .filter(point -> point.getState() == stateType)
        .findFirst().get().increaseCount(1);
  }

  class StateDiagramPoint {

    private int _count;
    private StateType _stateType;

    StateDiagramPoint(StateType stateType, int count) {
      _stateType = stateType;
      _count = count;
    }

    public StateType getState() {
      return _stateType;
    }

    public int getCount() {
      return _count;
    }

    public void increaseCount(int count){
      _count += count;
    }
  }
}
