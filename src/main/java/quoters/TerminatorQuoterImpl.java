package quoters;

import javax.annotation.PostConstruct;

@Profiling
public class TerminatorQuoterImpl implements Quoter {

  @InjectRandomInt(min = 1, max = 10)
  private int repeat;

  private String message;

  public TerminatorQuoterImpl() {
    System.out.println("Phase 1");
  }

  @PostConstruct
  public void init() {
    System.out.println("Phase 2");
    System.out.println(repeat);
  }


  public void setMessage(String message) {
    this.message = message;
  }

  public void sayQuote() {

    for (int i = 0; i < repeat; i++) {
      System.out.println(message);
    }

  }
}
