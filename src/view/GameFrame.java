package view;

import javax.swing.JFrame;
import model.LoadData;

public class GameFrame extends JFrame {
    private LoadData data;
    private GamePanel panel;

    public GameFrame(int width, int height, int boom_num) {
        this.init();
        panel = new GamePanel(width, height, boom_num, this);
        this.add(panel);
        this.setIconImage(data.getListImage().get("icon"));
        this.setSize(width * 47, height * 47);
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

    public void setData(LoadData data) {
        this.data = data;
    }

    public GamePanel getPanel() {
        return panel;
    }

    public void setPanel(GamePanel panel) {
        this.panel = panel;
    }
}
