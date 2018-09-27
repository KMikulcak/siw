package swi_dal.Dto;

import java.sql.Timestamp;

public class State {

  private final int _id;
  private final int _stateType;
  private final String _processingId;
  private final Timestamp _timeStamp;

  public State(int id, int stateType, String processingId, Timestamp timeStamp) {
    _id = id;
    _stateType = stateType;
    _processingId = processingId;
    _timeStamp = timeStamp;
  }

  public int Id() {
    return _id;
  }

  public int Type() {
    return _stateType;
  }

  public String ProcessingId() {
    return _processingId;
  }

  public Timestamp Time() {
    return _timeStamp;
  }
}
