import model.Game;
import model.Player;
import model.Registration;
import view.RegistrationView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

class Test {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        Game game = new Game();
        try {
            for (int i = 0; i < 10; i++) {
                FileInputStream fileInputStream = new FileInputStream(game.getPathway() + "player/player" + i + ".ser");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                players.add((Player) objectInputStream.readObject());
                objectInputStream.close();
            }
        } catch (IOException | ClassNotFoundException ignored) {
        }
        Registration registration = new Registration(game);
        new RegistrationView(registration, players).registrationCount();
    }
}