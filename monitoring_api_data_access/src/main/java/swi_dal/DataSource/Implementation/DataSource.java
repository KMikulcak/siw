package swi_dal.DataSource.Implementation;

import io.ebean.config.ServerConfig;
import org.avaje.datasource.DataSourceConfig;
import swi_dal.DataSource.Contract.ADataSource;

public final class DataSource extends ADataSource {

  @Override
  protected ServerConfig getServerConfig() {
    return null;
  }
}
