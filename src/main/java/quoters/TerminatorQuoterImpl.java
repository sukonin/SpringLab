package quoters;

import javax.annotation.PostConstruct;

@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoterImpl implements Quoter {

  public void setRepeat(int repeat) {
    this.repeat = repeat;
  }

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

  @PostProxy
  public void sayQuote() {
    System.out.println("Phase 3");
    for (int i = 0; i < repeat; i++) {
      System.out.println(message);
    }

  }
}
