package monitoring_api_business.Repository.Contract;

import java.util.List;
import monitoring_api_business.Model.Implementation.State;

public interface IStateRepository extends IRepository<State> {

  public List<State> GetAllByOrderProcessingId(String processingId);
}
