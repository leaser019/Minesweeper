package view;

import javax.swing.JFrame;
import model.LoadData;

public class GameFrame extends JFrame {
    private LoadData data;
    private GamePanel panel;

    public GameFrame() {
        this.pack();
        this.init();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setIconImage(data.getListImage().get("icon"));
        this.setTitle("Minesweeper");
        this.setSize(500, 500);
        this.add(panel);
    }

    private void init() {
        data = new LoadData();
        panel = new GamePanel(10,10,3);
    }
}
