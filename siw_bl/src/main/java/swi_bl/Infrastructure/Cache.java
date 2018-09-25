package swi_bl.Infrastructure;

import com.google.common.primitives.Longs;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.lang.ref.SoftReference;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import org.pmw.tinylog.Logger;

public class Cache {

  private final ConcurrentHashMap<String, SoftReference<Object>> cache = new ConcurrentHashMap<>();
  private final DelayQueue<DelayedCacheObject> cleaningUpQueue = new DelayQueue<>();
  private static Cache _cache;

  Cache() {
    Thread cleanerThread = new Thread(() -> {
      while (!Thread.currentThread().isInterrupted()) {
        try {
          DelayedCacheObject delayedCacheObject = cleaningUpQueue.take();
          cache.remove(delayedCacheObject._key, delayedCacheObject._reference);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
    });
    cleanerThread.setDaemon(true);
    cleanerThread.start();
  }

  public static Cache Current(){
    if(_cache == null) _cache = new Cache();
    return _cache;
  }

  public void add(String key, Object value, long periodInMillis) {
    if (key == null) {
      return;
    }
    if (value == null) {
      cache.remove(key);
    } else {
      long expiryTime = System.currentTimeMillis() + periodInMillis;
      SoftReference<Object> reference = new SoftReference<>(value);
      cache.put(key, reference);
      cleaningUpQueue.put(new DelayedCacheObject(key, reference, expiryTime));

      Logger.info(this.getClass().toString()
          + ": added "
          + value.getClass().toString()
          + ", duration in seconds: " + LocalDateTime.now().plusSeconds(periodInMillis / 1000).format(
          DateTimeFormatter.ISO_DATE_TIME));
    }
  }

  public void remove(String key) {
    cache.remove(key);
  }

  public Object get(String key) {
    return Optional.ofNullable(cache.get(key)).map(SoftReference::get).orElse(null);
  }

  public void clear() {
    cache.clear();
  }

  public long size() {
    return cache.size();
  }

  @AllArgsConstructor
  @EqualsAndHashCode
  private static class DelayedCacheObject implements Delayed {

    @Getter
    private final String _key;
    @Getter
    private final SoftReference<Object> _reference;
    private final long _expiryTime;

    DelayedCacheObject(String key, SoftReference<Object> reference, long expiryTime){
      _key = key;
      _reference = reference;
      _expiryTime = expiryTime;
    }

    public long getDelay(TimeUnit unit) {
      return unit.convert(_expiryTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public int compareTo(Delayed o) {
      return Longs.compare(_expiryTime, ((DelayedCacheObject) o)._expiryTime);
    }
  }

  public static String KeyBuilder(String prefix, String value){
    return prefix + value;
  }
}
