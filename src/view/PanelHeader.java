/*
 * DSA PROJECT - MINESWEEPER
 * VO MINH KHANG - ITCSIU21136
 * NGUYEN TRONG NGUYEN - ITITIU21263
 * NGUYEN HOANG GIA AN - ITCSIU2161
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelHeader extends JPanel {
    private GamePanel game;
    private JPanel panelLeft, panelRight, panelCenter;
    private Number labelLeft, labelRight;
    private SmileButton icon;
    private Button[][] arrayButton;
    private String boom_num;
    private Timer time;
    private int nowTime;

    public PanelHeader(GamePanel game) {
        this.game = game;
        this.init();
        this.add(panelLeft, BorderLayout.EAST);
        this.add(panelRight, BorderLayout.WEST);
        this.add(panelCenter, BorderLayout.CENTER);

        panelLeft.add(labelLeft);
        updatelabelLeft();
        panelRight.add(labelRight);
        labelRight.setS("000");

        time = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                nowTime++;
                updatelabelRight();
            }
        });
        time.start();

        panelCenter.add(icon);
        icon.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (getGame().getWorld().isLose() || getGame().getWorld().isWin()) {
                    getGame().getGf().setVisible(false);
                    new GameFrame(game.getCols(), game.getRows(), game.getBoom_num());
                } else {
                    icon.setStage(SmileButton.press);
                    icon.repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                icon.setStage(SmileButton.now);
                icon.repaint();

                int option = JOptionPane.showConfirmDialog(null, "Are you play new game?", "Notification",
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    getGame().getGf().setVisible(false);
                    new GameFrame(game.getCols(), game.getRows(), game.getBoom_num());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
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

        arrayButton = game.getPanelPlay().getArrayButton();
    }

    public void updatelabelLeft() {
        String boom_num = String.valueOf(game.getBoom_num() - game.getWorld().getFlag());
        if (boom_num.length() == 1) {
            labelLeft.setS("00" + boom_num);
        } else if (boom_num.length() == 2) {
            labelLeft.setS("0" + boom_num);
        } else {
            labelLeft.setS("0" + boom_num);
        }
        labelLeft.repaint();

    }

    public void updatelabelRight() {
        if (nowTime > 999) {
            labelRight.setS("iii");
        } else {
            String cTime = String.valueOf(nowTime);
            if (cTime.length() == 1) {
                labelRight.setS("00" + cTime);
            } else if (cTime.length() == 2) {
                labelRight.setS("0" + cTime);
                ;
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

    public Button[][] getArrayButton() {
        return arrayButton;
    }

    public void setArrayButton(Button[][] arrayButton) {
        this.arrayButton = arrayButton;
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

    public SmileButton getIcon() {
        return icon;
    }

    public void setIcon(SmileButton icon) {
        this.icon = icon;
    }

    public String getBoom_num() {
        return boom_num;
    }

    public void setBoom_num(String boom_num) {
        this.boom_num = boom_num;
    }

    public Timer getTime() {
        return time;
    }

    public void setTime(Timer time) {
        this.time = time;
    }

    public int getNowTime() {
        return nowTime;
    }

    public void setNowTime(int nowTime) {
        this.nowTime = nowTime;
    }
}
