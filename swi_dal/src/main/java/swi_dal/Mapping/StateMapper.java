package swi_dal.Mapping;

import java.util.ArrayList;
import java.util.List;
import swi_bl.Model.State.StateType;
import swi_dal.Dto.State;

public class StateMapper implements IMapper<State, swi_bl.Model.State> {

  @Override
  public swi_bl.Model.State MapDto(State dto) {
    return new swi_bl.Model.State(dto.Id(), StateType.fromVal(dto.Type()), dto.ProcessingId(),
        dto.Time());
  }

  @Override
  public List<swi_bl.Model.State> MapDto(List<State> states) {
    List<swi_bl.Model.State> entities = new ArrayList<swi_bl.Model.State>();
    for (State state : states) {
      entities.add(MapDto(state));
    }
    return entities;
  }

  @Override
  public State MapEntity(swi_bl.Model.State entity) {
    return null;
  }

  @Override
  public List<State> MapEntity(List<swi_bl.Model.State> states) {
    return null;
  }
}
