package view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
public class PanelPlayer extends JPanel {
    private GamePanel game;
    private Button[][] playGround;
    public PanelPlayer(){
        setLayout(new GridLayout(game.getWidth(), game.getWidth()));

        playGround = game.getWorld().getPlayGround();

        setBorder(BorderFactory.createLoweredBevelBorder());
        for(int i = 0; i < playGround.length; i++){
            for(int j = 0; j < playGround[i].length; j++){
                add(playGround[i][j] = new Button(game));
                playGround[i][j].addMouseListener(game);
            }
        }
    }

    public GamePanel getGame() {
        return game;
    }
    public void setGame(GamePanel game) {
        this.game = game;
    }
    public Button[][] getPlayGround() {
        return playGround;
    }
    public void setPlayGround(Button[][] playGround) {
        this.playGround = playGround;
    }
}
