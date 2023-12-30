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

public class Button extends JButton {
    private static final long serialVersionUID = 1L;
    private PlayGround panelPlay;
    private int number;

    public Button(PlayGround panelPlay) {
        number = -1;
        this.panelPlay = panelPlay;
        this.setPreferredSize(new Dimension(47, 47));
    }

    @Override
    public void paint(Graphics g) {
        switch (number) {
            case -1:
                g.drawImage(panelPlay.getGp().getGf().getData().getListImage().get("empty"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 0:
                g.drawImage(panelPlay.getGp().getGf().getData().getListImage().get("empty_play_ground"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 1:
                g.drawImage(panelPlay.getGp().getGf().getData().getListImage().get("one_play_ground"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 2:
                g.drawImage(panelPlay.getGp().getGf().getData().getListImage().get("two_play_ground"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 3:
                g.drawImage(panelPlay.getGp().getGf().getData().getListImage().get("three_play_ground"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 4:
                g.drawImage(panelPlay.getGp().getGf().getData().getListImage().get("four_play_ground"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 5:
                g.drawImage(panelPlay.getGp().getGf().getData().getListImage().get("five_play_ground"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 6:
                g.drawImage(panelPlay.getGp().getGf().getData().getListImage().get("six_play_ground"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 7:
                g.drawImage(panelPlay.getGp().getGf().getData().getListImage().get("seven_play_ground"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 8:
                g.drawImage(panelPlay.getGp().getGf().getData().getListImage().get("eight_play_ground"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 9:
                g.drawImage(panelPlay.getGp().getGf().getData().getListImage().get("flag"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 10:
                g.drawImage(panelPlay.getGp().getGf().getData().getListImage().get("boom"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 11:
                g.drawImage(panelPlay.getGp().getGf().getData().getListImage().get("red_boom"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 12:
                g.drawImage(panelPlay.getGp().getGf().getData().getListImage().get("boom_x"), 0, 0,
                        getPreferredSize().width, getPreferredSize().height, this);
                break;
            default:
                break;
        }
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public PlayGround getPanelPlay() {
        return panelPlay;
    }

    public void setPanelPlay(PlayGround panelPlay) {
        this.panelPlay = panelPlay;
    }

    public int getNumber() {
        return number;
    }

}
