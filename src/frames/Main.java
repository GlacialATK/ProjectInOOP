import javax.swing.*;
import java.awt.Image;

public class Main {
    public static void main(String[] args) {

        JFrame mainFrame = new JFrame();
        mainFrame.setResizable(false);
        mainFrame.setSize(1100, 700);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);

        // Background Image
        ImageIcon backgroundImage = new ImageIcon("src/images/Mainpage_bg.jpeg");
        Image resizedImage = backgroundImage.getImage().getScaledInstance(1100, 700, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(resizedImage));
        backgroundLabel.setBounds(0, 0, 1100, 700);
        mainFrame.add(backgroundLabel);

        // title
        ImageIcon interfaceImage = new ImageIcon("src/images/ALIVE_title.png");
        Image resizedInterfaceImage = interfaceImage.getImage().getScaledInstance(360, 180, Image.SCALE_SMOOTH);
        JLabel interfaceLabel = new JLabel(new ImageIcon(resizedInterfaceImage));
        interfaceLabel.setBounds(1, 1, 360, 180);
        backgroundLabel.add(interfaceLabel);

        // background title
        ImageIcon backgroundTitleImage = new ImageIcon("src/images/ALIVE_bg.png");
        Image resizedBackgroundTitleImage = backgroundTitleImage.getImage().getScaledInstance(360, 500, Image.SCALE_SMOOTH);
        JLabel backgroundTitleLabel = new JLabel(new ImageIcon(resizedBackgroundTitleImage));
        backgroundTitleLabel.setBounds(0, 175, 370, 500);
        backgroundLabel.add(backgroundTitleLabel);

        // buttons (path, x, y, width, height, what happens on click)
        HoverButton newGameButton = new HoverButton(
                "src/images/NewGame.png", 60, 50, 250, 180,
                () -> NewCampaign.CharacterSelection());

        HoverButton loadGameButton = new HoverButton(
                "src/images/LoadGame.png", 80, 150, 210, 140,
                () -> new LoadGame());

        HoverButton settingsButton = new HoverButton(
                "src/images/Settings.png", 80, 230, 210, 140,
                () -> new Settings(mainFrame));

        HoverButton quitButton = new HoverButton(
                "src/images/Quit.png", 80, 310, 210, 140,
                () -> System.exit(0));

        backgroundTitleLabel.add(newGameButton);
        backgroundTitleLabel.add(loadGameButton);
        backgroundTitleLabel.add(settingsButton);
        backgroundTitleLabel.add(quitButton);

        BGM.play();

        HoverButton creditsButton = new HoverButton(
                        "src/images/Credits.png", 850, 540, 210, 160,
                        () -> new Credits(mainFrame));

        backgroundLabel.add(creditsButton);

        mainFrame.setVisible(true);
    }
}