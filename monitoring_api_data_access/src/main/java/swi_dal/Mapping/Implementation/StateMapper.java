package swi_dal.Mapping.Implementation;

import java.util.ArrayList;
import java.util.List;
import monitoring_api_business.Model.Implementation.State.StateType;
import swi_dal.Dto.State;
import swi_dal.Mapping.Contract.IMapper;

public class StateMapper implements IMapper<State, monitoring_api_business.Model.Implementation.State> {

  @Override
  public monitoring_api_business.Model.Implementation.State MapDto(State dto) {
    return new monitoring_api_business.Model.Implementation.State(dto.Id(), StateType.fromVal(dto.Type()), dto.ProcessingId(),
        dto.Time());
  }

  @Override
  public List<monitoring_api_business.Model.Implementation.State> MapDto(List<State> states) {
    List<monitoring_api_business.Model.Implementation.State> entities = new ArrayList<monitoring_api_business.Model.Implementation.State>();
    for (State state : states) {
      entities.add(MapDto(state));
    }
    return entities;
  }

  @Override
  public State MapEntity(monitoring_api_business.Model.Implementation.State entity) {
    return null;
  }

  @Override
  public List<State> MapEntity(List<monitoring_api_business.Model.Implementation.State> states) {
    return null;
  }
}
