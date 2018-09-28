package monitoring_api_business.Repository.Contract;

import java.util.List;
import monitoring_api_business.Model.Contract.IModel;

interface IRepository<Model extends IModel> {

  public Model Get(int id);

  public List<Model> GetAll();

  public List<Model> GetByFilter(String filter);
}
