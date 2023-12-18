package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import control.World;
import model.LoadData;

public class GamePanel extends JPanel implements MouseListener {
    private PanelPlayer panelPlay;
    private Button[][] playGround;
    private PanelHeader header;
    private LoadData data;

    private GameFrame gf;

    private World world;

    private int width;
    private int height;
    private int boom_num;
    private PanelHeader getHeader;

    public GamePanel(int width, int height, int boom_num, GameFrame gameFrame) {
        this.init(width, height);
        this.setLayout(new BorderLayout());
        this.add(panelPlay, BorderLayout.CENTER);
        this.add(header, BorderLayout.NORTH);
        this.modPlayGround(width, height);

        world = new World(width, height, boom_num, this);
    }

    private void init(int width, int height) {
        header = new PanelHeader(this);
        playGround = new Button[width][height];
        data = new LoadData();
        panelPlay = new PanelPlayer(null);
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

    @Override
    public void mouseClicked(MouseEvent e){
    }

    @Override
    public void mousePressed(MouseEvent e){
        Button[][] arrayButton = panelPlay.getArrayButton();
        for(int i = 0; i < arrayButton.length; i++){
            for(int j = 0; j < arrayButton[i].length; j++){
                if(e.getButton() == 1 && e.getSource() == arrayButton[i][j] && !World.getArrayFlag()[i][j]){
                    if(!((Object) getHeader.getTime()).isRunning()){
                        ((Object) getHeader().getTime()).start();
                    }
                }
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
    public void mouseReleased(MouseEvent e) {
        getHeader().getIcon().setName((String) SmileButton.now);
        getHeader().getIcon().repaint();
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }

    public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public GameFrame getGameFrame() {
		return gf;
	}

	public void setGameFrame(GameFrame gameFrame) {
		this.gf = gameFrame;
	}

	public int getBoom_num() {
		return boom_num;
	}

	public void setBoom_num(int boom_num) {
		this.boom_num = boom_num;
	}

	public PanelHeader getHeader() {
		return header;
	}

	public void setHeader(PanelHeader header) {
		this.header = header;
	}

	public PanelPlayer getPanelPlay() {
		return panelPlay;
	}

	public void setPanelPlay(PanelPlayer panelPlay) {
		this.panelPlay = panelPlay;
	}
}
