package model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Model {
    public void saveText(String str) {
        System.out.println(str);
    }

    public void saveView(BufferedImage image) {
        try {
            ImageIO.write(image, "PNG", new File("name.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage load() {
        BufferedImage image = new BufferedImage(800, 800, 2);
        try {
            image = ImageIO.read(new File("name.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}