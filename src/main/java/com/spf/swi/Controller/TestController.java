package com.spf.swi.Controller;

import Implementation.Repository.TestRepository;
import Infrastructure.RuleSet.UpdateIntervalUnits;
import Model.TestModel;
import Infrastructure.RuleSetBuilder;
import Service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  private final TestService _testService;

  public TestController(){
    _testService = new TestService(new TestRepository(),
        new RuleSetBuilder()
            .IsCaching(true)
            .UpdateInterval(1)
            .UpdateIntervalUnit(UpdateIntervalUnits.Second)
            .BuildRuleSet());
  }

  @RequestMapping("/test")
  public TestModel test (@RequestParam(value="id", defaultValue="1") int id) {
    return _testService.Get(id);
  }
}
