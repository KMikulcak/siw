package Infrastructure;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class RuleSet {
  private final boolean _isCaching;
  private final UpdateIntervalUnits _updateIntervalUnit;
  private final int _updateInterval;
  private final Date _createdAt;
  private final long _updateDuration;

  RuleSet(boolean isCaching, UpdateIntervalUnits updateIntervalUnit, int updateInterval){
    _isCaching = isCaching;
    _updateIntervalUnit = updateIntervalUnit;
    _updateInterval = updateInterval;
    _createdAt = new Date();

    Calendar calendar = Calendar.getInstance();

    switch (_updateIntervalUnit){
      case Second:
        calendar.add(Calendar.SECOND, _updateInterval);
        break;
      case Minute:
        calendar.add(Calendar.MINUTE, _updateInterval);
        break;
      case Hour:
        calendar.add(Calendar.HOUR, _updateInterval);
        break;
      case Day:
        calendar.add(Calendar.HOUR, _updateInterval * 24);
        break;
    }

    _updateDuration = Duration.between(_createdAt.toInstant(), calendar.toInstant()).toNanos();
  }

  public boolean IsCaching(){
    return _isCaching;
  }

  public UpdateIntervalUnits UpdateIntervalUnit(){
    return _updateIntervalUnit;
  }

  public int UpdateInterval(){
    return _updateInterval;
  }

  public Date CreatedAt(){
    return _createdAt;
  }

  public long UpdateDuration(){
    return _updateDuration;
  }

  public enum UpdateIntervalUnits{
    Second, Minute, Hour, Day
  }
}
