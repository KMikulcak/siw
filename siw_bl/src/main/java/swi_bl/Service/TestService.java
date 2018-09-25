package swi_bl.Service;

import java.util.List;
import swi_bl.Infrastructure.Cache;
import swi_bl.Infrastructure.RuleSet;
import swi_bl.Model.IModel;
import swi_bl.Model.TestModel;
import swi_bl.Repository.ITestRepository;
import org.pmw.tinylog.Logger;

public class TestService extends AService<TestModel>{
  private final ITestRepository _testRepository;
  private final RuleSet _ruleSet;

  public TestService(ITestRepository testRepository, RuleSet ruleSet){
    super(ruleSet, "test");

    _testRepository = testRepository;
    _ruleSet = ruleSet;
  }

  @Override
  TestModel GetModel(int id) {
    return _testRepository.Get(id);
  }

  @Override
  List<TestModel> GetModels() {
    return _testRepository.Get();
  }
}
