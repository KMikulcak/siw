package swi_bl.Service;

import java.util.List;
import swi_bl.Infrastructure.RuleSet;
import swi_bl.Model.State;
import swi_bl.Repository.IStateRepository;

public final class StateService extends AService<State, Integer, List<State>> {

  private final IStateRepository _stateRepository;

  public StateService(IStateRepository stateRepository, RuleSet ruleSet) {
    super(ruleSet, ruleSet.CacheKeyPrefix());

    _stateRepository = stateRepository;
  }

  @Override
  State GetEntityById(Integer id) {
    return _stateRepository.Get(id);
  }

  @Override
  List<State> GetResultByFilter(String filter) {
    return _stateRepository.GetByFilter(filter);
  }

  @Override
  List<State> GetAll() {
    return _stateRepository.GetAll();
  }
}
