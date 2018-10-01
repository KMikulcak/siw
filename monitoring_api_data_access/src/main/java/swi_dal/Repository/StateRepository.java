package swi_dal.Repository;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.NoResultException;
import monitoring_api_business.Model.Implementation.State;
import monitoring_api_business.Repository.Contract.IStateRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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
    Criteria criteria = _dataSource.Session().createCriteria(swi_dal.Entity.Implementation.State.class);
    criteria.add(Restrictions.eq("processingId",processingId));

    try {
      return _mapper.MapEntity(  criteria.list());
    } catch (final NoResultException nre) {
      return null;
    }
  }

  @Override
  public State Get(int id) {
    /*swi_dal.Entity.Implementation.State result = _dataSource.GetStates("").stream().filter(state -> id == state.getId())
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
    /*
    List<swi_dal.Entity.Implementation.State> states = _dataSource.GetStates("");
    return _mapper.MapEntity(states); */
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
