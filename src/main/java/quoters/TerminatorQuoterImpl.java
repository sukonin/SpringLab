package quoters;

public class TerminatorQuoterImpl implements Quoter {

  @InjectRandomInt(min = 1, max = 10)
  private int repeat;

  private String message;

  public void setMessage(String message) {
    this.message = message;
  }

  public void sayQuote() {

    for (int i = 0; i < repeat; i++) {
      System.out.println(message);
    }

  }
}
