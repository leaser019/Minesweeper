/*
 * DSA PROJECT - MINESWEEPER
 * VO MINH KHANG - ITCSIU21136
 * NGUYEN TRONG NGUYEN - ITITIU21263
 * NGUYEN HOANG GIA AN - ITCSIU2161
 */
package view.GUI;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.w3c.dom.events.MouseEvent;

import view.GameFrame;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import java.awt.Graphics;

public class GameOver extends JFrame {
    private int width, height, boom_num;
    private JPanel content;
    static BufferedImage img;

    public GameOver(int width, int height, int boom_num) {
        this.width = width;
        this.height = height;
        this.boom_num = boom_num;
        setResizable(false);
        setFont(new Font("Times New Roman", Font.PLAIN, 14));
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                "img\\icon.png"));
        setTitle("Minesweeper");
        setSize(585, 600);
        setLocationRelativeTo(null);
        try {
            img = ImageIO.read(new File("img\\GameOver.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
          MouseAdapter mouseAdapter = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                GameFrame gf = new GameFrame(width, height, boom_num);
                dispose();
            }
        };
        content = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(img, 0, 0, null);
            }
        };
        content.addMouseListener(mouseAdapter);
        content.setSize(getPreferredSize());
        this.add(content);

        this.setVisible(true);
    }
}
