package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

import model.LoadData;

import control.World;

public class GamePanel extends JPanel implements MouseListener {
    private JPanel panelPlay;
    private Button[][] playGround;
    private PanelHeader header;
    private LoadData data;
    private int boom_num;
    private GameFrame gameFrame;

    private World world;
     
    private int weight;
    private int height;

    public GamePanel(int width, int height, int boom_num, GameFrame gameFrame2) {
        this.init(width, height);
        this.setLayout(new BorderLayout());
        this.add(panelPlay, BorderLayout.CENTER);
        this.add(header, BorderLayout.NORTH);
        this.modPlayGround(width, height);
        this.boom_num = boom_num;
    }

    private void init(int width, int height) {
        header = new PanelHeader(this);
        playGround = new Button[width][height];
        data = new LoadData();
        panelPlay = new JPanel();
        world = new World(gameFrame.getWidth(),gameFrame.getHeight(),boom_num,this);
    }

    private void modPlayGround(int width, int height) {
        panelPlay.setLayout(new GridLayout(width, height));
        for (int i = 0; i < playGround.length; i++) {
            for (int j = 0; j < playGround[i].length; j++) {
                playGround[i][j] = new Button(this);
                panelPlay.add(playGround[i][j]);
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
        //Auto-generated method stub 
    }

    @Override
    public void mouseReleased(MouseEvent e){
    }

    @Override
    public void mouseEntered(MouseEvent e){
    }

    @Override
    public void mouseExited(MouseEvent e){
    }

    public JPanel getPanelPlay() {
        return panelPlay;
    }

    public void setPanelPlay(JPanel panelPlay) {
        this.panelPlay = panelPlay;
    }

    public Button[][] getPlayGround() {
        return playGround;
    }

    public void setPlayGround(Button[][] playGround) {
        this.playGround = playGround;
    }

    public PanelHeader getHeader() {
        return header;
    }

    public void setHeader(PanelHeader header) {
        this.header = header;
    }

    public int getBoom_num() {
        return boom_num;
    }

    public void setBoom_num(int boom_num) {
        this.boom_num = boom_num;
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

   
}
