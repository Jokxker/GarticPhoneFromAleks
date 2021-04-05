package controller;

import model.Model;
import view.GarticPhoneView;

public class Controller {
    private Model model;
    public Controller(Model model) {
        this.model = model;
    }

    public void save(GarticPhoneView garticPhoneView) {
        model.saveView(garticPhoneView);
    }
}
