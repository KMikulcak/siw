package swi_dal.Entity.Implementation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.NaturalId;
import swi_dal.Entity.Contract.IEntity;

@Entity
@Table(name = "monitoring_order")
public class Order implements IEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private int id;

  @Column(name = "processingID")
  private String processingId;

  public Order() {

  }

  public Order(int id, String processingId){
    this.id = id;
    this.processingId = processingId;
  }

  public int getId() {
    return id;
  }

  public void setId(int _id) {
    this.id = _id;
  }

  public String getProcessingId() {
    return processingId;
  }

  public void setProcessingId(String _processingId) {
    this.processingId = _processingId;
  }
}
