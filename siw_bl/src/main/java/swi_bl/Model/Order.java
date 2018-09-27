package swi_bl.Model;

public class Order implements IEntity {

  private final int _id;
  private final String _processingId;

  public Order(int id, String processingId) {
    _id = id;
    _processingId = processingId;
  }

  @Override
  public int getId() {
    return _id;
  }

  public String getProcessingId() {
    return _processingId;
  }
}
