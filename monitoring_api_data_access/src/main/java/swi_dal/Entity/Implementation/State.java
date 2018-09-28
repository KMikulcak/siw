package swi_dal.Entity.Implementation;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import swi_dal.Entity.Contract.BaseEntity;

@Entity
public class State extends BaseEntity {

  int stateType;
  String processingId;
  Timestamp timeStamp;

  public State(int id, int stateType, String processingId, Timestamp timestamp){
    this.id = id;
    this.stateType = stateType;
    this.processingId = processingId;
    this.timeStamp = timestamp;
  }

  public int getStateType() {
    return stateType;
  }

  public void setStateType(int stateType) {
    this.stateType = stateType;
  }

  public String getProcessingId() {
    return processingId;
  }

  public void setProcessingId(String processingId) {
    this.processingId = processingId;
  }

  public Timestamp getTimeStampe() {
    return timeStamp;
  }

  public void setTimeStampe(Timestamp timeStampe) {
    this.timeStamp = timeStampe;
  }
}
