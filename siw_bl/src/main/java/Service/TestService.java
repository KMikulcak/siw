package Service;

import Infrastructure.Cache;
import Infrastructure.RuleSet;
import Model.TestModel;
import Repository.ITestRepository;
import java.util.Date;

public class TestService {
  private final ITestRepository _testRepository;
  private final RuleSet _ruleSet;

  //singel pull
  private String _key = "test ";

  //list pull

  public TestService(ITestRepository testRepository, RuleSet ruleSet){
    _testRepository = testRepository;
    _ruleSet = ruleSet;
  }

  private void Pull(){
    //if()
  }

  public TestModel Get(int id){
    TestModel testModel = null;
    if(_ruleSet.IsCaching()) {
      testModel = (TestModel) Cache.Current()
          .get(Cache.KeyBuilder("test", Integer.toString(id)));
      if (testModel == null) {
        testModel = _testRepository.Get(id);
        Cache.Current().add(Cache.KeyBuilder("test", Integer.toString(id)), testModel,
            _ruleSet.UpdateDuration());
      }
    }else testModel = _testRepository.Get(id);
    return testModel;
  }
}
