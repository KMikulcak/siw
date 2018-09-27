package swi_dal.Repository;

import org.pmw.tinylog.Logger;
import swi_dal.DataSource.IDataSource;

class BaseRepository {

  final IDataSource _dataSource;

  BaseRepository(IDataSource dataSource) {
    _dataSource = dataSource;

    Logger.info(this.getClass().toString() + " initialized");
  }
}
