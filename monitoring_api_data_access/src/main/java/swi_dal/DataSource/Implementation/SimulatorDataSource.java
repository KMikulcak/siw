package swi_dal.DataSource.Implementation;

import java.util.List;
import swi_dal.DataSource.Contract.ADataSource;
import swi_dal.Dto.Order;
import swi_dal.Dto.State;

public final class SimulatorDataSource extends ADataSource {

  @Override
  protected final String getHibernateConfig() {
    return null;
  }

  @Override
  public List<State> GetStates(String filter) {
    return null;
  }

  @Override
  public List<Order> GetOrders(String filter) {
    return null;
  }
}
