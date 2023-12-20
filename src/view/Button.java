package view;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;

public class Button extends JButton {
    private static final long serialVersionUID = 1L;
    private PlayGround p;
    private int number;

    public Button(PlayGround p) {
        number = -1;
        this.p = p;
        this.setPreferredSize(new Dimension(47,47));
    }

    @Override
    public void paint(Graphics g){
        switch (number) {
            case -1:
                g.drawImage(p.getGp().getGf().getData().getListImage().get("smile"), 0, 0, 
                    getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 0:
                g.drawImage(p.getGp().getGf().getData().getListImage().get("empty_play_ground"), 0, 0, 
                    getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 1:
                g.drawImage(p.getGp().getGf().getData().getListImage().get("one_play_ground"), 0, 0, 
                    getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 2:
                g.drawImage(p.getGp().getGf().getData().getListImage().get("two_play_ground"), 0, 0, 
                    getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 3:
                g.drawImage(p.getGp().getGf().getData().getListImage().get("three_play_ground"), 0, 0, 
                    getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 4:
                g.drawImage(p.getGp().getGf().getData().getListImage().get("four_play_ground"), 0, 0, 
                    getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 5:
                g.drawImage(p.getGp().getGf().getData().getListImage().get("five_play_ground"), 0, 0, 
                    getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 6:
                g.drawImage(p.getGp().getGf().getData().getListImage().get("six_play_ground"), 0, 0, 
                    getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 7:
                g.drawImage(p.getGp().getGf().getData().getListImage().get("seven_play_ground"), 0, 0, 
                    getPreferredSize().width, getPreferredSize().height, this);
                break;
            case 8:
                g.drawImage(p.getGp().getGf().getData().getListImage().get("eight_play_ground"), 0, 0, 
                    getPreferredSize().width, getPreferredSize().height, this);
                break;
            default:
                break;
        }
    }

    public void setNumber (int number){
        this.number  = number;
    }
}
