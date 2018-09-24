package com.spf.swi.Controller;

import Implementation.TestRepository;
import Model.TestModel;
import Service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  private final TestService _testService;

  public TestController(){
    _testService = new TestService(new TestRepository());
  }

  @RequestMapping("/test")
  public TestModel test (@RequestParam(value="id", defaultValue="1") int id) {
    return _testService.Get(id);
  }
}
