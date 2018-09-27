package com.spf.swi.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import monitoring_api_business.Infrastructure.RuleSet.UpdateIntervalUnits;
import monitoring_api_business.Infrastructure.RuleSetBuilder;
import monitoring_api_business.Model.Implementation.Order;
import monitoring_api_business.Repository.Contract.IOrderRepository;
import monitoring_api_business.Service.Implementation.OrderService;

@RestController
public class OrderController {

  private final OrderService _orderService;

  //DPJ flag for inject
  @Autowired
  public OrderController(IOrderRepository orderRepository) {
    _orderService = new OrderService(orderRepository,
        new RuleSetBuilder("order")
            .IsCaching(true)
            .UpdateInterval(10)
            .UpdateIntervalUnit(UpdateIntervalUnits.Second)
            .BuildRuleSet());
  }

  @RequestMapping("/Order")
  public Order byProcessingId(
      @RequestParam(value = "Id", defaultValue = "1") int Id) {
    return _orderService.Get(Id);
  }

  @RequestMapping("/Order/Filter")
  public List<Order> byFilter(@RequestParam(value = "filter", defaultValue = "") String filter) {
    return _orderService.GetByFilter(filter);
  }
}
