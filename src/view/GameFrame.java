package view;

import javax.swing.JFrame;
import model.LoadData;

public class GameFrame extends JFrame {
    private LoadData data;
    public GameFrame(int width, int height, int boom_num) {
        data = new LoadData();
        // this.pack();
        this.init();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setIconImage(data.getListImage().get("icon"));
        this.setResizable(false);
        this.setTitle("Minesweeper");
        this.setSize(width, height);
        add(new GamePanel(width, height, boom_num, this));
    }

    public GameFrame() {
    }

    private void init() {
        data = new LoadData();
        new GamePanel(10, 10, 3, null);
    }
}
