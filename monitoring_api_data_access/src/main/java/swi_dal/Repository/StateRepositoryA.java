package swi_dal.Repository;

import java.util.List;
import monitoring_api_business.Model.Implementation.State;
import monitoring_api_business.Repository.Contract.IStateRepository;
import swi_dal.DataSource.Contract.IDataSource;
import swi_dal.Mapping.Implementation.StateMapper;

public class StateRepositoryA extends ABaseRepository<Integer, swi_dal.Entity.Implementation.State>
    implements IStateRepository {

  private final StateMapper _mapper;

  public StateRepositoryA(IDataSource dataSource) {
    super(swi_dal.Entity.Implementation.State.class, dataSource);
    _mapper = new StateMapper();
  }

  @Override
  public List<State> GetAllByOrderProcessingId(String processingId) {
    List<swi_dal.Entity.Implementation.State> result = query().where().icontains("processingId", processingId).findList();
    return _mapper.MapEntity(result);
  }

  @Override
  public State Get(int id) {
    /*
    swi_dal.Entity.Implementation.State result = _dataSource.GetStates("").stream().filter(state -> id == state.getId())
        .findFirst()
        .orElse(null);

    if (result != null) {
      return _mapper.MapEntity(result);
    } else {
      return null;
    }*/
    return null;
  }

  @Override
  public List<State> GetAll() {
    /*List<swi_dal.Entity.Implementation.State> states = _dataSource.GetStates("");
    return _mapper.MapEntity(states);*/
    return null;
  }

  @Override
  public List<State> GetByFilter(String filter) {
    /*
    List<swi_dal.Entity.Implementation.State> states = _dataSource.GetStates(filter);
    return _mapper.MapEntity(states.subList(0, 3));*/
    return null;
  }
}
