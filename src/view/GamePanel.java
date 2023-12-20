package view;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import Control.World;
import model.LoadData;

public class GamePanel extends JPanel implements MouseListener{
    private PlayGround panelPlay;
    private Button[][] arrayButton;
    private PanelHeader header;
    private LoadData data;
    private World world;

    private int width;
    private int height;
    private int boom_num;
    private GameFrame gf;


    public GamePanel (int width, int height, int boom_num, GameFrame gf){
        this.gf = gf;
        this.width = width;
        this.height = height;
        this.boom_num = boom_num;

        world = new World(width, height, boom_num);
        setLayout(new BorderLayout(20, 20));
        add(header = new PanelHeader(this), BorderLayout.NORTH);
        panelPlay = new PlayGround(this);
        panelPlay.setArrayButton(new Button[height][width]);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }


    @Override
    public void mousePressed(MouseEvent e) {
        Button[][] arrayButton = panelPlay.getArrayButton();
        for(int i = 0; i < arrayButton.length; i++){
            for(int j = 0; j < arrayButton[i].length; j++){
                if(e.getButton() == MouseEvent.BUTTON1 && e.getSource() == arrayButton[i][j]){
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


    public PlayGround getPanelPlay() {
        return panelPlay;
    }


    public void setPanelPlay(PlayGround panelPlay) {
        this.panelPlay = panelPlay;
    }


    public PanelHeader getHeader() {
        return header;
    }


    public void setHeader(PanelHeader header) {
        this.header = header;
    }


    public LoadData getData() {
        return data;
    }


    public void setData(LoadData data) {
        this.data = data;
    }


    public World getWorld() {
        return world;
    }


    public void setWorld(World world) {
        this.world = world;
    }


    public int getWidth() {
        return width;
    }


    public void setWidth(int width) {
        this.width = width;
    }


    public int getHeight() {
        return height;
    }


    public void setHeight(int height) {
        this.height = height;
    }


    public int getBoom_num() {
        return boom_num;
    }


    public void setBoom_num(int boom_num) {
        this.boom_num = boom_num;
    }


    public GameFrame getGf() {
        return gf;
    }


    public void setGf(GameFrame gf) {
        this.gf = gf;
    }
}
