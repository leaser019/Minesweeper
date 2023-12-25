package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class LoadData {
    private HashMap<String, BufferedImage> listImage;

    public LoadData() {
        try {
            listImage = new HashMap<>();
            BufferedImage icon = ImageIO.read(new File("img//icon.png"));
            listImage.put("icon", icon);
            BufferedImage image = ImageIO.read(new File("img//minesweeper.png"));
            listImage.put("empty", image.getSubimage(0, 39, 17, 17));
            listImage.put("flag", image.getSubimage(15, 39, 17, 17));

            listImage.put("smile", image.getSubimage(0, 55, 26, 26));
            listImage.put("smileWin", image.getSubimage(26, 55, 26, 26));
            listImage.put("smileLose", image.getSubimage(52, 55, 26, 26));
            listImage.put("smilePress", image.getSubimage(78, 55, 26, 26));
            listImage.put("smilePressPlay", image.getSubimage(104, 55, 26, 26));

            listImage.put("empty_play_ground", image.getSubimage(0, 24, 17, 17));
            listImage.put("one_play_ground", image.getSubimage(17, 24, 17, 17));
            listImage.put("two_play_ground", image.getSubimage(33, 24, 17, 17));
            listImage.put("three_play_ground", image.getSubimage(49, 24, 17, 17));
            listImage.put("four_play_ground", image.getSubimage(67, 24, 17, 17));
            listImage.put("five_play_ground", image.getSubimage(84, 24, 17, 17));
            listImage.put("six_play_ground", image.getSubimage(101, 24, 17, 17));
            listImage.put("seven_play_ground", image.getSubimage(118, 24, 17, 17));
            listImage.put("eight_play_ground", image.getSubimage(128, 24, 17, 17));

            listImage.put("flag", image.getSubimage(16, 40, 17, 17));
            listImage.put("red_boom", image.getSubimage(32, 40, 17, 17));
            listImage.put("boom_x", image.getSubimage(48, 40, 17, 17));
            listImage.put("boom", image.getSubimage(64, 40, 17, 1));

            listImage.put("0", image.getSubimage(0, 0, 13, 23));
            listImage.put("1", image.getSubimage(13, 0, 13, 23));
            listImage.put("2", image.getSubimage(26, 0, 13, 23));
            listImage.put("3", image.getSubimage(39, 0, 13, 23));
            listImage.put("4", image.getSubimage(52, 0, 13, 23));
            listImage.put("5", image.getSubimage(65, 0, 13, 23));
            listImage.put("6", image.getSubimage(78, 0, 13, 23));
            listImage.put("7", image.getSubimage(91, 0, 13, 23));
            listImage.put("8", image.getSubimage(104, 0, 13, 23));
            listImage.put("9", image.getSubimage(117, 0, 13, 23));
            listImage.put("infi", image.getSubimage(130, 0, 13, 23));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, BufferedImage> getListImage() {
        return listImage;
    }

    public void setListImage(HashMap<String, BufferedImage> listImage) {
        this.listImage = listImage;
    }

}
