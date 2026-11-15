import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image; 
import java.awt.Graphics;

public class LoadGame{


    public LoadGame() {
        JFrame loadGameFrame = new JFrame();
        loadGameFrame.setResizable(false);
            loadGameFrame.setSize(1100, 700);
            loadGameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            loadGameFrame.setLayout(null);

            // Background Image
            ImageIcon backgroundImage = new ImageIcon("src/images/Mainpage_bg.jpeg");
            Image resizedImage = backgroundImage.getImage().getScaledInstance(1100, 700, Image.SCALE_SMOOTH);
            JLabel backgroundLabel = new JLabel(new ImageIcon(resizedImage));
            backgroundLabel.setBounds(0, 0, 1100, 700);
            loadGameFrame.add(backgroundLabel);

           for (int i = 0; i < 5; i++) {
                JPanel row = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        g.setColor(new Color(0, 0, 0, 170));
                        g.fillRect(0, 0, getWidth(), getHeight());
                    }
                };
                row.setOpaque(false);
                row.setBounds(75, 50 + i * 102, 950, 86);
                backgroundLabel.add(row);
}


        loadGameFrame.setVisible(true);




}

                        


}