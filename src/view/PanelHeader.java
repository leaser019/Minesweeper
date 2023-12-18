package view;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelHeader extends JPanel {
    private GamePanel game;
    private JPanel panelLeft, panelRight, panelCenter;
    private Number labelLeft, labelRight;
    private SmileButton icon;

    private int nowTime;
    public PanelHeader(GamePanel game) {
        this.game = game;
        this.init();
        this.add(panelLeft, BorderLayout.EAST);
        this.add(panelRight, BorderLayout.WEST);
        this.add(panelCenter, BorderLayout.CENTER);

        panelLeft.add(labelLeft);
        panelCenter.add(icon);
        panelRight.add(labelRight);
    }

    private void init() {
        this.setLayout(new BorderLayout());
        BorderLayout layout = (BorderLayout) this.getLayout();
        layout.setVgap(160);
        panelLeft = new JPanel();
        panelRight = new JPanel();
        panelCenter = new JPanel();

        labelLeft = new Number(this, "000");
        labelRight = new Number(this, "000");
        icon = new SmileButton(this);

        updateLableLeft();
        icon.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e){
                // icon.setStage(SmileButton.now);
                icon.repaint();

                int option = JOptionPane.showConfirmDialog(null, "Are you play new game?", "Notification",
						JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					getGame().getGameFrame().setVisible(false);
					new GameFrame(game.getWidth(), game.getHeight(), game.getBoom_num());
				}
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
            }
        });

    }

    public void updateLableLeft() {
        String boom_num = String.valueOf(game.getBoom_num() - game.getWorld().getFlag());
        if(boom_num.length() == 1){
            labelLeft.setS("00" + boom_num);
        } else if(boom_num.length() == 2){
            labelLeft.setS("0" + boom_num);
        } else {
            labelLeft.setS("0" + boom_num);
        }

        labelLeft.repaint();
    }

    public void updateLableRight() {
        if(nowTime > 999){
            labelRight.setS("infi");
        } else {
            String cTime = String.valueOf(nowTime);
            if (cTime.length() == 1){
                labelRight.setS("00" + cTime);
            } else if(cTime.length() == 2){
                labelRight.setS("0" + cTime);
            } else {
                labelRight.setS(cTime);
            }

            labelRight.repaint();
        }

    }

    public GamePanel getGame() {
        return game;
    }

    public void setGame(GamePanel game) {
        this.game = game;
    }

    public Timer getTime() {
        return getTime();
    }

    public void setTime(Timer time){
    }

    public Component getIcon() {
        return null;
    }

    public JPanel getPanelLeft() {
        return panelLeft;
    }

    public void setPanelLeft(JPanel panelLeft) {
        this.panelLeft = panelLeft;
    }

    public JPanel getPanelRight() {
        return panelRight;
    }

    public void setPanelRight(JPanel panelRight) {
        this.panelRight = panelRight;
    }

    public JPanel getPanelCenter() {
        return panelCenter;
    }

    public void setPanelCenter(JPanel panelCenter) {
        this.panelCenter = panelCenter;
    }

    public Number getLabelLeft() {
        return labelLeft;
    }

    public void setLabelLeft(Number labelLeft) {
        this.labelLeft = labelLeft;
    }

    public Number getLabelRight() {
        return labelRight;
    }

    public void setLabelRight(Number labelRight) {
        this.labelRight = labelRight;
    }

    public void setIcon(SmileButton icon) {
        this.icon = icon;
    }

    public int getNowTime() {
        return nowTime;
    }

    public void setNowTime(int nowTime) {
        this.nowTime = nowTime;
    }
    
}
