package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.*;

public class UI {

    private static JFrame frame;
    private static JPanel panel;
    private JLabel label;
    private JButton button;

    public static void initialize() {
        frame = new JFrame();
        frame.setBackground(Color.black);
        frame.setLayout(new BorderLayout(10, 5));
        frame.setTitle("Java Airlines Booking System");
        frame.setSize(800,500);
        frame.setBackground(Color.black);
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel2.setBackground(black);
        frame.add(panel2, BorderLayout.NORTH);


        JLabel label = new JLabel("Java Airlines");
        panel2.add(label);
        label.setForeground(white);
        label.setFont(new Font("Broadway", Font.PLAIN, 36));

        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panel.setBackground(darkGray);
        JTextField textField = new JTextField(12);
        textField.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(textField);

        Button button = new Button("test");
        panel.add(button);
        Button button2 = new Button("test2");
        panel.add(button2);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static JPanel buttons() {


        return panel;
    }

    public static JTextField createJTextField() {
        JTextField textField = new JTextField(12);
        textField.setFont(new Font("Arial", Font.BOLD, 18));

        return textField;
    }
}
