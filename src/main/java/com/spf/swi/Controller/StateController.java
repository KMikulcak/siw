package com.spf.swi.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import monitoring_api_business.Infrastructure.RuleSet.UpdateIntervalUnits;
import monitoring_api_business.Infrastructure.RuleSetBuilder;
import monitoring_api_business.Model.Implementation.State;
import monitoring_api_business.Repository.Contract.IStateRepository;
import monitoring_api_business.Service.Implementation.StateService;

@RestController
public class StateController {

  private final StateService _stateService;

  //DPJ flag for inject
  @Autowired
  public StateController(IStateRepository stateRepository) {
    _stateService = new StateService(stateRepository,
        new RuleSetBuilder("state")
            .IsCaching(true)
            .UpdateInterval(10)
            .UpdateIntervalUnit(UpdateIntervalUnits.Second)
            .BuildRuleSet());
  }

  @RequestMapping("/State")
  public State byProcessingId(
      @RequestParam(value = "Id", defaultValue = "1") int Id) {
    return _stateService.Get(Id);
  }

  @RequestMapping("/State/Filter")
  public List<State> byFilter(@RequestParam(value = "filter", defaultValue = "") String filter) {
    return _stateService.GetByFilter(filter);
  }
}
