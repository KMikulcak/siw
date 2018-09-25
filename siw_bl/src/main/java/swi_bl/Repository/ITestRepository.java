package swi_bl.Repository;

import java.util.List;
import swi_bl.Model.TestModel;

public interface ITestRepository {
  public TestModel Get(int id);
  public List<TestModel> Get();
}
