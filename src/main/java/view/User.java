package view;

import model.Model;

import javax.swing.*;
import java.awt.*;

public class User {
    private final Model model;
    private final JFrame frame = new JFrame();
    private final JPanel panel = new JPanel();
    private String name;
    private int age;
    private int point;

    public String toString() {
        return "name: " + name + "age: " + age;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point += point;
    }

    public User(Model model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void start() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        panel.setSize(frame.getWidth(), frame.getHeight());
        JLabel label = new JLabel("Enter your name and age");
        panel.add(label);
        JTextField text = new JTextField(25);
        panel.add(text);
        JButton button = new JButton("Send");
        button.addActionListener(e -> {
            model.registrationGamers(text.getText());
            this.whatDrawing();
        });
        panel.add(button, BorderLayout.SOUTH);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public void whatDrawing() {
        panel.removeAll();
        panel.repaint();
        JLabel label = new JLabel("Enter what draw?");
        panel.add(label);
        JTextField text = new JTextField(25);
        panel.add(text);
        JButton button = new JButton("Send");
        button.addActionListener(e -> {
            model.saveHistory(text.getText(), this);
        });
        panel.add(button, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public void draw() {

    }
}