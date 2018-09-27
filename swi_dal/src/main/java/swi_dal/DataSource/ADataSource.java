package swi_dal.DataSource;

import org.pmw.tinylog.Logger;

public abstract class ADataSource implements IDataSource {

  //Hybernate init process
  ADataSource() {
    Logger.info(this.getClass().toString() + " initialized");
  }

  //Hybernate
  abstract String getHibernateConfig();
}
