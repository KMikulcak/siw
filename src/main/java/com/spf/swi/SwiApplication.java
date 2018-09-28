package com.spf.swi;

import com.spf.swi.Bootstrapper.BootMode;
import org.avaje.agentloader.AgentLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwiApplication {

  public static void main(String[] args) {

    //default Mock
    Bootstrapper.Current().Build(BootMode.Mock);

    SpringApplication.run(SwiApplication.class, args);
  }

}
