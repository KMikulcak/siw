package Dto;

import java.util.Date;

public class TestDto {
  private final long _id;
  private final String _prename;
  private final String _name;
  private final Date _birthday;

  public TestDto(int id, String prename, String name, Date birthday) {
    _id = id;
    _prename = prename;
    _name = name;
    _birthday = birthday;
  }

  public long Id() {
    return _id;
  }
  public String Prename() {
    return _prename;
  }
  public String Name() {
    return _name;
  }
  public Date Birthday() {
    return _birthday;
  }
}
