package com.spf.swi.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import swi_bl.Infrastructure.RuleSet.UpdateIntervalUnits;
import swi_bl.Infrastructure.RuleSetBuilder;
import swi_bl.Model.Order;
import swi_bl.Model.StateDiagram;
import swi_bl.Repository.IOrderRepository;
import swi_bl.Repository.IStateRepository;
import swi_bl.Service.StateDiagramService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  private final StateDiagramService _stateDiagramService;

  //DPJ flag for inject
  @Autowired
  public TestController(IOrderRepository orderRepository, IStateRepository stateRepository){
    _stateDiagramService = new StateDiagramService(orderRepository, stateRepository,
        new RuleSetBuilder("stateDiagram")
            .IsCaching(true)
            .UpdateInterval(10)
            .UpdateIntervalUnit(UpdateIntervalUnits.Second)
            .BuildRuleSet());
  }

  @RequestMapping("/test")
  public StateDiagram test (@RequestParam(value="processingId", defaultValue="100-EE") String processingId) {
    return _stateDiagramService.Get(processingId);
  }

  //@RequestMapping("/test/all")
  //public List<TestModel> testAll () {
    //return _testService.Get();
  //}
}


