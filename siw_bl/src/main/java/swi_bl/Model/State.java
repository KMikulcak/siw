package swi_bl.Model;

import java.sql.Timestamp;

public class State implements IEntity {

  private final int _id;
  private final StateType _stateType;
  private final String _processingId;
  private final Timestamp _timeStamp;

  public State(int id, StateType stateType, String processingId, Timestamp timeStamp) {
    _id = id;
    _stateType = stateType;
    _processingId = processingId;
    _timeStamp = timeStamp;
  }

  @Override
  public int getId() {
    return _id;
  }

  public StateType getType() {
    return _stateType;
  }

  public String getProcessingId() {
    return _processingId;
  }

  public Timestamp getTime() {
    return _timeStamp;
  }

  public enum StateType {
    Ordered(0),
    Enriched(1),
    Generated(2),
    Injected(3),
    OrderedError(4),
    EnrichedError(5),
    GeneratedError(6),
    InjectedError(7);

    private int numVal;

    StateType(int numVal) {
      this.numVal = numVal;
    }

    public static StateType fromVal(int id) {
      for (StateType type : values()) {
        if (type.getNumVal() == id) {
          return type;
        }
      }
      return null;
    }

    public int getNumVal() {
      return numVal;
    }
  }
}
