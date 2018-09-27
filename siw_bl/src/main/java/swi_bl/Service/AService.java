package swi_bl.Service;

import org.pmw.tinylog.Logger;
import swi_bl.Infrastructure.Cache;
import swi_bl.Infrastructure.RuleSet;
import swi_bl.Model.IEntity;

abstract class AService<Entity extends IEntity, Identifier, Result> {

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

  public Entity Get(Identifier id) {
    Entity entity = null;
    //Logger.info(this.getClass().toString() + " Get() " +  + " by Id " + id.getClass().toString() + ": " + String.valueOf(id));


    if (_ruleSet.IsCaching()) {
      entity = (Entity) Cache.Current()
          .get(Cache.KeyBuilder(_keyPrefix, String.valueOf(id)));
      if (entity == null) {
        entity = GetEntityById(id);
        Cache.Current().add(Cache.KeyBuilder(_keyPrefix, String.valueOf(id)), entity,
            _ruleSet.UpdateDuration());
      }
    } else {
      entity = GetEntityById(id);
    }

    return entity;
  }

  abstract Entity GetEntityById(Identifier id);

  public Result GetByFilter(String filter) {
    Result result = null;
    //Logger.info(this.getClass().toString() + " Get() " + result.getClass().toString() + " by filter: " + filter);

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

    return result;
  }

  abstract Result GetResultByFilter(String filter);

  abstract Result GetAll();

  private Result GetResult(String filter){
    if(filter.isEmpty()) return GetAll();
    else return GetResultByFilter(filter);
  }
}
