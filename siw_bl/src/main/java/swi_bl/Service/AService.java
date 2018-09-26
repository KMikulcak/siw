package swi_bl.Service;

import java.util.ArrayList;
import java.util.List;
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

    Logger.info(this.toString() + "initialized"
        + ", with KeyPrefix:'" + keyPrefix + "'"
        + ", and caching " + _ruleSet.IsCaching());
  }

  String KeyPrefix() {
    return _keyPrefix;
  }

  public Entity Get(Identifier id) {
    Entity entity = null;

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

    if (_ruleSet.IsCaching()) {

      result = (Result) Cache.Current()
          .get(Cache.KeyBuilder(_keyPrefix, filter));
      if (result == null) {
        result = GetResultByFilter(filter);
        Cache.Current().add(Cache.KeyBuilder(_keyPrefix, filter), result,
            _ruleSet.UpdateDuration());
      }
    } else {
      result = GetResultByFilter(filter);
    }

    return result;
  }

  abstract Result GetResultByFilter(String filter);
}
