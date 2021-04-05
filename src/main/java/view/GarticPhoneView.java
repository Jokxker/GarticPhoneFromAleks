package view;

import controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GarticPhoneView extends JFrame {
    private MyDrawPanel panel;
    private JButton button;
    private Controller controller;
    private Color color;

    public GarticPhoneView(Controller controller) {
        this.controller = controller;
    }

    public void go() {
//        frame = new JFrame("Gartic phone from Aleks");
//        setName("Gartic phone from Aleks");
        button = new JButton("Send");
        panel = new MyDrawPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        add(button, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);
        panel.addMouseMotionListener(panel);
        panel.addMouseListener(panel);
        button.addActionListener(e -> {
            controller.save(this);
        });
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        JButton buttonRed = new JButton();
        buttonRed.addActionListener(e-> {
            color = Color.red;
        });
        buttonBox.add(buttonRed);
        JButton buttonGreen = new JButton();
        buttonGreen.addActionListener(e-> {
            color = Color.green;
        });
        buttonBox.add(buttonGreen);
        add(BorderLayout.WEST, buttonBox);
        setVisible(true);
    }

    class MyDrawPanel extends JPanel implements MouseMotionListener, MouseListener {
        private ArrayList<Integer> x = new ArrayList<>();
        private ArrayList<Integer> y = new ArrayList<>();
        
        @Override
        public void mouseDragged(MouseEvent mouseEvent) {
            x.add(mouseEvent.getX());
            y.add(mouseEvent.getY());
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {
            /*x = mouseEvent.getX();
            y = mouseEvent.getY();
            repaint();*/
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            for (int i = 0; i < x.size(); i++) {
                g.fillOval(x.get(i), y.get(i), 10, 10);
            }
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            /*x.add(mouseEvent.getX());
            y.add(mouseEvent.getY());
            repaint();*/
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            x.add(mouseEvent.getX());
            y.add(mouseEvent.getY());
            repaint();
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
    }
}