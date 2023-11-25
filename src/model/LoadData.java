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
        } catch (Exception e) {
        }
    }

    public HashMap<String, BufferedImage> getListImage() {
        return listImage;
    }

    public void setListImage(HashMap<String, BufferedImage> listImage) {
        this.listImage = listImage;
    }

}
