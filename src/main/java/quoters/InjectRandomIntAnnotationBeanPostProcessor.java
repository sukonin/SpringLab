package quoters;

import java.lang.reflect.Field;
import java.util.Random;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.util.ReflectionUtils;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

  @Nullable
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {

    Field[] fields = bean.getClass().getDeclaredFields();

    for (Field field : fields) {
      InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);

      if (annotation != null) {
        int min = annotation.min();
        int max = annotation.max();
        Random random = new Random();
        int randomInt = min + random.nextInt(max - min);
        field.setAccessible(true);
        ReflectionUtils.setField(field, bean, randomInt);
      }

    }

    return bean;
  }

  @Nullable
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    return bean;
  }


}
