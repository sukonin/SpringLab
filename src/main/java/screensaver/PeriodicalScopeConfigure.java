package screensaver;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;


public class PeriodicalScopeConfigure implements Scope {

  private final Map<String, Pair<LocalTime, Object>> map = new HashMap<>();

  @Override
  public Object get(String name, ObjectFactory<?> objectFactory) {
    if (map.containsKey(name)) {
      final Pair<LocalTime, Object> pair = map.get(name);
      final int secondsSinceLastRequest = LocalTime.now().getSecond() - pair.getKey().getSecond();
      if (secondsSinceLastRequest > 0.1) {
        map.put(name, new Pair<>(LocalTime.now(), objectFactory.getObject()));
      }
    } else {
      map.put(name, new Pair<>(LocalTime.now(), objectFactory.getObject()));
    }
    return map.get(name).getValue();
  }

  @Override
  public Object remove(String name) {
    return null;
  }

  @Override
  public void registerDestructionCallback(String name, Runnable callback) {

  }

  @Override
  public Object resolveContextualObject(String key) {
    return null;
  }

  @Override
  public String getConversationId() {
    return null;
  }

}