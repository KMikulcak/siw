package swi_dal.DataSource.Implementation;

import io.ebean.Transaction;
import io.ebean.config.ServerConfig;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.avaje.datasource.DataSourceConfig;
import swi_dal.DataSource.Contract.ADataSource;
import swi_dal.Entity.Implementation.Order;
import swi_dal.Entity.Implementation.State;

public final class MockDataSource extends ADataSource {
  public MockDataSource() {
    super();

    try (Transaction transaction = Server().beginTransaction()) {
      for (Order order:GenerateMockOrders()
      ) {
        order.save();
      }

      for (State state:GenerateMockStates()
      ) {
        state.save();
      }
    }

  }

  @Override
  final protected ServerConfig getServerConfig() {
    DataSourceConfig dtc = new DataSourceConfig();
    dtc.setDriver("org.h2.Driver");
    dtc.setUsername("sa");
    dtc.setPassword("");
    dtc.setUrl("jdbc:h2:tcp://localhost/~/test");

    ServerConfig sC = new ServerConfig();
    sC.setName("monitoring");
    sC.setDefaultServer(false);
    sC.setClasses(new ArrayList<Class<?>>(Arrays.asList(Order.class, State.class)));
    sC.setRegister(true);
    sC.setDdlGenerate(false); // ddlGenerate drops all tables and create new tables
    sC.setDdlRun(false); // ddlRun run migration scripts
    sC.setDataSourceConfig(dtc);

    return sC;
  }

  private List<Order> GenerateMockOrders() {
    return new ArrayList<Order>(Arrays.asList(new Order(1, "100-EE"),
        new Order(2, "101-EE"),
        new Order(3, "102-EE"),
        new Order(4, "103-EE"),
        new Order(5, "104-EE"),
        new Order(6, "105-EE")
    ));
  }

  private List<State> GenerateMockStates() {
    return new ArrayList<State>(
        Arrays.asList(new State(1, 0, "100-EE", new Timestamp(System.currentTimeMillis())),
            new State(2, 1, "100-EE", new Timestamp(System.currentTimeMillis())),
            new State(3, 2, "100-EE", new Timestamp(System.currentTimeMillis())),
            new State(4, 3, "100-EE", new Timestamp(System.currentTimeMillis())),
            new State(5, 0, "101-EE", new Timestamp(System.currentTimeMillis())),
            new State(6, 4, "101-EE", new Timestamp(System.currentTimeMillis())),
            new State(7, 0, "102-EE", new Timestamp(System.currentTimeMillis())),
            new State(8, 1, "102-EE", new Timestamp(System.currentTimeMillis())),
            new State(9, 2, "102-EE", new Timestamp(System.currentTimeMillis())),
            new State(10, 3, "102-EE", new Timestamp(System.currentTimeMillis())),
            new State(11, 0, "103-EE", new Timestamp(System.currentTimeMillis())),
            new State(12, 1, "103-EE", new Timestamp(System.currentTimeMillis())),
            new State(13, 5, "103-EE", new Timestamp(System.currentTimeMillis())),
            new State(14, 0, "104-EE", new Timestamp(System.currentTimeMillis())),
            new State(15, 1, "104-EE", new Timestamp(System.currentTimeMillis())),
            new State(16, 2, "104-EE", new Timestamp(System.currentTimeMillis())),
            new State(17, 6, "104-EE", new Timestamp(System.currentTimeMillis())),
            new State(18, 0, "105-EE", new Timestamp(System.currentTimeMillis())),
            new State(19, 1, "105-EE", new Timestamp(System.currentTimeMillis())),
            new State(20, 2, "105-EE", new Timestamp(System.currentTimeMillis())),
            new State(21, 3, "105-EE", new Timestamp(System.currentTimeMillis())),
            new State(22, 7, "105-EE", new Timestamp(System.currentTimeMillis()))
        ));
  }
}
