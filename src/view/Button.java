package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

public class Button extends JButton {
    private GamePanel game;

    public Button(GamePanel game) {
        this.game = game;
        this.setPreferredSize(new Dimension(48,48));
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(game.getData().getListImage().get("empty"), 0, 0, this.getPreferredSize().width,
                this.getPreferredSize().height, null);
    }
}
