package view;

import javax.swing.JFrame;
import model.LoadData;

public class GameFrame extends JFrame {
    private LoadData data;
    private GamePanel panel;

    public GameFrame(int width, int height, int boom_num) {
        this.pack();
        this.init();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setIconImage(data.getListImage().get("icon"));
        this.setResizable(false);
        this.setTitle("Minesweeper");
        this.setSize(width, height);
        this.add(panel);
    }

    private void init() {
        data = new LoadData();
        panel = new GamePanel(10,10,3, this);
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
