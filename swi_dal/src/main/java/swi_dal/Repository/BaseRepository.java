package swi_dal.Repository;

import swi_dal.DataSource.IDataSource;

class BaseRepository {
  final IDataSource _dataSource;

  BaseRepository(IDataSource dataSource){
    _dataSource = dataSource;
  }
}
