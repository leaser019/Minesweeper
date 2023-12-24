package view.GameUI;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu extends JFrame{
  private BufferedImage image;
  public Menu() throws IOException {
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setSize(1000, 1000);
    this.setVisible(true);
    try {
      image = ImageIO.read(new File("img\\Menu.png"));
    } catch (Exception e) {
      e.printStackTrace();    }

    JPanel pane = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
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