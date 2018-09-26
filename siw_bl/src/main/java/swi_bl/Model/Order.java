package swi_bl.Model;

public class Order implements IEntity {
  private final int _id;
  private final String _processingId;

  public Order(int id, String processingId){
    _id = id;
    _processingId = processingId;
  }

  @Override
  public int Id() {
    return _id;
  }

  public String ProcessingId() {
    return _processingId;
  }
}
