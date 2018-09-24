package Infrastructure;

import Infrastructure.RuleSet.UpdateIntervalUnits;

public class RuleSetBuilder {
  private boolean _isCaching = false;
  private UpdateIntervalUnits _updateIntervalUnit = UpdateIntervalUnits.Minute;
  private int _updateInterval = 1;

  public RuleSetBuilder() { }

  public RuleSet BuildRuleSet()
  {
    return new RuleSet(_isCaching, _updateIntervalUnit, _updateInterval);
  }

  public RuleSetBuilder IsCaching(boolean isCaching)
  {
    _isCaching = isCaching;
    return this;
  }

  public RuleSetBuilder UpdateIntervalUnit(UpdateIntervalUnits updateIntervalUnit)
  {
    _updateIntervalUnit = updateIntervalUnit;
    return this;
  }

  public RuleSetBuilder UpdateInterval(int updateInterval)
  {
    this._updateInterval = updateInterval;
    return this;
  }
}