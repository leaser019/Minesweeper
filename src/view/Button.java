package view;

import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.image.BufferedImage;
import javax.swing.JButton;

import model.LoadData;

public class Button extends JButton {
    private GamePanel panel;
    private int number;
    private int row;
    private int column;
    private LoadData data;

    public Button(int row, int column, GamePanel panel) {
        number = -1;
        this.row = row;
        this.column = column;
        this.panel = panel;
        this.setPreferredSize(new Dimension(47,47));
        this.data = new LoadData();
    }

    @Override
    public void paintComponent(Graphics g) {
        BufferedImage image = getImageForNumber(number);
        g.drawImage(image, 0, 0, this.getPreferredSize().width, this.getPreferredSize().height, null);
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

    public GamePanel gamePanel(){
        return panel;
    }

    private BufferedImage getImageForNumber(int number){
        String key;
        switch (number) {
            case -1:
                key = "empty";
                break;
            case 0:
                key = "empty_play_ground";
                break;
            case 1:
                key = "one_play_ground";
                break;
            case 2:
                key = "two_play_ground";
                break;
            case 3:
                key = "three_play_ground";
                break;
            case 4:
                key = "four_play_ground";
                break;
            case 5:
                key = "five_play_ground";
                break;
            case 6:
                key = "six_play_ground";
                break;
            case 7:
                key = "seven_play_ground";
                break;
            case 8:
                key = "eight_play_ground";
                break;
            default:
                key = "empty";
                break;
            }
        return data.getListImage().get(key);
    }
}
