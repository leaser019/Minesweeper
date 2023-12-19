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


    public GamePanel(int width, int height, int boom_num, GameFrame gf) {
        this.gf = gf;
        this.width = width;
        this.height = height;
        this.boom_num = boom_num;
        this.init();
        this.setLayout(new BorderLayout());
        this.add(panelPlay, BorderLayout.CENTER);
        this.add(header, BorderLayout.NORTH);
        arrayButton = new Button[width][height];
    }

    private void init() {
        header = new PanelHeader(this);
        arrayButton = new Button[width][height];
        data = new LoadData();
        panelPlay = new PlayGround(this);
    }


    public LoadData getData() {
        return data;
    }

    public void setData(LoadData data) {
        this.data = data;
    }

    public World getWorld(){
        return world;
    }

    public void setWorld(World world){
        this.world = world;
    }

    public GameFrame getGame() {
        return gf;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
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

    public PlayGround getPanelPlay() {
        return panelPlay;
    }

    public void setPanelPlay(PlayGround panelPlay) {
        this.panelPlay = panelPlay;
    }

    public Button[][] getArrayButton() {
        return arrayButton;
    }

    public void setArrayButton(Button[][] arrayButton) {
        this.arrayButton = arrayButton;
    }

    public PanelHeader getHeader() {
        return header;
    }

    public void setHeader(PanelHeader header) {
        this.header = header;
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
