import javax.swing.*;
import java.awt.*;

public class Credits {

    public Credits(JFrame parent) {

        // transparent dark overlay sa background ng Main JFrame
        JPanel dimBackground = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setColor(new Color(0, 0, 0, 150));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        dimBackground.setOpaque(false);

        // Apply the dark overlay to the Main JFrame
        parent.setGlassPane(dimBackground);
        dimBackground.setVisible(true);

        // Create Credits Dialog
        JDialog creditsDialog = new JDialog(parent, "Credits", true);
        creditsDialog.setSize(600, 400);
        creditsDialog.setResizable(false);
        creditsDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        creditsDialog.setLayout(null);
        creditsDialog.setLocationRelativeTo(parent);

        ImageIcon backgroundImage = new ImageIcon("src/images/Settings_bg.jpg");
        Image resizedImage = backgroundImage.getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(resizedImage));
        backgroundLabel.setBounds(0, 0, 600, 400);
        creditsDialog.add(backgroundLabel);

        // Credits title
        JLabel title = new JLabel("CREDITS", SwingConstants.CENTER);
        title.setBounds(100, 30, 350, 50);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(Color.WHITE);
        backgroundLabel.add(title);

        // Credits content
        JTextArea creditsContent = new JTextArea(
                "Game Development Team:\n" +
                "1. Moises Ryaniel Kich D. Sibayan - Developer\n" +
                "2. Curt Russel T. Gregorio - Developer\n" +
                "3. Ray Lian B. Angeles - Developer\n" +
                "\nSpecial Thanks:\n" +
                "1. Open Source Libraries\n" +
                "2. GitHub Community\n" +
                "3. Family and Friends\n" +
                "\nDISCLAIMER: This game is a work of fiction. Any resemblance to real persons, living or dead, is purely coincidental.\n" +
                "\nNo Copyright Infringement Intended. This game is for school purposes only. Music and Sound effects belongs to their rightful owners.\n"
        );
        creditsContent.setBounds(50, 100, 600, 200);
        creditsContent.setFont(new Font("Arial", Font.PLAIN, 16));
        creditsContent.setForeground(Color.WHITE);
        creditsContent.setOpaque(false);
        creditsContent.setEditable(false);
        backgroundLabel.add(creditsContent);




        // Close button - To be replaced with an icon
        JButton closeButton = new JButton("X");
        closeButton.setBounds(480, 10, 50, 40);
        closeButton.setFocusPainted(false);

        closeButton.addActionListener(e -> {
            creditsDialog.dispose();
        });

        backgroundLabel.add(closeButton);

        // Display Credits
        creditsDialog.setVisible(true);

        // Remove the dark overlay after Credits closes
        dimBackground.setVisible(false);
    }
}