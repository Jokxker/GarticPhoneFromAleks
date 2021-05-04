package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GarticPhoneView {
    private final Controller controller;
    private Color color;
    private final JFrame frame = new JFrame("Gartic phone from Aleks");
    private BufferedImage image = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
    private final ArrayList<Integer> x = new ArrayList<>();
    private final ArrayList<Integer> y = new ArrayList<>();
    private final Font BigFontTR = new Font("TimesRoman", Font.BOLD, 30);
    private int flag = 0;

    public GarticPhoneView(Controller controller) {
        this.controller = controller;
    }

    public void start() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        JButton buttonSend = new JButton("Send version");
        frame.getContentPane().add(buttonSend, BorderLayout.SOUTH);
        JLabel label;
        if (flag == 0) {
            label = new JLabel("Enter your drawing task: ", SwingConstants.CENTER);
        } else {
            label = new JLabel("Enter : ", SwingConstants.CENTER);
            JLabel labelDraw = new JLabel("What do you see?");
            labelDraw.setFont(BigFontTR);
            labelDraw.setForeground(Color.BLUE);
            PanelDrawIt panelDrawIt = new PanelDrawIt();
            panelDrawIt.add(labelDraw);
            frame.getContentPane().add(panelDrawIt, BorderLayout.WEST);
        }
        label.setFont(BigFontTR);
        label.setForeground(Color.BLUE);
        JTextField text = new JTextField();
        text.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        text.setFont(new Font("Dialog", Font.PLAIN, 20));
        frame.getContentPane().add(label, BorderLayout.NORTH);
        frame.getContentPane().add(text);
        buttonSend.addActionListener(e-> {
            y.clear();
            x.clear();
            frame.getContentPane().removeAll();
            frame.repaint();
            controller.go(text.getText());
        });
        frame.setVisible(true);
    }

    public void go() {
        flag++;
        JButton buttonSend = new JButton("Send");
        MyDrawPanel panel = new MyDrawPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().add(buttonSend, BorderLayout.SOUTH);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        JLabel label = new JLabel("Draw it: " + controller.getWhatDrawing(), SwingConstants.CENTER);
        label.setFont(BigFontTR);
        label.setForeground(Color.BLUE);
        panel.add(BorderLayout.NORTH, label);
        panel.addMouseMotionListener(panel);
        panel.addMouseListener(panel);
        buttonSend.addActionListener(e-> {
            controller.saveView(image);
            frame.getContentPane().removeAll();
            frame.repaint();
            y.clear();
            x.clear();
            this.start();
        });
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 60);
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        JButton buttonRed = new JButton("C");
        buttonRed.setFont(BigFontTR);
        buttonRed.setForeground(Color.RED);
        buttonRed.setBackground(Color.RED);
        buttonRed.addActionListener(e-> {
            color = Color.RED;
            controller.saveView(image);
            x.clear();
            y.clear();
        });
        buttonBox.add(buttonRed);
        JButton buttonGreen = new JButton("C");
        buttonGreen.setFont(BigFontTR);
        buttonGreen.setForeground(Color.GREEN);
        buttonGreen.setBackground(Color.GREEN);
        buttonGreen.addActionListener(e-> {
            color = Color.GREEN;
            controller.saveView(image);
            x.clear();
            y.clear();
        });
        buttonBox.add(buttonGreen);
        JButton buttonBlue = new JButton("C");
        buttonBlue.setFont(BigFontTR);
        buttonBlue.setForeground(Color.BLUE);
        buttonBlue.setBackground(Color.BLUE);
        buttonBlue.addActionListener(e-> {
            color = Color.BLUE;
            controller.saveView(image);
            x.clear();
            y.clear();
        });
        buttonBox.add(buttonBlue);
        JButton buttonBlack = new JButton("C");
        buttonBlack.setFont(BigFontTR);
        buttonBlack.setForeground(Color.BLACK);
        buttonBlack.setBackground(Color.BLACK);
        buttonBlack.addActionListener(e-> {
            color = Color.BLACK;
            controller.saveView(image);
            x.clear();
            y.clear();
        });
        buttonBox.add(buttonBlack);
        JButton buttonYellow = new JButton("C");
        buttonYellow.setFont(BigFontTR);
        buttonYellow.setForeground(Color.YELLOW);
        buttonYellow.setBackground(Color.YELLOW);
        buttonYellow.addActionListener(e-> {
            color = Color.YELLOW;
            controller.saveView(image);
            x.clear();
            y.clear();
        });
        buttonBox.add(buttonYellow);
        JButton buttonCyan = new JButton("C");
        buttonCyan.setFont(BigFontTR);
        buttonCyan.setForeground(Color.CYAN);
        buttonCyan.setBackground(Color.CYAN);
        buttonCyan.addActionListener(e-> {
            color = Color.CYAN;
            controller.saveView(image);
            x.clear();
            y.clear();
        });
        buttonBox.add(buttonCyan);
        frame.getContentPane().add(BorderLayout.WEST, buttonBox);
        frame.setVisible(true);
    }

    class MyDrawPanel extends JPanel implements MouseMotionListener, MouseListener, ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }

        public void updatePaint() {
            image = controller.load();
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
    }

    private class PanelDrawIt extends JPanel{

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(controller.load(), 0, 120 , 300, 300, this);
        }
    }
}