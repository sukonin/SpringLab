import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import quoters.TerminatroQuoterImpl;


public class SimpleTest {




  @Test
  public void testConfig(){
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
        "spring-config.xml");

    classPathXmlApplicationContext.getBean(TerminatroQuoterImpl.class).sayQuote();

  }

}
