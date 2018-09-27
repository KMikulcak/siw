package monitoring_api_business.Repository.Contract;

import monitoring_api_business.Model.Implementation.Order;

public interface IOrderRepository extends IRepository<Order> {

  public Order GetOrderByProcessingId(String processingId);
}
