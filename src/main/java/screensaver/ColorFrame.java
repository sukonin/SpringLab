package screensaver;

import java.awt.Color;
import java.awt.HeadlessException;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import org.springframework.beans.factory.annotation.Autowired;

public class ColorFrame extends JFrame {

  @Autowired
  private Color color;

  public ColorFrame() throws HeadlessException {
    setSize(200, 200);
    setVisible(true);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  public void showOnRandomPlace() {
    Random random = new Random();
    setLocation(random.nextInt(1200), random.nextInt(700));
    getContentPane().setBackground(color);
    repaint();

  }

}
