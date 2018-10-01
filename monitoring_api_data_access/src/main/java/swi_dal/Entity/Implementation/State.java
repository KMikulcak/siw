package swi_dal.Entity.Implementation;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.NaturalId;
import swi_dal.Entity.Contract.IEntity;

@Entity
@Table(name = "monitoring_state")
public class State implements IEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private int id;
  @Column(name = "stateType")
  private int stateType;
  @Column(name = "processingID")
  private String processingId;
  @Column(name = "timeStamp")
  private Timestamp timeStamp;

  public State() {

  }

  public State(int id, int stateType, String processingId, Timestamp timestamp){
    this.id = id;
    this.stateType = stateType;
    this.processingId = processingId;
    this.timeStamp = timestamp;
  }

  public int getId() {
    return id;
  }

  public void setId(int _id) {
    this.id = _id;
  }

  public int getStateType() {
    return stateType;
  }

  public void setStateType(int _stateType) {
    this.stateType = _stateType;
  }

  public String getProcessingId() {
    return processingId;
  }

  public void setProcessingId(String _processingId) {
    this.processingId = _processingId;
  }

  public Timestamp getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Timestamp _timeStamp) {
    this.timeStamp = _timeStamp;
  }
}
