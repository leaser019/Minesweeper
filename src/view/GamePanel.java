package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    private JPanel panelLeft, panelRight, panelMid, panelHead, panelPlay;
    private JLabel labelLeft, labelRight;
    private JButton[][] playGround;
    private JButton smile;

    public GamePanel(int width, int height, int boom_num) {
        this.init(width, height);
        this.setLayout(new BorderLayout());
        this.add(panelHead, BorderLayout.NORTH);
        this.add(panelPlay, BorderLayout.CENTER);
        this.modHeadPanel();
        this.modPlayGround(width, height);
    }

    private void init(int width, int height) {
        playGround = new JButton[width][height];
        panelHead = new JPanel();
        panelMid = new JPanel();
        panelLeft = new JPanel();
        panelRight = new JPanel();
        panelPlay = new JPanel();
    }

    private void modHeadPanel() {
        panelHead.setLayout(new BorderLayout());
        panelHead.add(panelLeft, BorderLayout.EAST);
        panelHead.add(panelRight, BorderLayout.WEST);
        panelHead.add(panelMid, BorderLayout.CENTER);
        labelLeft = new JLabel("Time");
        labelRight = new JLabel("Boom_Num");
        smile = new JButton("Icon");
        panelLeft.add(labelLeft);
        panelRight.add(labelRight);
        panelMid.add(smile);
    }

    private void modPlayGround(int width, int height) {
        panelPlay.setLayout(new GridLayout(width, height));
        for (int i = 0; i < playGround.length; i++) {
            for (int j = 0; j < playGround[i].length; j++) {
                playGround[i][j] = new JButton();
                panelPlay.add(playGround[i][j]);
            }
        }
    }
}
