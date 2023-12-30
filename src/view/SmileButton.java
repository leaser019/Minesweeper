/*
 * DSA PROJECT - MINESWEEPER
 * VO MINH KHANG - ITCSIU21136
 * NGUYEN TRONG NGUYEN - ITITIU21263
 * NGUYEN HOANG GIA AN - ITCSIU2161
 */
package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

public class SmileButton extends JButton {
    public static final int win = 0;
    public static final int lose = 1;
    public static final int press = 2;
    public static final int wow = 3;
    public static final int now = 4;

    private PanelHeader gp;
    private int stage;

    public SmileButton(PanelHeader gp) {
        this.gp = gp;
        this.setPreferredSize(new Dimension(45, 45));
        stage = now;
    }

    @Override
    public void paintComponent(Graphics g) {
        switch (stage) {
            case win:
                g.drawImage(gp.getGame().getData().getListImage().get("smileWin"), 0, 0, getPreferredSize().width,
                        getPreferredSize().height, null);
                break;
            case lose:
                g.drawImage(gp.getGame().getData().getListImage().get("smileLose"), 0, 0, getPreferredSize().width,
                        getPreferredSize().height, null);
                break;
            case press:
                g.drawImage(gp.getGame().getData().getListImage().get("smilePress"), 0, 0, getPreferredSize().width,
                        getPreferredSize().height, null);
                break;
            case wow:
                g.drawImage(gp.getGame().getData().getListImage().get("smilePressPlay"), 0, 0, getPreferredSize().width,
                        getPreferredSize().height, null);
                break;
            case now:
                g.drawImage(gp.getGame().getData().getListImage().get("smile"), 0, 0, getPreferredSize().width,
                        getPreferredSize().height, null);
                break;
            default:
                break;
        }
    }

    public PanelHeader getGp() {
        return gp;
    }

    public void setGp(PanelHeader gp) {
        this.gp = gp;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

}
