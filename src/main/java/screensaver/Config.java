package screensaver;


import java.awt.Color;
import java.util.Random;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "screensaver")
public class Config {

  @Bean
  public Color color() {
    Random random = new Random();

    return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));

  }


  public static void main(String[] args) throws InterruptedException {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        Config.class);

    while (true) {
      context.getBean(ColorFrame.class).showOnRandomPlace();
      Thread.sleep(500);

    }

  }


}

