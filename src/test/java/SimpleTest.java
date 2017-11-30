import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import quoters.TerminatorQuoterImpl;


public class SimpleTest {




  @Test
  public void testConfig(){
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
        "spring-config.xml");

    classPathXmlApplicationContext.getBean(TerminatorQuoterImpl.class).sayQuote();

  }

}
