package swi_dal.Entity.Implementation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import swi_dal.Entity.Contract.IEntity;

@Entity
@Table(name = "monitoring_order")
public class Order implements IEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private int _id;

  @Column(name = "processingID")
  private String _processingId;

  public Order() {

  }

  public Order(int id, String processingId){
    _id = id;
    _processingId = processingId;
  }

  public int getId() {
    return _id;
  }

  public void setId(int _id) {
    this._id = _id;
  }

  public String getProcessingId() {
    return _processingId;
  }

  public void setProcessingId(String _processingId) {
    this._processingId = _processingId;
  }
}
