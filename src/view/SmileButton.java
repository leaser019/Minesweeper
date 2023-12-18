package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

public class SmileButton extends JButton {
    public static Object now;
    protected static Object press;
    private PanelHeader gp;

    public SmileButton(PanelHeader gp) {
        this.gp = gp;
        this.setPreferredSize(new Dimension(45, 45));
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(gp.getGame().getData().getListImage().get("smile"), 0, 0, getPreferredSize().width,
                getPreferredSize().height, null);
    }

    public void setStage(Object now2) {
    }
}
