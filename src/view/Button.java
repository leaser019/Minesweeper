package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

public class Button extends JButton {
    private GamePanel game;
    private int number;

    public Button(GamePanel gamePanel) {
        number = -1;
        this.game = gamePanel;
        this.setPreferredSize(new Dimension(47,47));
    }

    public Button(PanelPlayer panelPlayer) {
    }

    @Override
    public void paintComponent(Graphics g) {
        switch (number){
            case -1:
                g.drawImage(game.getData().getListImage().get("empty"), 0, 0, this.getPreferredSize().width,
                this.getPreferredSize().height, null);
                break;
            case 0:
                g.drawImage(game.getData().getListImage().get("empty_play_ground"), 0, 0, this.getPreferredSize().width,
                this.getPreferredSize().height, null);
                break;
            case 1:
                g.drawImage(game.getData().getListImage().get("one_play_ground"), 0, 0, this.getPreferredSize().width,
                this.getPreferredSize().height, null);
                break;
            case 2:
                g.drawImage(game.getData().getListImage().get("two_play_ground"), 0, 0, this.getPreferredSize().width,
                this.getPreferredSize().height, null);
                break;
            case 3:
                g.drawImage(game.getData().getListImage().get("three_play_ground"), 0, 0, this.getPreferredSize().width,
                this.getPreferredSize().height, null);
                break;
            case 4:
                g.drawImage(game.getData().getListImage().get("four_play_ground"), 0, 0, this.getPreferredSize().width,
                this.getPreferredSize().height, null);
                break;
            case 5:
                g.drawImage(game.getData().getListImage().get("five_play_ground"), 0, 0, this.getPreferredSize().width,
                this.getPreferredSize().height, null);
                break;
            case 6:
                g.drawImage(game.getData().getListImage().get("six_play_ground"), 0, 0, this.getPreferredSize().width,
                this.getPreferredSize().height, null);
                break;
            case 7:
                g.drawImage(game.getData().getListImage().get("seven_play_ground"), 0, 0, this.getPreferredSize().width,
                this.getPreferredSize().height, null);
                break;
            case 8:
                g.drawImage(game.getData().getListImage().get("eight_play_ground"), 0, 0, this.getPreferredSize().width,
                this.getPreferredSize().height, null);
                break;

        }
        
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setS(int i) {
    }
}
