package model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Model {
    private String whatDrawing = "";

    public String getWhatDrawing() {
        return whatDrawing;
    }

    public void saveText(String str) {
        whatDrawing = str;
    }

    public void saveView(BufferedImage image) {
        try {
            ImageIO.write(image, "PNG", new File(whatDrawing + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage loadView() {
        BufferedImage image = new BufferedImage(800, 800, 2);
        try {
            image = ImageIO.read(new File(whatDrawing + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}