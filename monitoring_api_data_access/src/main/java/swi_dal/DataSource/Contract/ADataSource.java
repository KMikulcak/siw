package swi_dal.DataSource.Contract;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import org.avaje.agentloader.AgentLoader;
import org.pmw.tinylog.Logger;

public abstract class ADataSource implements IDataSource {

  private final EbeanServer _server;

  protected ADataSource() {
    if (!AgentLoader.loadAgentFromClasspath("ebean-agent","debug=1;packages=org.example.model")) {

    }

// create the EbeanServer instance
    _server = EbeanServerFactory.create(getServerConfig());

    Logger.info(this.getClass().getSimpleName() + " initialized");
  }

  protected abstract ServerConfig getServerConfig();

  @Override
  public EbeanServer Server(){
    return _server;
  }

}
