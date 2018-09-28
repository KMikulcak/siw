package swi_dal.DataSource.Contract;

import javax.persistence.EntityManager;
import org.hibernate.Session;

public interface IDataSource {
  public EntityManager EM();

  public Session Session();
}
