package model;

import view.User;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
    private static final String PATHDRAW = "src/main/resources/";
    private String whatDrawing = "";
    private final Map<User, List<String>> users = new HashMap<>();

    public void registrationCountGamers(String countGamers) {
        int count = Integer.parseInt(countGamers);
        for (int i = 0; i < count; i++) {
            users.put(new User(this),new ArrayList<>());
        }
        for (Map.Entry<User, List<String>> entry : users.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        /*for (Map.Entry<User, List<String>> entry : users.entrySet()) {
            entry.getKey().start();
        }*/
        for (User us : users.keySet()) {
            us.start();
        }
    }

    public void registrationGamers(String nameAge) {
        String[] s = nameAge.split(" ");
        for (User us : users.keySet()) {
            if (us.getName() == null) {
                us.setName(s[0]);
                us.setAge(Integer.parseInt(s[1]));
                break;
            }
        }
        for (Map.Entry<User, List<String>> entry : users.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    public void saveHistory(String history, User user) {
        for (Map.Entry<User, List<String>> entry : users.entrySet()) {
            if (entry.getKey() == user) {
                entry.getValue().add(history);
            }
        }
        for (Map.Entry<User, List<String>> entry : users.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    public String getWhatDrawing() {
        return whatDrawing;
    }

    public void saveText(String str) {
        whatDrawing = str;
    }

    public void saveView(BufferedImage image) {
        try {
            ImageIO.write(image, "PNG", new File(PATHDRAW + whatDrawing + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage loadView() {
        BufferedImage image = new BufferedImage(800, 800, 2);
        try {
            image = ImageIO.read(new File(PATHDRAW + whatDrawing + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}