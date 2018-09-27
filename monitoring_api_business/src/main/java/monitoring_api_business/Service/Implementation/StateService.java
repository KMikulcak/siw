package monitoring_api_business.Service.Implementation;

import java.util.List;
import monitoring_api_business.Infrastructure.RuleSet;
import monitoring_api_business.Model.Implementation.State;
import monitoring_api_business.Repository.Contract.IStateRepository;
import monitoring_api_business.Service.Contract.AService;

public final class StateService extends AService<State, Integer, List<State>> {

  private final IStateRepository _stateRepository;

  public StateService(IStateRepository stateRepository, RuleSet ruleSet) {
    super(ruleSet, ruleSet.CacheKeyPrefix());

    _stateRepository = stateRepository;
  }

  @Override
  protected final State GetEntityById(Integer id) {
    return _stateRepository.Get(id);
  }

  @Override
  protected final List<State> GetResultByFilter(String filter) {
    return _stateRepository.GetByFilter(filter);
  }

  @Override
  protected final List<State> GetAll() {
    return _stateRepository.GetAll();
  }
}
