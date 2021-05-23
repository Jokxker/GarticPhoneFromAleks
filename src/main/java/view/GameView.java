package view;

import model.Game;
import model.Player;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static java.awt.BorderLayout.PAGE_END;

public class GameView {
    private JLabel label;
    private Game game;
    private Player player;
    private static final int[] disposition = {-600, 0};
    private Color color;
    private BufferedImage image;
    private final ArrayList<Integer> x = new ArrayList<>();
    private final ArrayList<Integer> y = new ArrayList<>();
    private Font BigFontTR = new Font("TimesRoman", Font.BOLD, 30);

    public void writeHistory(Game game, Player player) {
        this.game = game;
        this.player = player;
        JFrame frame = new JFrame("Gartic phone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        JLabel labelEnter = new JLabel(player.getName() + " " + "enter what draw?");
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.add(labelEnter);
        JTextField history = new JTextField(25);
        panel.add(history);
        JButton button = new JButton("Send");
        panel.add(button);
        button.addActionListener(e -> {
            game.saveHistoryByPlayer(player, history.getText());
            frame.setVisible(false);
        });
        frame.setVisible(true);
    }

    public void drawHistory(Game game, String history, Player howPlayer) {
        this.game = game;
        JFrame frame = new JFrame("Gartic phone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_ARGB);
        GameView.MyDrawPanel panelDraw = new GameView.MyDrawPanel();
        frame.getContentPane().add(panelDraw);
        frame.addKeyListener(panelDraw);
        JButton buttonSend = new JButton("Send");
        frame.getContentPane().add(buttonSend, PAGE_END);
        label = new JLabel(howPlayer.getName() + ":" + "Drawing:" + history, SwingConstants.CENTER);
        label.setFont(BigFontTR);
        label.setForeground(Color.BLUE);
        panelDraw.add(label);
        panelDraw.addMouseMotionListener(panelDraw);
        panelDraw.addMouseListener(panelDraw);
        buttonSend.addActionListener(e -> {
            game.saveView(image, label.getText());
            game.saveHistoryInPlayer(player, game.getPathway() + label.getText() + ".png");
            game.guessHistory(label.getText());
            frame.setVisible(false);
        });
        BigFontTR = new Font("TimesRoman", Font.BOLD, 60);
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        JButton buttonRed = new JButton("C");
        buttonRed.setFont(BigFontTR);
        buttonRed.setForeground(Color.RED);
        buttonRed.setBackground(Color.RED);
        buttonRed.addActionListener(e -> {
            color = Color.RED;
            game.saveView(image, label.getText());
            x.clear();
            y.clear();
        });
        buttonBox.add(buttonRed);
        JButton buttonGreen = new JButton("C");
        buttonGreen.setFont(BigFontTR);
        buttonGreen.setForeground(Color.GREEN);
        buttonGreen.setBackground(Color.GREEN);
        buttonGreen.addActionListener(e -> {
            color = Color.GREEN;
            game.saveView(image, label.getText());
            x.clear();
            y.clear();
        });
        buttonBox.add(buttonGreen);
        JButton buttonBlue = new JButton("C");
        buttonBlue.setFont(BigFontTR);
        buttonBlue.setForeground(Color.BLUE);
        buttonBlue.setBackground(Color.BLUE);
        buttonBlue.addActionListener(e -> {
            color = Color.BLUE;
            game.saveView(image, label.getText());
            x.clear();
            y.clear();
        });
        buttonBox.add(buttonBlue);
        JButton buttonBlack = new JButton("C");
        buttonBlack.setFont(BigFontTR);
        buttonBlack.setForeground(Color.BLACK);
        buttonBlack.setBackground(Color.BLACK);
        buttonBlack.addActionListener(e -> {
            color = Color.BLACK;
            game.saveView(image, label.getText());
            x.clear();
            y.clear();
        });
        buttonBox.add(buttonBlack);
        JButton buttonYellow = new JButton("C");
        buttonYellow.setFont(BigFontTR);
        buttonYellow.setForeground(Color.YELLOW);
        buttonYellow.setBackground(Color.YELLOW);
        buttonYellow.addActionListener(e -> {
            color = Color.YELLOW;
            game.saveView(image, label.getText());
            x.clear();
            y.clear();
        });
        buttonBox.add(buttonYellow);
        JButton buttonCyan = new JButton("C");
        buttonCyan.setFont(BigFontTR);
        buttonCyan.setForeground(Color.CYAN);
        buttonCyan.setBackground(Color.CYAN);
        buttonCyan.addActionListener(e -> {
            color = Color.CYAN;
            game.saveView(image, label.getText());
            x.clear();
            y.clear();
        });
        buttonBox.add(buttonCyan);
        frame.getContentPane().add(BorderLayout.WEST, buttonBox);
        frame.setVisible(true);
    }

    public void writeImage(Game game, Player player, String nameFile) {
        label = new JLabel(nameFile);
        this.game = game;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_ARGB);
        JLabel labelDraw = new JLabel("What do you see?");
        PanelDrawIt panelDrawIt = new PanelDrawIt();
        BigFontTR = new Font("TimesRoman", Font.BOLD, 60);
        labelDraw.setFont(BigFontTR);
        labelDraw.setForeground(Color.BLACK);
        panelDrawIt.add(labelDraw);
        JLabel labelEnter = new JLabel(player.getName() + " " + "enter what do you see?");
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.add(labelEnter);
        JTextField history = new JTextField(25);
        panel.add(history);
        JButton button = new JButton("Send");
        panel.add(button);
        button.addActionListener(e -> {
            game.saveHistoryInPlayer(player, history.getText());
            frame.setVisible(false);
        });
        frame.getContentPane().add(panelDrawIt, BorderLayout.WEST);
        frame.setVisible(true);
    }

    class MyDrawPanel extends JPanel implements MouseMotionListener, MouseListener, ActionListener, KeyListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
        }

        public void updatePaint() {
            image = game.loadView(label.getText());
            Graphics g = image.createGraphics();
            g.setColor(color);
            for (int i = 0; i < x.size(); i++) {
                g.fillOval(x.get(i), y.get(i), 10, 10);
            }
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent mouseEvent) {
            x.add(mouseEvent.getX());
            y.add(mouseEvent.getY());
            updatePaint();
        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            x.add(mouseEvent.getX());
            y.add(mouseEvent.getY());
            updatePaint();
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {
        }

        @Override
        public void keyTyped(KeyEvent keyEvent) {
            System.out.println("yes");
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            System.out.println("yes");
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            System.out.println("yes");
        }
    }

    private class PanelDrawIt extends JPanel{

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(game.loadView(label.getText()), 0, 120 , 600, 400, this);
        }
    }
}