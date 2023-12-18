package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import model.LoadData;

public class GamePanel extends JPanel implements MouseListener {
    private JPanel panelPlay; //
    private Button[][] playGround;
    private PanelHeader header;
    private LoadData data;

    public GamePanel(int width, int height, int boom_num) {
        this.init(width, height);
        this.setLayout(new BorderLayout());
        this.add(panelPlay, BorderLayout.CENTER);
        this.add(header, BorderLayout.NORTH);
        this.modPlayGround(width, height);
    }

    private void init(int width, int height) {
        header = new PanelHeader(this);
        playGround = new Button[width][height];
        data = new LoadData();
        panelPlay = new JPanel();
    }

    private void modPlayGround(int width, int height) {
        panelPlay.setLayout(new GridLayout(width, height));
        for (int i = 0; i < playGround.length; i++) {
            for (int j = 0; j < playGround[i].length; j++) {
                playGround[i][j] = new Button(this);
                panelPlay.add(playGround[i][j]);
            }
        }
    }

    public LoadData getData() {
        return data;
    }

    public void setData(LoadData data) {
        this.data = data;
    }
}
