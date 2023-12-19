package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class PlayGround extends JPanel {
    private Button[][] arrayButton;
    private GamePanel gp;
    private int width;
    private int height;

    public PlayGround(GamePanel gp) {
        this.gp = gp;
        this.init(gp.getWidth(), gp.getHeight());
        this.modPlayGround(gp.getWidth(), gp.getHeight());
    }

    private void init(int width, int height) {
        this.width = gp.getGame().getWidth();
        this.height = gp.getGame().getHeight();
        arrayButton = new Button[width][height];
    }

    private void modPlayGround(int width, int height) {
        this.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < arrayButton.length; i++) {
            for (int j = 0; j < arrayButton[i].length; j++) {
                arrayButton[i][j] = new Button(gp);
                this.add(arrayButton[i][j]);
            }
        }
    }
}
