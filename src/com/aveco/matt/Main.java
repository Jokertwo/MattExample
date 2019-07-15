package com.aveco.matt;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    int clickCounter = 0;


    public Main(){

        //visible window
        JFrame frame = new JFrame("RPG Arena");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(400,800);

        //container for others component
        JPanel container = new JPanel(new FlowLayout());

        JButton buttonClick = new JButton("Click me");
        JButton buttonPrint = new JButton("Print me");
        JLabel clickCount = new JLabel("Clicks Counted: 0");
        JTextField inputText = new JTextField(20);

        //add button to container
        container.add(buttonClick);
        container.add(buttonPrint);
        container.add(clickCount);
        container.add(inputText);

        //add container to visible window
        frame.add(container);
        //set window visible
        frame.setVisible(true);


        buttonClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCounter++;
                clickCount.setText("Clicks Counted: " + clickCounter);
            }
        });

        buttonPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textField = inputText.getText();
                System.out.println(textField);
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);

    }
}
