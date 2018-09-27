package swi_dal.DataSource.Contract;

import org.pmw.tinylog.Logger;

public abstract class ADataSource implements IDataSource {

  //Hybernate init process
  protected ADataSource() {
    Logger.info(this.getClass().toString() + " initialized");
  }

  //Hybernate
  protected abstract String getHibernateConfig();
}
