package swi_dal.Repository;

import io.ebean.BeanRepository;
import org.pmw.tinylog.Logger;
import swi_dal.DataSource.Contract.IDataSource;
import swi_dal.DataSource.Implementation.DataSource;
import swi_dal.Entity.Contract.BaseEntity;

 abstract class ABaseRepository<Indentifier, Entity extends BaseEntity> extends
    BeanRepository<Indentifier,Entity> {

  final IDataSource _dataSource;

  ABaseRepository(Class<Entity> entityClass, IDataSource dataSource) {
    super(entityClass, dataSource.Server());
    _dataSource = dataSource;

    Logger.info(this.getClass().toString() + " initialized");
  }
}
