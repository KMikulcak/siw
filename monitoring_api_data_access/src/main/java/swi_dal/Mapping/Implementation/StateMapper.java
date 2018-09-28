package swi_dal.Mapping.Implementation;

import java.util.ArrayList;
import java.util.List;
import monitoring_api_business.Model.Implementation.State.StateType;
import swi_dal.Entity.Implementation.State;
import swi_dal.Mapping.Contract.IMapper;

public class StateMapper implements IMapper<State, monitoring_api_business.Model.Implementation.State> {

  @Override
  public monitoring_api_business.Model.Implementation.State MapEntity(State state) {
    return new monitoring_api_business.Model.Implementation.State(state.getId(), StateType.fromVal(state.getStateType()), state.getProcessingId(),
        state.getTimeStampe());
  }

  @Override
  public List<monitoring_api_business.Model.Implementation.State> MapEntity(List<State> states) {
    List<monitoring_api_business.Model.Implementation.State> entities = new ArrayList<monitoring_api_business.Model.Implementation.State>();
    for (State state : states) {
      entities.add(MapEntity(state));
    }
    return entities;
  }

  @Override
  public State MapModel(monitoring_api_business.Model.Implementation.State state) {
    return null;
  }

  @Override
  public List<State> MapModel(List<monitoring_api_business.Model.Implementation.State> states) {
    return null;
  }
}
