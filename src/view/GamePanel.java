package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Control.World;
import model.LoadData;

public class GamePanel extends JPanel implements MouseListener {
    private JPanel panelPlay;
    private Button[][] arrayButton;
    private PanelHeader header;
    private LoadData data;
    private World world;

    private int width;
    private int height;
    private int boom_num;
    private GameFrame gf;


    public GamePanel(int width, int height, int boom_num, GameFrame gf) {
        this.gf = gf;
        this.init(width, height, boom_num);
        this.setLayout(new BorderLayout());
        this.add(panelPlay, BorderLayout.CENTER);
        this.add(header, BorderLayout.NORTH);
        this.modPlayGround(width, height);
    }

    private void init(int width, int height, int boom_num) {
        header = new PanelHeader(this);
        arrayButton = new Button[width][height];
        data = new LoadData();
        panelPlay = new JPanel();
    }

    private void modPlayGround(int width, int height) {
        panelPlay.setLayout(new GridLayout(width, height));
        for (int i = 0; i < arrayButton.length; i++) {
            for (int j = 0; j < arrayButton[i].length; j++) {
                arrayButton[i][j] = new Button(this);
                panelPlay.add(arrayButton[i][j]);
            }
        }
    }

    public LoadData getData() {
        return data;
    }

    public void setData(LoadData data) {
        this.data = data;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Button[][] arrayButton = header.getArrayButton();
        for(int i = 0; i < arrayButton.length; i++){
            for(int j = 0; j < arrayButton[i].length; j++){
                if(e.getButton() == 1 && e.getSource() == arrayButton[i][j]){
                    if(!world.open(i, j)){
                        int option = JOptionPane.showConfirmDialog(this, "Are you play again?","Notification", 
                        JOptionPane.YES_NO_OPTION);
                        if(option == JOptionPane.YES_OPTION){
                            gf.setVisible(false);
                            new GameFrame(width, height, boom_num);
                        } else {
                            world.fullTrue();
                        }
                    }
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

    public World getWorld(){
        return world;
    }

    public void setWorld(World world){
        this.world = world;
    }

    public Object getGame() {
        return null;
    }
}
