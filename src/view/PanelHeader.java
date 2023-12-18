package view;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

public class PanelHeader extends JPanel {
    private GamePanel game;
    private JPanel panelLeft, panelRight, panelCenter;
    private Number labelLeft, labelRight;
    private SmileButton icon;

    public PanelHeader(GamePanel game) {
        this.game = game;
        this.init();
        this.add(panelLeft, BorderLayout.EAST);
        this.add(panelRight, BorderLayout.WEST);
        this.add(panelCenter, BorderLayout.CENTER);

        panelLeft.add(labelLeft);
        panelCenter.add(icon);
        panelRight.add(labelRight);
    }

    private void init() {
        this.setLayout(new BorderLayout());
        BorderLayout layout = (BorderLayout) this.getLayout();
        layout.setVgap(160);
        panelLeft = new JPanel();
        panelRight = new JPanel();
        panelCenter = new JPanel();

        labelLeft = new Number(this, "000");
        labelRight = new Number(this, "000");
        icon = new SmileButton(this);
    }

    public GamePanel getGame() {
        return game;
    }

    public void setGame(GamePanel game) {
        this.game = game;
    }

    public void updateLableLeft() {
    }

    public Object getTime() {
        return null;
    }

    public Component getIcon() {
        return null;
    }
}
