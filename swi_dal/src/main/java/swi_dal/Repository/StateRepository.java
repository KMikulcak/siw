package swi_dal.Repository;

import java.util.List;
import swi_bl.Model.State;
import swi_bl.Repository.IStateRepository;
import swi_dal.DataSource.IDataSource;
import swi_dal.Mapping.StateMapper;

public class StateRepository extends BaseRepository
    implements IStateRepository {

  private final StateMapper _mapper;

  public StateRepository(IDataSource dataSource) {
    super(dataSource);
    _mapper = new StateMapper();
  }

  @Override
  public List<State> GetAllByOrderProcessingId(String processingId) {
    List<swi_dal.Dto.State> states = _dataSource.GetStates("where processingId=" + processingId);
    return _mapper.MapDto(states.subList(0, 3));
  }

  @Override
  public State Get(int id) {
    swi_dal.Dto.State result =  _dataSource.GetStates("").stream().filter(state -> id == state.Id())
        .findFirst()
        .orElse(null);

    if(result!=null) return _mapper.MapDto(result);
    else return null;
  }

  @Override
  public List<State> GetAll() {
    List<swi_dal.Dto.State> states = _dataSource.GetStates("");
    return _mapper.MapDto(states);
  }

  @Override
  public List<State> GetByFilter(String filter) {
    List<swi_dal.Dto.State> states = _dataSource.GetStates(filter);
    return _mapper.MapDto(states.subList(0, 3));
  }
}
