package swi_bl.Service;

import java.util.ArrayList;
import java.util.List;
import org.pmw.tinylog.Logger;
import swi_bl.Infrastructure.Cache;
import swi_bl.Infrastructure.RuleSet;
import swi_bl.Model.IModel;

abstract class AService<Model extends IModel> {

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

  public Model Get(int id) {
    Model model = null;

    if (_ruleSet.IsCaching()) {
      model = (Model) Cache.Current()
          .get(Cache.KeyBuilder(_keyPrefix, Integer.toString(id)));
      if (model == null) {
        model = GetModel(id);
        Cache.Current().add(Cache.KeyBuilder(_keyPrefix, Integer.toString(id)), model,
            _ruleSet.UpdateDuration());
      }
    } else {
      model = GetModel(id);
    }

    return model;
  }

  abstract Model GetModel(int id);

  public List<Model> Get() {
    List<Model> models = new ArrayList<Model>();

    if (_ruleSet.IsCaching()) {

      models = (List<Model>) Cache.Current()
          .get(Cache.KeyBuilder(_keyPrefix, models.getClass().toString()));
      if (models == null) {
        models = GetModels();
        Cache.Current().add(Cache.KeyBuilder(_keyPrefix, models.getClass().toString()), models,
            _ruleSet.UpdateDuration());
      }
    } else {
      models = GetModels();
    }

    return models;
  }

  abstract List<Model> GetModels();
}
