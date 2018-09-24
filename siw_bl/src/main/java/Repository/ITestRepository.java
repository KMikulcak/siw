package Repository;

import Model.TestModel;

public interface ITestRepository {
  public TestModel Get(int id);
}
