package controller;

import model.Model;
import view.GarticPhoneView;

import java.awt.image.BufferedImage;

public class Controller {
    private final Model model;
    private final GarticPhoneView garticPhoneView = new GarticPhoneView(this);

    public String getWhatDrawing() {
        return model.getWhatDrawing();
    }

    public Controller(Model model) {
        this.model = model;
    }

    public void go(String str) {
        model.saveText(str);
        garticPhoneView.go();
    }

    public void saveView(BufferedImage image) {
        model.saveView(image);
    }

    public BufferedImage load() {
        return model.loadView();
    }
}
