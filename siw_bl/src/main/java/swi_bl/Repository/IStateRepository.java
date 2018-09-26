package swi_bl.Repository;

import java.util.List;
import swi_bl.Model.State;

public interface IStateRepository extends IRepository<State> {
  public List<State> GetAllByOrderProcessingId(String processingId);
}
