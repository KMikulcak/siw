package monitoring_api_business.Infrastructure;

import monitoring_api_business.Infrastructure.RuleSet.UpdateIntervalUnits;

public class RuleSetBuilder {

  private final String _cacheKeyPrefix;
  private boolean _isCaching = false;
  private UpdateIntervalUnits _updateIntervalUnit = UpdateIntervalUnits.Minute;
  private int _updateInterval = 1;

  public RuleSetBuilder(String cacheKeyPrefix) {
    _cacheKeyPrefix = cacheKeyPrefix;
  }

  public RuleSet BuildRuleSet() {
    return new RuleSet(_isCaching, _updateIntervalUnit, _updateInterval, _cacheKeyPrefix);
  }

  public RuleSetBuilder IsCaching(boolean isCaching) {
    _isCaching = isCaching;
    return this;
  }

  public RuleSetBuilder UpdateIntervalUnit(UpdateIntervalUnits updateIntervalUnit) {
    _updateIntervalUnit = updateIntervalUnit;
    return this;
  }

  public RuleSetBuilder UpdateInterval(int updateInterval) {
    this._updateInterval = updateInterval;
    return this;
  }
}
