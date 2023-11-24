package oving12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TogAvgangSkjerm extends JFrame {

    private JPanel mainPanel;
    private JButton visAvgangerButton;

    public TogAvgangSkjerm() {
        setTitle("Togavganger");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        visAvgangerButton = new JButton("Vis Togavganger");
        visAvgangerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visTogAvganger();
            }
        });

        mainPanel.add(visAvgangerButton);
        add(mainPanel);

        setVisible(true);
    }

    private void visTogAvganger() {
        // Her kan du implementere kode for å vise togavganger, for eksempel ved å åpne et nytt vindu, vise en liste, osv.
        // Dette avhenger av hvordan du vil hente og vise togavgangsdataene.
        JOptionPane.showMessageDialog(this, "Togavganger vises her.", "Togavganger", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TogAvgangSkjerm();
            }
        });
    }
}

