package com.spf.swi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import monitoring_api_business.Repository.Contract.IOrderRepository;
import monitoring_api_business.Repository.Contract.IStateRepository;
import swi_dal.DataSource.Implementation.DataSource;
import swi_dal.DataSource.Contract.IDataSource;
import swi_dal.DataSource.Implementation.MockDataSource;
import swi_dal.DataSource.Implementation.SimulatorDataSource;
import swi_dal.Repository.OrderRepository;
import swi_dal.Repository.StateRepository;

//flag DPJ Config
@Configuration
public class Bootstrapper {

  private static Bootstrapper _current;

  public Bootstrapper() {
  }

  static Bootstrapper Current() {
    if (_current == null) {
      _current = new Bootstrapper();
    }
    return _current;
  }

  void Build(BootMode mode) {
    DataSourceFactory.SetMode(mode);
  }

  //flag DPJ
  @Bean
  public IOrderRepository OrderRepository() {
    return new OrderRepository(DataSourceFactory.GetDataSource());
  }

  @Bean
  public IStateRepository StateRepository() {
    return new StateRepository(DataSourceFactory.GetDataSource());
  }

  public enum BootMode {
    Mock, Sim, Live
  }

  public static class DataSourceFactory {

    private static IDataSource _dataSource;

    static void SetMode(BootMode mode) {
      if (_dataSource == null) {
        switch (mode) {
          case Mock:
            _dataSource = new MockDataSource();
            break;
          case Sim:
            _dataSource = new SimulatorDataSource();
            break;
          case Live:
            _dataSource = new DataSource();
            break;
        }
      }
    }

    static IDataSource GetDataSource() {
      return _dataSource;
    }
  }
}
