package quoters;

import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

public class ProfilingBeanPostProcessor implements BeanPostProcessor {

  private Map<String, Class> map = new HashMap<String, Class>();
  private ProfilingController controller = new ProfilingController();

  public ProfilingBeanPostProcessor() throws Exception {
    MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
    platformMBeanServer
        .registerMBean(controller, new ObjectName("profiling", "name", "controller"));

  }

  @Nullable
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {

    Class<?> beanClass = bean.getClass();

    if (beanClass.isAnnotationPresent(Profiling.class)) {
      map.put(beanName, bean.getClass());
    }

    return bean;
  }

  @Nullable
  public Object postProcessAfterInitialization(final Object bean, String beanName)
      throws BeansException {

    Class aClass = map.get(beanName);
    ClassLoader classLoader = bean.getClass().getClassLoader();
    Class<?>[] interfaces = bean.getClass().getInterfaces();
    if (aClass != null) {
      return Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

          if (controller.isEnabled()) {
            System.out.println("Profiling...");
            long before = System.nanoTime();
            Object invoke = method.invoke(bean, args);
            long after = System.nanoTime();
            System.out.println(after - before);
            System.out.println("Done!");
            return invoke;
          } else {
            return method.invoke(bean, args);
          }
        }
      });
    }
    return null;
  }
}
