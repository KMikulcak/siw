package swi_bl.Repository;

import swi_bl.Model.Order;

public interface IOrderRepository extends IRepository<Order> {

  public Order GetOrderByProcessingId(String processingId);
}
