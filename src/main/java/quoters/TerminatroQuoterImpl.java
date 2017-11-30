package quoters;

public class TerminatroQuoterImpl implements Quoter {

  private String message;

  public void setMessage(String message) {
    this.message = message;
  }

  public void sayQuote() {
    System.out.println(message);
  }
}
