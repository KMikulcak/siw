package monitoring_api_business.Service.Contract;

import org.pmw.tinylog.Logger;
import monitoring_api_business.Infrastructure.Cache;
import monitoring_api_business.Infrastructure.RuleSet;
import monitoring_api_business.Model.Contract.IModel;

public abstract class AService<Model extends IModel, Identifier, Result> {

  private final RuleSet _ruleSet;
  private String _keyPrefix;

  public AService(RuleSet ruleSet, String keyPrefix) {
    _ruleSet = ruleSet;
    _keyPrefix = keyPrefix;

    Logger.info(this.getClass().toString() + " initialized"
        + ", with KeyPrefix:'" + keyPrefix + "'"
        + ", and caching " + _ruleSet.IsCaching());
  }

  String KeyPrefix() {
    return _keyPrefix;
  }

  protected abstract Model GetEntityById(Identifier id) throws Exception;

  protected abstract Result GetResultByFilter(String filter) throws Exception;

  protected abstract Result GetAll() throws Exception;

  public Model Get(Identifier id) {
    Model entity = null;

    try {
      if (_ruleSet.IsCaching()) {
        entity = (Model) Cache.Current()
            .get(Cache.KeyBuilder(_keyPrefix, String.valueOf(id)));
        if (entity == null) {
          entity = GetEntityById(id);
          Cache.Current().add(Cache.KeyBuilder(_keyPrefix, String.valueOf(id)), entity,
              _ruleSet.UpdateDuration());
        }
      } else {
        entity = GetEntityById(id);
      }
    } catch (Exception ex) {
      Logger.error(ex);
    }
    return entity;
  }

  public Result GetByFilter(String filter){
    Result result = null;

    try{
    if (_ruleSet.IsCaching()) {

      result = (Result) Cache.Current()
          .get(Cache.KeyBuilder(_keyPrefix, filter));
      if (result == null) {
        result = GetResult(filter);
        Cache.Current().add(Cache.KeyBuilder(_keyPrefix, filter), result,
            _ruleSet.UpdateDuration());
      }
    } else {
      result = GetResult(filter);
    }
    } catch (Exception ex) {
      Logger.error(ex);
    }
    return result;
  }

  private Result GetResult(String filter) throws Exception {
    if (filter.isEmpty()) {
      return GetAll();
    } else {
      return GetResultByFilter(filter);
    }
  }
}
