package com.spf.swi.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import swi_bl.Infrastructure.RuleSet.UpdateIntervalUnits;
import swi_bl.Infrastructure.RuleSetBuilder;
import swi_bl.Model.Order;
import swi_bl.Model.State;
import swi_bl.Repository.IOrderRepository;
import swi_bl.Repository.IStateRepository;
import swi_bl.Service.OrderService;
import swi_bl.Service.StateService;

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
