package swi_dal.DataSource.Implementation;

import java.util.List;
import java.util.Properties;
import swi_dal.DataSource.Contract.ADataSource;
import swi_dal.Entity.Implementation.Order;
import swi_dal.Entity.Implementation.State;

public final class DataSource extends ADataSource {

  @Override
  protected final Properties getHibernateConfig() {
    return null;
  }
}
