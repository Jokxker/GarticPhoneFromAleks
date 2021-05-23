package model;

import view.GameView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class Game {
    private static final String PATHWAY = "src/main/resources/";
    private final ArrayList<Player> players = new ArrayList<>();
    private int count;
    private int i;
    private int countPlayer;

    public String getPathway() {
        return PATHWAY;
    }

    public void setCount(int count) {
        this.count = count - 1;
    }

    public void addSerPlayer(ArrayList<Player> playersSer) {
        players.addAll(playersSer);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void saveHistoryInPlayer(Player player, String history) {
        for (Player pl : players) {
            if (pl == player) {
                pl.setHistory(history);
            }
        }
    }

    public void startGame() {
//        Player pl = players.get(i);
        System.out.println(players);
        if (i > count) {
            System.out.println("End");
            try {
                for (int i = 0; i < players.size(); i++) {
                    FileOutputStream outputStream = new FileOutputStream(PATHWAY + "player/player" + i + ".ser");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    objectOutputStream.writeObject(players.get(i));
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            new GameView().writeHistory(this, players.get(i));
            countPlayer = i + 1;
            i++;
        }
    }

    public void saveHistoryByPlayer(Player player, String history) {
        for (Player pl : players) {
            if (pl == player) {
                pl.setHistory(history);
            }
        }
        drawHistory(history);
    }

    public void drawHistory(String history) {
        if (countPlayer > count) countPlayer -= i;
        new GameView().drawHistory(this, history, players.get(countPlayer));
        countPlayer++;
    }

    public void guessHistory(String label) {
        if(countPlayer >= count) {
            countPlayer = 0;
            startGame();
        } else {
            new GameView().writeImage(this, players.get(countPlayer), label);
            countPlayer++;
        }
    }

    public void saveView(BufferedImage image, String nameFile) {
        try {
            ImageIO.write(image, "PNG", new File(PATHWAY + nameFile + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage loadView(String nameFile) {
        BufferedImage image = new BufferedImage(600, 400, 2);
        try {
            image = ImageIO.read(new File(PATHWAY + nameFile + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}