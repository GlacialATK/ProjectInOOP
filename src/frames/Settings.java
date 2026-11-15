import javax.swing.*;
import java.awt.*;

public class Settings {

    public Settings(JFrame parent) {

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

        // Create Settings Dialog
        JDialog settingsDialog = new JDialog(parent, "Settings", true);
        settingsDialog.setSize(550, 350);
        settingsDialog.setResizable(false);
        settingsDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        settingsDialog.setLayout(null);
        settingsDialog.setLocationRelativeTo(parent);

        // Settings background
        //settingsDialog.getContentPane().setBackground(
        //    new ImageIcon("src/images/Settings_bg.jpeg")
        //);

        ImageIcon backgroundImage = new ImageIcon("src/images/Settings_bg.jpg");
        Image resizedImage = backgroundImage.getImage().getScaledInstance(550, 325, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(resizedImage));
        backgroundLabel.setBounds(0, 0, 550, 325);
        settingsDialog.add(backgroundLabel);

        // Settings title
        JLabel title = new JLabel("SETTINGS", SwingConstants.CENTER);
        title.setBounds(100, 30, 350, 50);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(Color.WHITE);
        backgroundLabel.add(title);

        // Volume label
        JLabel volumeTitle = new JLabel("Background Music");
        volumeTitle.setBounds(60, 90, 350, 30);
        volumeTitle.setFont(new Font("Arial", Font.BOLD, 18));
        volumeTitle.setForeground(Color.WHITE);
        backgroundLabel.add(volumeTitle);

        // Volume percentage
        JLabel volumeLabel = new JLabel(BGM.getVolume() + "%");
        volumeLabel.setBounds(470, 90, 60, 30);
        volumeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        volumeLabel.setForeground(Color.WHITE);
        backgroundLabel.add(volumeLabel);

        // Volume slider
        JSlider volumeSlider = new JSlider(0, 100, BGM.getVolume());
        volumeSlider.setBounds(250, 80, 200, 50);
        volumeSlider.setOpaque(false);
        volumeSlider.setForeground(Color.WHITE);
        volumeSlider.setMajorTickSpacing(25);
        volumeSlider.setMinorTickSpacing(5);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);
        backgroundLabel.add(volumeSlider);
        volumeSlider.addChangeListener(e -> { // Change volume while dragging the slider

            int currentVolume = volumeSlider.getValue();

            BGM.setVolume(currentVolume);

            volumeLabel.setText(currentVolume + "%");

        });


        // Close button - To be replaced with an icon
        JButton closeButton = new JButton("X");
        closeButton.setBounds(480, 10, 50, 40);
        closeButton.setFocusPainted(false);

        closeButton.addActionListener(e -> {
            settingsDialog.dispose();
        });

        backgroundLabel.add(closeButton);

        // Display Settings
        settingsDialog.setVisible(true);

        // Remove the dark overlay after Settings closes
        dimBackground.setVisible(false);
    }
}