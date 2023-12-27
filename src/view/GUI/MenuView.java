package view.GUI;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.GameFrame;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class MenuView extends JFrame {
    private int width, height, boom_num;
    private JPanel content;
    static BufferedImage img;

    public MenuView(int width, int height, int boom_num) {
        this.width = width;
        this.height = height;
        this.boom_num = boom_num;
        setResizable(false);
        setFont(new Font("Times New Roman", Font.PLAIN, 14));
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                "img\\icon.png"));
        setTitle("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 620);
        setLocationRelativeTo(null);
        try {
            img = ImageIO.read(new File("img\\Menu.png"));
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
