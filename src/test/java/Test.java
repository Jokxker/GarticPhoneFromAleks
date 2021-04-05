import controller.Controller;
import model.Model;
import view.GarticPhoneView;

import javax.swing.*;

class Test {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        GarticPhoneView view = new GarticPhoneView(controller);
        SwingUtilities.invokeLater(view::go);
    }
}