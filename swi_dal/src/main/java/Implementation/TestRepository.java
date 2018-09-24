package Implementation;

import Dto.TestDto;
import Model.TestModel;
import Repository.ITestRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
