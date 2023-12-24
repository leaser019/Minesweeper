package view.GameUI;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu extends JFrame {
  private BufferedImage image;

  public Menu() throws IOException {
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setSize(874, 643);
    this.setVisible(true);
    image = ImageIO.read(new File("img\\Menu.png"));
    JPanel pane = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 5, 5, null);
      }
    };
    this.add(pane);
  }

  public static void main(String[] args) {
    try {
      Menu m = new Menu();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}