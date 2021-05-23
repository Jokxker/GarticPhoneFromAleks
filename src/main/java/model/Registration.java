package model;

import java.util.ArrayList;

public class Registration {
    private final ArrayList<Player> players = new ArrayList<>();
    private final Game game;
    private int count;

    public Registration(Game game) {
        this.game = game;
    }

    public void setPlayers(int count) {
        this.count = count;
        for (int i = 0; i < count; i++) {
            players.add(new Player());
        }
    }

    public void setNamePass(String name, char[] pass, ArrayList<Player> playersSer) {
        players.get(0).setName(name);
        players.get(0).setPassword(pass);
        game.addPlayer(players.get(0));
        players.remove(0);
        if (players.isEmpty()) {
            game.setCount(count);
            game.addSerPlayer(playersSer);
            game.startGame();
        }
    }
}