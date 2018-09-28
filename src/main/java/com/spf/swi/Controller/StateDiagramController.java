package com.spf.swi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import monitoring_api_business.Infrastructure.RuleSet.UpdateIntervalUnits;
import monitoring_api_business.Infrastructure.RuleSetBuilder;
import monitoring_api_business.Model.Implementation.StateDiagram;
import monitoring_api_business.Repository.Contract.IOrderRepository;
import monitoring_api_business.Repository.Contract.IStateRepository;
import monitoring_api_business.Service.Implementation.StateDiagramService;

@RestController
public class StateDiagramController {

  private final StateDiagramService _stateDiagramService;

  //DPJ flag for inject
  @Autowired
  public StateDiagramController(IOrderRepository orderRepository,
      IStateRepository stateRepository) {
    _stateDiagramService = new StateDiagramService(orderRepository, stateRepository,
        new RuleSetBuilder("stateDiagram")
            .IsCaching(true)
            .UpdateInterval(10)
            .UpdateIntervalUnit(UpdateIntervalUnits.Second)
            .BuildRuleSet());
  }

  @RequestMapping("/StateDiagram")
  public StateDiagram byProcessingId(
      @RequestParam(value = "processingId", defaultValue = "100-EE") String processingId) {
    try {
      return _stateDiagramService.Get(processingId);
    }catch(Exception ex){
     return null;
    }
  }

  @RequestMapping("/StateDiagram/Filter")
  public StateDiagram byFilter(@RequestParam(value = "filter", defaultValue = "") String filter) {
    return _stateDiagramService.GetByFilter(filter);
  }
}


