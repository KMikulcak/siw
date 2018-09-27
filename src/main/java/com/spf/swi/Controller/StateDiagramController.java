package com.spf.swi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import swi_bl.Infrastructure.RuleSet.UpdateIntervalUnits;
import swi_bl.Infrastructure.RuleSetBuilder;
import swi_bl.Model.StateDiagram;
import swi_bl.Repository.IOrderRepository;
import swi_bl.Repository.IStateRepository;
import swi_bl.Service.StateDiagramService;

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
    return _stateDiagramService.Get(processingId);
  }

  @RequestMapping("/StateDiagram/Filter")
  public StateDiagram byFilter(@RequestParam(value = "filter", defaultValue = "") String filter) {
    return _stateDiagramService.GetByFilter(filter);
  }
}


