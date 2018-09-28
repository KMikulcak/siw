package swi_dal.DataSource.Contract;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import java.util.Properties;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.pmw.tinylog.Logger;

public abstract class ADataSource implements IDataSource {

  private final Injector _injector;
  private Session _session;
  private final PersistService _persistService;
  private EntityManager _entityManager;

  //Hybernate init process
  protected ADataSource() {
    _injector = Guice
        .createInjector(new JpaPersistModule("monitoring").properties(getHibernateConfig()));

    _persistService = _injector.getInstance(PersistService.class);

    _persistService.start();

    Logger.info(this.getClass().getSimpleName() + " initialized");
  }

  //Hybernate Config
  protected abstract Properties getHibernateConfig();

  @Override
  final public EntityManager EM() {
    if (this._entityManager == null) {
      this._entityManager = _injector.getInstance(EntityManager.class);
    }
    return _entityManager;
  }

  @Override
  final public Session Session(){
    if (this._session == null) {
      this._session = (Session) EM().getDelegate();
    }
    return _session;
  }

  @Override
  protected void finalize() throws Throwable
  {
    _persistService.stop();
  }

}
