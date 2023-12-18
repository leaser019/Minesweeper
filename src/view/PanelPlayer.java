package view;

import java.awt.GridLayout;
public class PanelPlayer extends JPanel {
    public PanelPlayer(GamePanel game){
        this.game = game;

        setLayout(new GridLayout(game.getWidth(), game.getWidth()));
    }
    
}
