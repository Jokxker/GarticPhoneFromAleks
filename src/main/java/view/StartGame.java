package view;

import model.Model;

import javax.swing.*;
import java.awt.*;

public class StartGame extends JFrame {
    private final Model model;

    public StartGame(Model model) {
        this.model = model;
    }
    public void startGame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        JPanel panel = new JPanel();
        panel.setSize(this.getWidth(), this.getHeight());
        JLabel label = new JLabel("Enter count users");
        panel.add(label);
        JTextField text = new JTextField(25);
        panel.add(text);
        JButton button = new JButton("Send");
        button.addActionListener(e -> {
            model.registrationCountGamers(text.getText());
        });
        panel.add(button);
        getContentPane().add(panel);
        setVisible(true);
    }
}