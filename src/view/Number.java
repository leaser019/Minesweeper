/*
 * DSA PROJECT - MINESWEEPER
 * VO MINH KHANG - ITCSIU21136
 * NGUYEN TRONG NGUYEN - ITITIU21263
 * NGUYEN HOANG GIA AN - ITCSIU2161
 */
package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;

public class Number extends JLabel {
    private PanelHeader gp;
    private String s;

    public Number(PanelHeader gp, String s) {
        this.gp = gp;
        this.s = s;
        this.setPreferredSize(new Dimension(75, 45));
    }

    @Override
    public void paintComponent(Graphics g) {
        if (s.equals("infi")) {
            g.drawImage(gp.getGame().getData().getListImage().get("infi"), 0, 0, 25,
                    getPreferredSize().height, null);
            g.drawImage(gp.getGame().getData().getListImage().get("infi"), 25, 0, 25,
                    getPreferredSize().height, null);
            g.drawImage(gp.getGame().getData().getListImage().get("infi"), 50, 0, 25,
                    getPreferredSize().height, null);
        } else {
            g.drawImage(gp.getGame().getData().getListImage().get(String.valueOf(s.charAt(0))), 0, 0, 25,
                    getPreferredSize().height, null);
            g.drawImage(gp.getGame().getData().getListImage().get(String.valueOf(s.charAt(1))), 25, 0, 25,
                    getPreferredSize().height, null);
            g.drawImage(gp.getGame().getData().getListImage().get(String.valueOf(s.charAt(2))), 50, 0, 25,
                    getPreferredSize().height, null);
        }

    }

    public PanelHeader getGp() {
        return gp;
    }

    public void setGp(PanelHeader gp) {
        this.gp = gp;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

}
