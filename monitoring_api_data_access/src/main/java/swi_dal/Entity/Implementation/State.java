package swi_dal.Entity.Implementation;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import swi_dal.Entity.Contract.IEntity;

@Entity
@Table(name = "monitoring_state")
public class State implements IEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private int _id;
  @Column(name = "stateType")
  private int _stateType;
  @Column(name = "processingID")
  private String _processingId;
  @Column(name = "timeStamp")
  private Timestamp _timeStamp;

  public State() {

  }

  public State(int id, int stateType, String processingId, Timestamp timestamp){
    _id = id;
    _stateType = stateType;
    _processingId = processingId;
    _timeStamp = timestamp;
  }

  public int getId() {
    return _id;
  }

  public void setId(int _id) {
    this._id = _id;
  }

  public int getStateType() {
    return _stateType;
  }

  public void setStateType(int _stateType) {
    this._stateType = _stateType;
  }

  public String getProcessingId() {
    return _processingId;
  }

  public void setProcessingId(String _processingId) {
    this._processingId = _processingId;
  }

  public Timestamp getTimeStamp() {
    return _timeStamp;
  }

  public void setTimeStamp(Timestamp _timeStamp) {
    this._timeStamp = _timeStamp;
  }
}
