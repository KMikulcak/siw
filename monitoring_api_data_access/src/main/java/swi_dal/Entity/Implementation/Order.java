package swi_dal.Entity.Implementation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import swi_dal.Entity.Contract.BaseEntity;

@Entity
public class Order extends BaseEntity {

  String processingId;

  public String getProcessingId() {
    return processingId;
  }

  public Order(int id, String processingId){
    this.id = id;
    this.processingId = processingId;
  }

  public void setProcessingId(String processingId) {
    this.processingId = processingId;
  }
}
