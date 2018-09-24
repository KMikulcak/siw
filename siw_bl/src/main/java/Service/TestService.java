package Service;

import Model.TestModel;
import Repository.ITestRepository;

public class TestService {
  private final ITestRepository _testRepository;

  public TestService(ITestRepository testRepository){
    _testRepository = testRepository;
  }

  public TestModel Get(int id){
    return _testRepository.Get(id);
  }
}
