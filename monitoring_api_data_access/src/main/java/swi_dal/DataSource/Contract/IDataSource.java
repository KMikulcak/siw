package swi_dal.DataSource.Contract;

import io.ebean.EbeanServer;

public interface IDataSource {
  public EbeanServer Server();
}
