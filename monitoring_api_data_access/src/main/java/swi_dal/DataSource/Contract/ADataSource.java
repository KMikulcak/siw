package swi_dal.DataSource.Contract;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import java.util.List;
import java.util.Properties;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.pmw.tinylog.Logger;
import swi_dal.Entity.Contract.IEntity;

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
  final public Session Session() {
    if (this._session == null) {
      this._session = (Session) EM().getDelegate();
    }
    return _session;
  }

  public void ListTransaction(List<IEntity> entities, TransactionType transactionType) {
    EM().getTransaction().begin();

    switch (transactionType){
      case Add:
        addNewEntries(entities);
        break;
      case Merge:
        mergeNewEntries(entities);
        break;
      case Update:
        updateEntries(entities);
        break;
      case Delete:
        deleteEntries(entities);
        break;
    }
    EM().getTransaction().commit();
  }

  public void Transaction(IEntity entity, TransactionType transactionType) {
    EM().getTransaction().begin();
    switch (transactionType){
      case Add:
        addNewEntry(entity);
        break;
      case Merge:
        mergeNewEntry(entity);
        break;
      case Update:
        updateEntry(entity);
        break;
      case Delete:
        deleteEntry(entity);
        break;
    }
    EM().getTransaction().commit();
  }

  public enum TransactionType {
    Add, Merge, Update, Delete
  }

  protected void addNewEntries(List<IEntity> entities) {
    for (IEntity entity:entities
    ) {
      addNewEntry(entity);
    }
  }

  protected void mergeNewEntries(List<IEntity> entities) {
    for (IEntity entity:entities
    ) {
      mergeNewEntry(entity);
    }
  }

  protected void updateEntries(List<IEntity> entities) {
    for (IEntity entity:entities
    ) {
      updateEntry(entity);
    }
  }

  protected void deleteEntries(List<IEntity> entities) {
    for (IEntity entity:entities
    ) {
      deleteEntry(entity);
    }
  }

  protected void addNewEntry(IEntity entity) {
    EM().persist(entity);
  }

  protected void mergeNewEntry(IEntity entity) {
    EM().merge(entity);
  }

  protected void updateEntry(IEntity entity) {
    Session().saveOrUpdate(entity);
  }

  protected void deleteEntry(IEntity entity) {
    Session().delete(entity);
  }

  @Override
  protected void finalize() throws Throwable {
    _persistService.stop();
  }
}
