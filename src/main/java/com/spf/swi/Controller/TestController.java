package com.spf.swi.Controller;

import java.util.List;
import swi_dal.Implementation.Repository.TestRepository;
import swi_bl.Infrastructure.RuleSet.UpdateIntervalUnits;
import swi_bl.Model.TestModel;
import swi_bl.Infrastructure.RuleSetBuilder;
import swi_bl.Service.TestService;
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
            .UpdateInterval(10)
            .UpdateIntervalUnit(UpdateIntervalUnits.Second)
            .BuildRuleSet());
  }

  @RequestMapping("/test")
  public TestModel test (@RequestParam(value="id", defaultValue="1") int id) {
    return _testService.Get(id);
  }

  @RequestMapping("/test/all")
  public List<TestModel> testAll () {
    return _testService.Get();
  }
}
