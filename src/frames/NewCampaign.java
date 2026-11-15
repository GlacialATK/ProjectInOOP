import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;




public class NewCampaign {

static class Character {
         String name;
         String role;
         int health;
         int attack;
         int defense;
         String imagePath;
         String ButtonimagePath;
//method para sa character
         public Character(String name, String role, int health, int attack, int defense, String imagePath, String ButtonimagePath) {
         this.name = name;
         this.role = role;
         this.health = health;
         this.attack = attack;
         this.defense = defense;
         this.imagePath = imagePath;
         this.ButtonimagePath = ButtonimagePath;
         }
        }
         
        public static void CharacterSelection(){
                JFrame CharSelect = new JFrame();
                CharSelect.setResizable(false);
                CharSelect.setSize(1100, 700);
                CharSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                CharSelect.setLayout(null);

                ImageIcon backgroundImage = new ImageIcon("src/images/Mainpage_bg.jpeg");
                Image resizedImage = backgroundImage.getImage().getScaledInstance(1100, 700, Image.SCALE_SMOOTH);
                ImageIcon resizedBackground = new ImageIcon(resizedImage);
                JLabel backgroundLabel = new JLabel(resizedBackground);
                backgroundLabel.setBounds(0, 0, 1100, 700);
                CharSelect.add(backgroundLabel);

                ImageIcon Charbutton = new ImageIcon("src/images/Choose_your_role.png");
                Image resizeNewCharImage = Charbutton.getImage().getScaledInstance(250, 100, Image.SCALE_SMOOTH);
                ImageIcon ResizedChar = new ImageIcon(resizeNewCharImage);
                JLabel NewChar = new JLabel(ResizedChar);
                NewChar.setBounds(425, 100, 250, 100);
                backgroundLabel.add(NewChar);
                    //array para sa char and their images
                Character[] characters={
                        new Character("heavy","brute" ,100, 20, 10, "src/images/Heavy.png", "src/images/Heavy_role.png"),
                        new Character("doctor","healer", 80, 30, 5, "src/images/doctor.png", "src/images/doctor_role.png"),
                        new Character("soldier","tactical", 90, 25, 8, "src/images/soldier.jpg", "src/images/soldier_role.png"),
                };
                  //starting place nila and then calculation for spacing nila
                int startX = 175;
                int startY = 275;
                int spacing = 275;
                for (int i = 0; i < characters.length; i++) {
            Character c = characters[i];
            int xPos = startX + (i * spacing);

            //ang kanilang image icon boooooooooooooooooooooooooooooo
                 ImageIcon charImageIcon = new ImageIcon(c.imagePath);
                 Image resizedCharImage = charImageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                 ImageIcon resizedCharIcon = new ImageIcon(resizedCharImage);
                 JLabel charLabel = new JLabel(resizedCharIcon);
                 charLabel.setBorder(new LineBorder(new Color(60, 60, 60), 1));
                 charLabel.setBounds(xPos, startY, 200, 200);
                 backgroundLabel.add(charLabel);

                 //button icon role nila
                 ImageIcon charButtonIcon = new ImageIcon(c.ButtonimagePath);
                 Image resizedCharButtonImage = charButtonIcon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
                 ImageIcon resizedCharButtonIcon = new ImageIcon(resizedCharButtonImage);
                 JLabel charButtonLabel = new JLabel(resizedCharButtonIcon);
                 charButtonLabel.setBounds(xPos, startY + 210, 200, 100);
                 backgroundLabel.add(charButtonLabel);


                 // para sa mouse effects
                 charLabel.addMouseListener( new MouseAdapter() {
                @Override 
                public void  mouseEntered(MouseEvent e){
                        charLabel.setBorder(new LineBorder(new Color(255, 255, 255), 3));
                }
                public void mouseExited(MouseEvent e) {
                        charLabel.setBorder(new LineBorder(new Color(60, 60, 60), 1));              
                }
                //for username and double click to confirm
                public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) {
                        //for username input ng mga users
                String playerName = null;
                while (true) {
                playerName = JOptionPane.showInputDialog(
                CharSelect,
                "You selected " + c.name.toUpperCase() + "(" + c.role.toUpperCase() + "). \nEnter your username:", 
                "Character Confirmation",
                JOptionPane.QUESTION_MESSAGE); 
                // if wala silang nilagay
                if(playerName == null){
                return;
                }
                playerName = playerName.trim();
                //pag walang laman
                if(playerName.isEmpty()){
                JOptionPane.showMessageDialog(
                CharSelect, 
                "Username cannot be empty. Please enter a valid username.", 
                "Invalid Username", 
                JOptionPane.ERROR_MESSAGE
                );
                continue;
                }
                //if sobrasobra na sila jan sa trip nila
                if(playerName.length() > 20){
                JOptionPane.showMessageDialog(
                CharSelect, 
                "Username cannot exceed 20 characters.", 
                "Invalid Username", 
                JOptionPane.ERROR_MESSAGE
                );
                continue;
                }
                break;
                } 
                //if accepted na ang username nila
                if (playerName != null && !playerName.trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                CharSelect, 
                playerName.trim() + "!\nStarting campaign as " + c.name.toUpperCase() + ".", 
                "Campaign Started", 
                JOptionPane.INFORMATION_MESSAGE

                            );   
                            CharSelect.dispose();
                        }

                        }
                                            
                }

        });
                     
                 CharSelect.setVisible(true);
}
        }
    
}