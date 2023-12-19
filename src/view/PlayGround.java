package view;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import Control.World;
import model.LoadData;

public class PlayGround extends JPanel implements MouseListener {
    private World world;
    private Button[][] arrayButton;
    private GamePanel panel;
    private LoadData data;

    public PlayGround(GamePanel panel) {
        this.panel = panel;
        this.world = panel.getWorld();
        this.data = panel.getData();
        this.arrayButton = new Button[panel.getWidth()][panel.getHeight()];
        this.setLayout(new GridLayout(panel.getWidth(), panel.getHeight()));
        for(int i = 0; i < arrayButton.length; i++){
            for(int j = 0; j < arrayButton[i].length; j++){
                arrayButton[i][j] = new Button(i, j, panel);
                arrayButton[i][j].addMouseListener(this);
                this.add(arrayButton[i][j]);
            }
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Button[][] arrayButton = this.getArrayButton();
        for(int i = 0; i < arrayButton.length; i++){
            for(int j = 0; j < arrayButton[i].length; j++){
                if(e.getButton() == 1 && e.getSource() == arrayButton[i][j]){
                    world.open(i, j);
                }
            }
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public Button[][] getArrayButton() {
        return arrayButton;
    }

    public void setArrayButton(Button[][] arrayButton) {
        this.arrayButton = arrayButton;
    }

    public void updateArrayButton(){
        arrayButton = panel.getArrayButton();
    }

    public LoadData getData(){
        return data;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public void setData(LoadData data) {
        this.data = data;
    }
}
