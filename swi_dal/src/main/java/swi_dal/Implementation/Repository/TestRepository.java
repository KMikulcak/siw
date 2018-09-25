package swi_dal.Implementation.Repository;

import java.util.ArrayList;
import java.util.List;
import swi_bl.Model.TestModel;
import swi_bl.Repository.ITestRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import swi_dal.Dto.TestDto;

public class TestRepository implements ITestRepository {

  private final DateFormat _dateFormat = new SimpleDateFormat("yyyy-MM-dd");

  private TestDto GetDto(int id){
    return new TestDto(id,
        "Prename" +id,
        "Name" +id,
        new Date());
  }

  @Override
  public TestModel Get(int id) {
    TestDto testDto = GetDto(id);
    return new TestModel(testDto.Id(), testDto.Name() + " " + testDto.Prename() + " " + _dateFormat.format(testDto.Birthday()));
  }

  public List<TestModel> Get() {
    List<TestModel> models = new ArrayList<TestModel>();
    for (int i = 0; i < 10; i++) {
      TestDto testDto = GetDto(i);
      models.add(new TestModel(testDto.Id(),
          testDto.Name() + " " + testDto.Prename() + " " + _dateFormat.format(testDto.Birthday())));
    }
    return models;
  }
}
