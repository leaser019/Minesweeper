package view;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class PlayGround extends JPanel implements MouseListener {
    private Button[][] arrayButton;
    private GamePanel gp;
    private int width;
    private int height;

    public PlayGround(GamePanel gp) {
        this.gp = gp;
        this.init(gp.getWidth(), gp.getHeight());
        // this.modPlayGround(gp.getWidth(), gp.getHeight());
    }

    private void init(int width, int height) {
        this.width = gp.getGame().getWidth();
        this.height = gp.getGame().getHeight();
        arrayButton = new Button[width][height];
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
    
}
