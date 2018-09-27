package swi_dal.Dto;

public class Order {

  private final int _id;
  private final String _processingId;

  public Order(int id, String processingId) {
    _id = id;
    _processingId = processingId;
  }

  public int Id() {
    return _id;
  }

  public String ProcessingId() {
    return _processingId;
  }
}
