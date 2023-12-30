/*
 * DSA PROJECT - MINESWEEPER
 * VO MINH KHANG - ITCSIU21136
 * NGUYEN TRONG NGUYEN - ITITIU21263
 * NGUYEN HOANG GIA AN - ITCSIU2161
 */
package view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PlayGround extends JPanel {
    private GamePanel gp;
    private Button[][] arrayButton;

    public PlayGround(GamePanel gp) {
        this.gp = gp;
        arrayButton = gp.getArrayButton();
        setLayout(new GridLayout(gp.getCols(), gp.getRows()));
        setBorder(BorderFactory.createLoweredBevelBorder());

        for (int i = 0; i < gp.getRows(); i++) {
            for (int j = 0; j < gp.getCols(); j++) {
                arrayButton[i][j] = new Button(this);
                arrayButton[i][j].addMouseListener(gp);
                add(arrayButton[i][j]);
            }
        }
    }

    public GamePanel getGp() {
        return gp;
    }

    public void setGp(GamePanel gp) {
        this.gp = gp;
    }

    public Button[][] getArrayButton() {
        return arrayButton;
    }

    public void setArrayButton(Button[][] arrayButton) {
        this.arrayButton = arrayButton;
    }
}