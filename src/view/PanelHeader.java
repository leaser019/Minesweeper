package view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelHeader extends JPanel {
    private GamePanel game;
    private JPanel panelLeft, panelRight, panelCenter;
    private JLabel labelLeft, labelRight;
    private JButton icon;

    public PanelHeader(GamePanel game) {
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

        panelLeft = new JPanel();
        panelRight = new JPanel();
        panelCenter = new JPanel();

        labelLeft = new JLabel("Score");
        labelRight = new JLabel("Boom_num");
        icon = new JButton("Smile");

    }
}
