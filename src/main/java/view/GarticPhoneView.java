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

    public GarticPhoneView(Controller controller) {
        this.controller = controller;
    }

    public void start() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        JButton button = new JButton("Send version");
        frame.getContentPane().add(button, BorderLayout.SOUTH);
        JLabel label = new JLabel("Что нарисовать?", SwingConstants.CENTER);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 30);
        label.setFont(BigFontTR);
        label.setForeground(Color.BLUE);
        JTextField text = new JTextField();
        text.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        text.setFont(new Font("Dialog", Font.PLAIN, 20));
        frame.getContentPane().add(label, BorderLayout.NORTH);
        frame.getContentPane().add(text);
        button.addActionListener(e-> controller.go(text.getText()));
        frame.setVisible(true);
    }

    public void go() {
        JButton button = new JButton("Send");
        MyDrawPanel panel = new MyDrawPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().add(button, BorderLayout.SOUTH);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.addMouseMotionListener(panel);
        panel.addMouseListener(panel);
        button.addActionListener(e-> {
            controller.save(image);
            x.clear();
            y.clear();
        });
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 60);
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        JButton buttonRed = new JButton("C");
        buttonRed.setFont(BigFontTR);
        buttonRed.setForeground(Color.RED);
        buttonRed.setBackground(Color.RED);
        buttonRed.addActionListener(e-> {
            color = Color.RED;
            controller.save(image);
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
            controller.save(image);
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
            controller.save(image);
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
            controller.save(image);
            x.clear();
            y.clear();
        });
        buttonBox.add(buttonBlack);
        JButton buttonGray = new JButton("C");
        buttonGray.setFont(BigFontTR);
        buttonGray.setForeground(Color.GRAY);
        buttonGray.setBackground(Color.GRAY);
        buttonGray.addActionListener(e-> {
            color = Color.GRAY;
            controller.save(image);
            x.clear();
            y.clear();
        });
        buttonBox.add(buttonGray);
        JButton buttonCyan = new JButton("C");
        buttonCyan.setFont(BigFontTR);
        buttonCyan.setForeground(Color.CYAN);
        buttonCyan.setBackground(Color.CYAN);
        buttonCyan.addActionListener(e-> {
            color = Color.CYAN;
            controller.save(image);
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
}