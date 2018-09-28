package swi_dal.Entity.Contract;

import io.ebean.Model;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity extends Model {
  @Id
  protected int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
