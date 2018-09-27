package swi_bl.Infrastructure;

import java.time.Duration;
import java.time.LocalDateTime;

public class RuleSet {

  private final boolean _isCaching;
  private final UpdateIntervalUnits _updateIntervalUnit;
  private final int _updateInterval;
  private final LocalDateTime _createdAt;
  private final long _updateDuration;
  private final String _cacheKeyPrefix;

  RuleSet(boolean isCaching, UpdateIntervalUnits updateIntervalUnit, int updateInterval,
      String cacheKeyPrefix) {
    _isCaching = isCaching;
    _updateIntervalUnit = updateIntervalUnit;
    _updateInterval = updateInterval;
    _cacheKeyPrefix = cacheKeyPrefix;
    _createdAt = LocalDateTime.now();
    LocalDateTime _nextTime = LocalDateTime.now();

    switch (_updateIntervalUnit) {
      case Second:
        _nextTime = _createdAt.plusSeconds(_updateInterval);
        break;
      case Minute:
        _nextTime = _createdAt.plusMinutes(_updateInterval);
        break;
      case Hour:
        _nextTime = _createdAt.plusHours(_updateInterval);
        break;
      case Day:
        _nextTime = _createdAt.plusDays(_updateInterval);
        break;
    }

    _updateDuration = Duration.between(_createdAt, _nextTime).toMillis();
  }

  public boolean IsCaching() {
    return _isCaching;
  }

  public UpdateIntervalUnits UpdateIntervalUnit() {
    return _updateIntervalUnit;
  }

  public int UpdateInterval() {
    return _updateInterval;
  }

  public LocalDateTime CreatedAt() {
    return _createdAt;
  }

  public long UpdateDuration() {
    return _updateDuration;
  }

  public String CacheKeyPrefix() {
    return _cacheKeyPrefix;
  }

  public enum UpdateIntervalUnits {
    Second, Minute, Hour, Day
  }
}
