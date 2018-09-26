package swi_dal.DataSource;

import java.util.List;
import swi_dal.Dto.Order;
import swi_dal.Dto.State;

public interface IDataSource {
  List<State> GetStates(String filter);

  List<Order> GetOrders(String filter);
}
