package view;

import model.Game;
import model.Player;
import model.Registration;

import javax.swing.*;
import java.util.ArrayList;

public class RegistrationView {
    private final Registration registration;
    private final ArrayList<Player> players;
    private static final int[] disposition = {-400, 0};

    public RegistrationView(Registration registration, ArrayList<Player> players) {
        this.registration = registration;
        this.players = players;
    }

    public void registrationCount() {
        JFrame frame = new JFrame("Gartic phone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        JPanel panel = new JPanel();
        panel.setSize(frame.getWidth(), frame.getHeight());
        JLabel label = new JLabel("Enter count users");
        panel.add(label);
        JTextField text = new JTextField(25);
        panel.add(text);
        JButton button = new JButton("Send");
        button.addActionListener(e -> {
            registration.setPlayers(Integer.parseInt(text.getText()));
            frame.setVisible(false);
            for (int i = 0; i < Integer.parseInt(text.getText()); i++) {
                registrationNamePass();
            }
        });
        panel.add(button);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public void registrationNamePass() {
        if (disposition[0] > 1000) {
            disposition[0] = 0;
            disposition[1] += 400;
        }else {
            disposition[0] += 400;
        }
        JFrame frame = new JFrame("Gartic phone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(disposition[0], disposition[1], 400, 400);
        JPanel panel = new JPanel();
        panel.setSize(frame.getWidth(), frame.getHeight());
        JLabel label = new JLabel("Enter your name:");
        panel.add(label);
        JTextField name = new JTextField(25);
        panel.add(name);
        label = new JLabel("Enter your password:");
        panel.add(label);
        JPasswordField pass = new JPasswordField(25);
        panel.add(pass);
        JButton button = new JButton("Send");
        panel.add(button);
        button.addActionListener(e -> {
            registration.setNamePass(name.getText(), pass.getPassword(), players);
            frame.setVisible(false);
        });
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}