package swi_dal.Repository;

import java.util.List;
import java.util.stream.Collectors;
import monitoring_api_business.Model.Implementation.State;
import monitoring_api_business.Repository.Contract.IStateRepository;
import swi_dal.DataSource.Contract.IDataSource;
import swi_dal.Mapping.Implementation.StateMapper;

public class StateRepository extends BaseRepository
    implements IStateRepository {

  private final StateMapper _mapper;

  public StateRepository(IDataSource dataSource) {
    super(dataSource);
    _mapper = new StateMapper();
  }

  @Override
  public List<State> GetAllByOrderProcessingId(String processingId) {
    List<swi_dal.Entity.Implementation.State> result = _dataSource.GetStates("").stream().filter(state -> processingId.equals(state.getProcessingId())).collect(
        Collectors.toList());
    return _mapper.MapEntity(result);
  }

  @Override
  public State Get(int id) {
    swi_dal.Entity.Implementation.State result = _dataSource.GetStates("").stream().filter(state -> id == state.getId())
        .findFirst()
        .orElse(null);

    if (result != null) {
      return _mapper.MapEntity(result);
    } else {
      return null;
    }
  }

  @Override
  public List<State> GetAll() {
    List<swi_dal.Entity.Implementation.State> states = _dataSource.GetStates("");
    return _mapper.MapEntity(states);
  }

  @Override
  public List<State> GetByFilter(String filter) {
    List<swi_dal.Entity.Implementation.State> states = _dataSource.GetStates(filter);
    return _mapper.MapEntity(states.subList(0, 3));
  }
}
