package swi_dal.Repository;

import java.util.List;
import swi_bl.Model.Order;
import swi_bl.Repository.IOrderRepository;
import swi_dal.DataSource.IDataSource;
import swi_dal.Mapping.OrderMapper;

public class OrderRepository extends BaseRepository
    implements IOrderRepository {

  private final OrderMapper _mapper;

  public OrderRepository(IDataSource dataSource) {
    super(dataSource);
    _mapper = new OrderMapper();
  }

  @Override
  public Order GetOrderByProcessingId(String processingId) {
    List<swi_dal.Dto.Order> orders = _dataSource.GetOrders("where processingId=" + processingId);
    return _mapper.MapDto(orders.get(0));
  }

  @Override
  public Order Get(int id) {
    swi_dal.Dto.Order result = _dataSource.GetOrders("").stream().filter(order -> id == order.Id())
        .findFirst()
        .orElse(null);

    if (result != null) {
      return _mapper.MapDto(result);
    } else {
      return null;
    }
  }

  @Override
  public List<Order> GetAll() {
    List<swi_dal.Dto.Order> orders = _dataSource.GetOrders("");
    return _mapper.MapDto(orders);
  }

  @Override
  public List<Order> GetByFilter(String filter) {
    List<swi_dal.Dto.Order> orders = _dataSource.GetOrders(filter);
    return _mapper.MapDto(orders);
  }
}
