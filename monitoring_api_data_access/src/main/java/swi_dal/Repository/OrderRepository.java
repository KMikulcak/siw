package swi_dal.Repository;

import java.util.List;
import monitoring_api_business.Model.Implementation.Order;
import monitoring_api_business.Repository.Contract.IOrderRepository;
import swi_dal.DataSource.Contract.IDataSource;
import swi_dal.Mapping.Implementation.OrderMapper;

public class OrderRepository extends BaseRepository
    implements IOrderRepository {

  private final OrderMapper _mapper;

  public OrderRepository(IDataSource dataSource) {
    super(dataSource);
    _mapper = new OrderMapper();
  }

  @Override
  public Order GetOrderByProcessingId(String processingId) {
    swi_dal.Dto.Order result = _dataSource.GetOrders("").stream().filter(order -> processingId.equals(order.ProcessingId()))
        .findFirst()
        .orElse(null);

    if (result != null) {
      return _mapper.MapDto(result);
    } else {
      return null;
    }
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
