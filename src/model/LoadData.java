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
            listImage.put("empty", image.getSubimage(0, 38, 17, 17));
            listImage.put("flag", image.getSubimage(15, 39, 17, 17));

            listImage.put("smile", image.getSubimage(0, 55, 26, 26));

            listImage.put("empty_play_ground", image.getSubimage(0, 22, 17, 17));
            listImage.put("one_play_ground", image.getSubimage(16, 24, 17, 17));
            listImage.put("two_play_ground", image.getSubimage(0, 0, 17, 17));
            // listImage.put("three_play_ground", image.getSubimage(0, 0, 17, 17));
            // listImage.put("four_play_ground", image.getSubimage(0, 0, 17, 17));
            // listImage.put("five_play_ground", image.getSubimage(0, 0, 17, 17));
            // listImage.put("six_play_ground", image.getSubimage(0, 0, 17, 17));
            // listImage.put("seven_play_ground", image.getSubimage(0, 0, 17, 17));
            // listImage.put("eight_play_ground", image.getSubimage(0, 0, 17, 17));

            // listImage.put("zero_score", image.getSubimage(0, 0, 0, 0));
            // listImage.put("one_score", image.getSubimage(0, 0, 0, 0));
            // listImage.put("two_score", image.getSubimage(0, 0, 0, 0));
            // listImage.put("three_score", image.getSubimage(0, 0, 0, 0));
            // listImage.put("four_score", image.getSubimage(0, 0, 0, 0));
            // listImage.put("five_score", image.getSubimage(0, 0, 0, 0));
            // listImage.put("six_score", image.getSubimage(0, 0, 0, 0));
            // listImage.put("seven_score", image.getSubimage(0, 0, 0, 0));
            // listImage.put("eight_score", image.getSubimage(0, 0, 0, 0));

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
