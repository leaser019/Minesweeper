package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

public class SmileButton extends JButton {
    private PanelHeader gp;

    public SmileButton(PanelHeader gp) {
        this.gp = gp;
        this.setPreferredSize(new Dimension(50, 50));
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(gp.getGame().getData().getListImage().get("smile"), 0, 0, getPreferredSize().width,
                getPreferredSize().height, null);
    }
}
