import model.Model;
import view.GarticPhoneView;
import view.StartGame;

import javax.swing.*;

class Test {
    public static void main(String[] args) {
        Model model = new Model();
        StartGame startGame = new StartGame(model);
        GarticPhoneView view = new GarticPhoneView(model);
        SwingUtilities.invokeLater(startGame :: startGame);
    }
}