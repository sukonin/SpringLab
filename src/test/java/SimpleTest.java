import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import quoters.Quoter;


public class SimpleTest {


  @Test
  public void testConfig() throws InterruptedException {

    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
        "spring-config.xml");


  }

}
