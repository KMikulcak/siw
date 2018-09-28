package swi_dal.Repository;

import java.util.List;
import javax.persistence.NoResultException;
import monitoring_api_business.Model.Implementation.Order;
import monitoring_api_business.Repository.Contract.IOrderRepository;
import swi_dal.DataSource.Contract.IDataSource;
import swi_dal.Mapping.Implementation.OrderMapper;

public class OrderRepositoryA extends ABaseRepository<Integer, swi_dal.Entity.Implementation.Order>
    implements IOrderRepository {

  private final OrderMapper _mapper;

  public OrderRepositoryA(IDataSource dataSource) {
    super(swi_dal.Entity.Implementation.Order.class, dataSource);
    _mapper = new OrderMapper();
  }

  @Override
  public Order GetOrderByProcessingId(String processingId) {

    swi_dal.Entity.Implementation.Order order = query().where().icontains("processingId", processingId).findOne();

    try {
      return _mapper.MapEntity(order);
    } catch (final NoResultException nre) {
      return null;
    }
  }

  @Override
  public Order Get(int id) {
    /*swi_dal.Entity.Implementation.Order result = _dataSource.GetOrders("").stream().filter(order -> id == order.getId())
        .findFirst()
        .orElse(null);

    if (result != null) {
      return _mapper.MapEntity(result);
    } else {
      return null;
    }*/
    return null;
  }

  @Override
  public List<Order> GetAll() {
    /*List<swi_dal.Entity.Implementation.Order> orders = _dataSource.GetOrders("");
    return _mapper.MapEntity(orders);*/
    return null;
  }

  @Override
  public List<Order> GetByFilter(String filter) {
    /*
    List<swi_dal.Entity.Implementation.Order> orders = _dataSource.GetOrders(filter);
    return _mapper.MapEntity(orders);*/
    return null;
  }
}
