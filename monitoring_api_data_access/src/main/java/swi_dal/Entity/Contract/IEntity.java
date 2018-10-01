package swi_dal.Entity.Contract;

import javax.persistence.Entity;

@Entity
public interface IEntity {
  public int getId();

  public void setId(int _id);
}
