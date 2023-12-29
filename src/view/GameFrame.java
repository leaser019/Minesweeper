/*
 * DSA PROJECT - MINESWEEPER
 * VO MINH KHANG - ITCSIU21136
 * NGUYEN TRONG NGUYEN - ITITIU21263
 * NGUYEN HOANG GIA AN - ITCSIU2161
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import model.LoadData;

public class GameFrame extends JFrame {
    private LoadData data;
    private GamePanel panel;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem easy, intermediate, expert, newGame, quitGame;

    public GameFrame(int width, int height, int boom_num) {

        this.init();

        setJMenuBar(menuBar = new JMenuBar());
        menuBar.add(menu = new JMenu("Game"));
        menu.add(newGame = new JMenuItem("New game"));
        menu.addSeparator();
        menu.add(easy = new JMenuItem("Easy"));
        menu.add(intermediate = new JMenuItem("Intermediate"));
        menu.add(expert = new JMenuItem("Expert"));
        menu.addSeparator();
        menu.add(quitGame = new JMenuItem("Quit"));

        KeyStroke ctrlNKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
        newGame.setAccelerator(ctrlNKeyStroke);

        KeyStroke ctrlQKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK);
        quitGame.setAccelerator(ctrlQKeyStroke);

        KeyStroke ctrl1KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_1, KeyEvent.CTRL_DOWN_MASK);
        easy.setAccelerator(ctrl1KeyStroke);

        KeyStroke ctrl2KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_2, KeyEvent.CTRL_DOWN_MASK);
        intermediate.setAccelerator(ctrl2KeyStroke);

        KeyStroke ctrl3KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_3, KeyEvent.CTRL_DOWN_MASK);
        expert.setAccelerator(ctrl3KeyStroke);

        if (width == 8) {
            easy.setIcon(new ImageIcon(data.getListImage().get("stick")));
        } else if (width == 16) {
            intermediate.setIcon(new ImageIcon(data.getListImage().get("stick")));
        } else {
            expert.setIcon(new ImageIcon(data.getListImage().get("stick")));
        }

        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new GameFrame(8, 8, 10);
            }
        });

        intermediate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new GameFrame(16, 16, 40);
            }
        });

        expert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new GameFrame(20, 20, 77);
            }

        });

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new GameFrame(width, height, boom_num);
            }
        });

        quitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel = new GamePanel(width, height, boom_num, this);
        this.add(panel);
        this.setIconImage(data.getListImage().get("icon"));
        this.setSize(width * 47, height * 52);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Minesweeper");
    }

    private void init() {
        data = new LoadData();
    }

    public LoadData getData() {
        return data;
    }

    public GamePanel getPanel() {
        return panel;
    }
}
