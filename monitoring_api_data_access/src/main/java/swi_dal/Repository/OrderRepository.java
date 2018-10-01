package swi_dal.Repository;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import monitoring_api_business.Model.Implementation.Order;
import monitoring_api_business.Repository.Contract.IOrderRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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
    Criteria criteria = _dataSource.Session().createCriteria(swi_dal.Entity.Implementation.Order.class);
    criteria.add(Restrictions.eq("processingId",processingId));

    try {
      return _mapper.MapEntity( (swi_dal.Entity.Implementation.Order) criteria.uniqueResult());
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
    return _mapper.MapEntity(orders);
    */
    return null;
  }
}
