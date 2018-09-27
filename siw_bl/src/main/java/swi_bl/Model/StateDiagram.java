package swi_bl.Model;

import java.util.ArrayList;
import java.util.List;

public class StateDiagram implements IEntity {

  private List<StateDiagramPoint> _injected;
  private List<StateDiagramPoint> _ordered;
  private List<StateDiagramPoint> _generated;
  private List<StateDiagramPoint> _enriched;
  private int _id;

  public StateDiagram(int id) {
    _id = id;
    _ordered = new ArrayList<StateDiagramPoint>();
    _injected = new ArrayList<StateDiagramPoint>();
    _generated = new ArrayList<StateDiagramPoint>();
    _enriched = new ArrayList<StateDiagramPoint>();
  }

  @Override
  public int getId() {
    return _id;
  }

  public List<StateDiagramPoint> getInjected() {
    return _injected;
  }

  public List<StateDiagramPoint> getOrdered() {
    return _ordered;
  }

  public List<StateDiagramPoint> getGenerated() {
    return _generated;
  }

  public List<StateDiagramPoint> getEnriched() {
    return _enriched;
  }

  public void addInjected(State state, int orders, int errors) {
    _injected.add(new StateDiagramPoint(state, orders, errors));
  }

  public void addOrdered(State state, int orders, int errors) {
    _ordered.add(new StateDiagramPoint(state, orders, errors));
  }

  public void addGenerated(State state, int orders, int errors) {
    _generated.add(new StateDiagramPoint(state, orders, errors));
  }

  public void addEnriched(State state, int orders, int errors) {
    _enriched.add(new StateDiagramPoint(state, orders, errors));
  }

  public class StateDiagramPoint {

    private int _orders;
    private int _errors;
    private State _state;

    StateDiagramPoint(State state, int orders, int errors) {
      _state = state;
      _orders = orders;
      _errors = errors;
    }

    public State getState() {
      return _state;
    }

    public int getOrders() {
      return _orders;
    }

    public int getErrors() {
      return _errors;
    }
  }
}
