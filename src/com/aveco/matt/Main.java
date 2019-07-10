package com.aveco.matt;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;

public class Main {


    public Main(){
        //visible window
        JFrame frame = new JFrame("First window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(200,200);

        //container for others component
        JPanel container = new JPanel(new FlowLayout());

        JButton buttonClick = new JButton("Click me");

        //add button to container
        container.add(buttonClick);

        //add container to visible window
        frame.add(container);
        //set window visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
