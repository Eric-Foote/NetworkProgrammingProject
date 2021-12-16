import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// this is the client side for the project


class Introduction extends JPanel implements ActionListener {
    private JButton jcomp1;
    private JLabel jcomp2;
    private JLabel jcomp3;
    JFrame frame = new JFrame ("Cardgames Over Network");
    public Introduction() {
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        
        //construct components
        jcomp1 = new JButton ("START");
        jcomp2 = new JLabel ("Card Games over Network");
        jcomp3 = new JLabel ("Eric 2021");

        //adjust size and set layout
        frame.setPreferredSize (new Dimension (667, 369));
        frame.setLayout (null);

        //add components
        frame.add (jcomp1);
        frame.add (jcomp2);
        frame.add (jcomp3);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (255, 250, 100, 20);
        jcomp2.setBounds (210, 45, 191, 50);
        jcomp3.setBounds (265, 135, 100, 25);
        jcomp1.addActionListener(this);
        frame.setLocationRelativeTo(null);
        frame.setSize(new Dimension(667,369));
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        new MainMenu();
        frame.setVisible(false);
        frame.dispose();
        
    }
}

class MainMenu extends JPanel implements ActionListener {
    private JButton jcomp1;
    private JButton jcomp2;
    private JButton jcomp3;
    private JButton jcomp4;
    private JButton jcomp5;
    JFrame frame = new JFrame ("Cardgames Over Network");
    public MainMenu() {
        
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        
        //construct components
        jcomp1 = new JButton ("Single Player");
        jcomp2 = new JButton ("Multiplayer");
        jcomp3 = new JButton ("Options");
        jcomp4 = new JButton ("Credits");
        jcomp5 = new JButton ("Quit to Linux");

        //adjust size and set layout
        frame.setPreferredSize (new Dimension (611, 369));
        frame.setLayout (null);

        //add components
        frame.add (jcomp1);
        frame.add (jcomp2);
        frame.add (jcomp3);
        frame.add (jcomp4);
        frame.add (jcomp5);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (215, 25, 131, 20);
        jcomp2.setBounds (215, 60, 114, 25);
        jcomp3.setBounds (215, 110, 100, 25);
        jcomp4.setBounds (215, 165, 100, 25);
        jcomp5.setBounds (215, 225, 132, 25);
        jcomp1.addActionListener(this);
        jcomp2.addActionListener(this);
        jcomp3.addActionListener(this);
        jcomp4.addActionListener(this);
        jcomp5.addActionListener(this);
        frame.setLocationRelativeTo(null);
        frame.setSize(new Dimension(611,369));
        frame.setVisible (true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jcomp1){
            frame.setVisible(false);
            frame.dispose();
            new SinglePlayer();
        }
        if(e.getSource() == jcomp2){
            frame.setVisible(false);
            frame.dispose();
            new MultiPlayer();        
        }
         if(e.getSource() == jcomp3){
            frame.setVisible(false);
            frame.dispose();
            new Options();
        }
        if(e.getSource() == jcomp4){
            frame.setVisible(false);
            frame.dispose();
            new Credits();
        }
        if(e.getSource() == jcomp5){
            frame.setVisible(false);
            frame.dispose();
            System.exit(0);
        }
}
}

class Credits extends JPanel implements ActionListener {
    private JLabel jcomp1;
    private JButton jcomp2;
    JFrame frame = new JFrame ("Credits");
   
   public Credits(){
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        jcomp1 = new JLabel ("Eric Foote 2021 Network Programming Project");
        jcomp2 = new JButton ("Back");
        frame.setPreferredSize (new Dimension (944, 567));
        frame.setLayout (null);
        frame.add(jcomp1);
        frame.add(jcomp2);
        jcomp1.setBounds (195, 70, 500, 280);
        jcomp2.setBounds (400, 420, 100, 25);
        frame.setLocationRelativeTo(null);
        frame.setSize(new Dimension(944,567));
        jcomp2.addActionListener(this);
        frame.setVisible (true);
    }
    
    public void actionPerformed(ActionEvent e) {
        new MainMenu();
        frame.setVisible(false);
        frame.dispose();
        
    }
}
class Options extends JPanel implements ActionListener {
    public static String playerName;
    private JButton jcomp1;
    private JButton jcomp2;
    private JTextField jcomp3;
    JFrame frame = new JFrame ("MyPanel");
    
    public Options() {
        //construct components
        jcomp1 = new JButton ("Set Name");
        jcomp2 = new JButton ("Back");
        jcomp3 = new JTextField ("Player Name");

        //adjust size and set layout
        frame.setPreferredSize (new Dimension (667, 369));
        frame.setLayout (null);

        //add components
        frame.add (jcomp1);
        frame.add (jcomp2);
        frame.add (jcomp3);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (460, 120, 135, 25);
        jcomp2.setBounds (250, 290, 140, 20);
        jcomp3.setBounds (45, 115, 375, 30);
        
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(new Dimension(667,369));
        frame.setLocationRelativeTo(null);
        jcomp1.addActionListener(this);
        jcomp2.addActionListener(this);
        jcomp3.addActionListener(this);
        frame.setVisible (true);
        
    }

        public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jcomp2) {
            frame.setVisible(false);
            frame.dispose();
            new MainMenu();
        }
        if(e.getSource() == jcomp1) {
            playerName = jcomp3.getText();
        }
        }
        
}

class SinglePlayer extends JPanel {
    private JButton jcomp1;
    private JButton jcomp2;
    private JButton jcomp3;
    private JLabel jcomp4;
    private JButton jcomp5;
    private JButton jcomp6;
    private JButton jcomp7;
    JFrame frame = new JFrame ("MyPanel");
    
    public SinglePlayer() {
        //construct components
        jcomp1 = new JButton ("Blackjack");
        jcomp2 = new JButton ("Poker");
        jcomp3 = new JButton ("Back");
        jcomp4 = new JLabel ("Select Game");
        

        //adjust size and set layout
        frame.setPreferredSize (new Dimension (667, 369));
        frame.setLayout (null);

        //add components
        frame.add (jcomp1);
        frame.add (jcomp2);
        frame.add (jcomp3);
        frame.add (jcomp4);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (245, 80, 100, 25);
        jcomp2.setBounds (245, 120, 100, 25);
        jcomp3.setBounds (240, 310, 140, 20);
        jcomp4.setBounds (255, 20, 100, 25);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension (667,369));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible (true);
    }
}

class MultiPlayer extends JPanel implements ActionListener{
    private JButton jcomp1;
    private JLabel jcomp2;
    private JButton jcomp3;
    private JButton jcomp4;
    private Socket socket;
    JFrame frame = new JFrame ("MyPanel");
    public MultiPlayer() {
        try {
            socket = new Socket("127.0.0.1", 6666);
        }
         catch (IOException ex) {
           ex.printStackTrace();
        }
        GUI();
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
    
    if(e.getSource() == jcomp1) {
        try {
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        frame.setVisible(false);
        frame.dispose();
        new MainMenu();
    }
    if(e.getSource() == jcomp3){
            frame.setVisible(false);
            frame.dispose();
            new BlackjackClientSide("Multiplayer",socket);
    }
    if(e.getSource() == jcomp4) {
                frame.setVisible(false);
                frame.dispose();
                new PokerClientSide("Multiplayer",socket);
                
            }
           
        }

    public void GUI(){
     //construct components
        jcomp1 = new JButton ("Back");
        jcomp2 = new JLabel ("Select Game");
        jcomp3 = new JButton ("Blackjack");
        jcomp4 = new JButton ("Poker");
        
        //adjust size and set layout
        frame.setPreferredSize (new Dimension (667, 369));
        frame.setLayout (null);

        //add components
        frame.add (jcomp1);
        frame.add (jcomp2);
        frame.add (jcomp3);
        frame.add (jcomp4);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (235, 210, 140, 20);
        jcomp2.setBounds (250, 45, 100, 25);
        jcomp3.setBounds (250, 80, 100, 25);
        jcomp4.setBounds (250, 155, 100, 25);
        jcomp1.addActionListener(this);
        jcomp3.addActionListener(this);
        jcomp4.addActionListener(this);

        
        //set component bounds (only needed by Absolute Positioning)
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(new Dimension (667,369));
        frame.setLocationRelativeTo(null);
        frame.setVisible (true);   
        }

}


class BlackjackClientSide implements ActionListener{
        private JButton jcomp1;
        private JButton jcomp2;
        private JButton jcomp3;
        private JLabel jcomp4;
        private JLabel jcomp5;
        private JOptionPane jcomp6;
        public String playerName; 
        private Socket s;
        private BufferedReader reader;
        private BufferedWriter writer;
        private int playerNumber;
        private int opponentNumber;
        String initialString = "Player "  + playerNumber + " Cards: ";
        
        String player2Name = ""; // Get this from the network!
        JFrame frame = new JFrame ("MyPanel");
    
        public BlackjackClientSide(String gameMode, Socket socket){
        s = socket;
        if(gameMode.equals("SinglePlayer")){
            // Single Player Game Code
        playerName = JOptionPane.showInputDialog("Enter Name"); // this was a feature that if the name was not set in the options then the user could set it here but I never came back to it    
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        
        jcomp1 = new JButton ("HIT");
        jcomp2 = new JButton ("PASS");
        jcomp3 = new JButton ("QUIT");
        jcomp4 = new JLabel (playerName + "s " + "Cards: ");
        jcomp5 = new JLabel ("Dealer's Cards: ");

        //adjust size and set layout
        frame.setPreferredSize (new Dimension (773, 464));
        frame.setLayout (null);

        //add components
        frame.add (jcomp1);
        frame.add (jcomp2);
        frame.add (jcomp3);
        frame.add (jcomp4);
        frame.add (jcomp5);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (85, 360, 100, 20);
        jcomp2.setBounds (580, 365, 100, 20);
        jcomp3.setBounds (330, 425, 100, 25);
        jcomp4.setBounds (5, 10, 745, 80);
        jcomp5.setBounds (5, 85, 760, 80);
        frame.setSize(new Dimension(773,464));
        frame.setVisible (true);
            
        
       }
        
        if(gameMode.equals("Multiplayer")){
            try{
                try{
                    reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                playerNumber = reader.read();
                if(playerNumber == 1){ // sets the player numbers
                    opponentNumber = 2;
                }
                else
                    opponentNumber = 1;
                frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                frame.pack();
                
                jcomp1 = new JButton ("HIT");
                jcomp2 = new JButton ("PASS");
                jcomp3 = new JButton ("QUIT");
                jcomp4 = new JLabel(initialString);
                jcomp5 = new JLabel ("Dealer's Cards: ");
                
                
                frame.add(jcomp4);
                
                //adjust size and set layout
                frame.setPreferredSize (new Dimension (800, 600));
                frame.setLayout (null);
                
                //add components
                frame.add (jcomp1);
                frame.add (jcomp2);
                frame.add (jcomp3);
                frame.add (jcomp4);
                frame.add (jcomp5);
                
                
                //set component bounds (only needed by Absolute Positioning)
                jcomp1.setBounds (85, 360, 100, 20);
                jcomp2.setBounds (580, 365, 100, 20);
                jcomp3.setBounds (330, 425, 100, 25);
                jcomp4.setBounds (5, 10, 745, 80);
                jcomp5.setBounds (5, 85, 760, 80);
                jcomp3.addActionListener(this);
                frame.setSize(new Dimension(800,600));
                frame.setVisible(true);
                
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
            
        }
        

        
        
        try{
        int card1 = reader.read();
        int card2 = reader.read();
        int card3 = reader.read();
        
        jcomp4.setText(initialString + card2 + "" + card3);
        jcomp5.setText("Dealer's Cards: " + card1);
        
        }
       catch(Exception e){
            e.printStackTrace();
        }
       
        }
        @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == jcomp3){
            frame.setVisible(false);
            frame.dispose();
            try {
                s.close();
            } catch (IOException ex) {
               ex.printStackTrace();
            }
            new MainMenu();
        }
    }
    // ran out of time to get the 2 buttons implemented fully

}
class PokerClientSide implements ActionListener{
private JButton jcomp1;
private JButton jcomp2;
private JButton jcomp3;
private JButton jcomp4;
private JLabel jcomp5;
private JLabel jcomp6;
private JLabel jcomp7;
private JLabel jcomp8;
JFrame frame = new JFrame ("MyPanel");
private String bet;
private int Bet;
private Socket socket;
    public PokerClientSide(String gameMode, Socket s){
        socket = s;
        GUI();
}
    public void GUI() {
        //construct components
        jcomp1 = new JButton ("BET");
        jcomp2 = new JButton ("CHECK");
        jcomp3 = new JButton ("FOLD");
        jcomp4 = new JButton ("QUIT");
        jcomp5 = new JLabel (""); // This is going to be the Table
        jcomp6 = new JLabel ("Your Cards:");
        jcomp7 = new JLabel ("Your Chip Total:");
        jcomp8 = new JLabel ("Opponents Chip Total:");

        //adjust size and set layout
        frame.setPreferredSize (new Dimension (800,600));
        frame.setLayout (null);

        //add components
        frame.add (jcomp1);
        frame.add (jcomp2);
        frame.add (jcomp3);
        frame.add (jcomp4);
        frame.add (jcomp5);
        frame.add (jcomp6);
        frame.add (jcomp7);
        frame.add (jcomp8);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (290, 380, 100, 20);
        jcomp2.setBounds (90, 380, 100, 20);
        jcomp3.setBounds (455, 380, 140, 20);
        jcomp4.setBounds (290, 430, 100, 25);
        jcomp5.setBounds (155, 30, 335, 65);
        jcomp6.setBounds (65, 190, 520, 45);
        jcomp7.setBounds (60, 260, 495, 40);
        jcomp8.setBounds (60, 310, 475, 40);
        jcomp1.addActionListener(this);
        jcomp2.addActionListener(this);
        jcomp3.addActionListener(this);
        jcomp4.addActionListener(this);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(new Dimension(800,600));
        frame.setVisible (true);
    } 
        @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == jcomp1){ // BET LOGIC
           bet = JOptionPane.showInputDialog("Enter Betsize");
           Bet = Integer.parseInt(bet); //get the integer representation of the string
           if(Bet < 0 ){ // OR GREATER THEN CHIP TOTAL
               bet = JOptionPane.showInputDialog("Enter Betsize");
               Bet = Integer.parseInt(bet); //get the integer representation of the string
               //writer.write(Bet);
               //chipTotal -= Bet;
           }
        }
        if(e.getSource() == jcomp2){ // CHECK LOGIC
            //writer.write("CHECK");
        }
        if(e.getSource() == jcomp3){ // FOLD LOGIC
            //writer.write("FOLD")
        }
        if(e.getSource() == jcomp4){ // QUIT LOGIC
            frame.setVisible(false);
            frame.dispose();
          //  try {
          //      s.close();
          //  } catch (IOException ex) {
          //     ex.printStackTrace();
          //  }
            new MainMenu();
        }
}
}
class Card { // This was my card class, I was going to enhance this further once I got the client server connections working properly in order to allow for the creation of the whole deck of 52 cards rather then each time the card needing to be created again.
    private String Suit;
    private String Value;
        public Card(String suit, String value){
            suit = this.Suit;
            value = this.Value;
        }
        public String getSuit(){
            return Suit;
        }
        public String getValue(){
            return Value;
        }
        public int valueOfCard(){
            if(Value.equals("2"))
                return 2;
            if(Value.equals("3"))
                return 3;
            if(Value.equals("4"))
                return 4;
            if(Value.equals("5"))
                return 5;
            if(Value.equals("6"))
                return 6;
            if(Value.equals("7"))
                return 7;
            if(Value.equals("8"))
                return 8;
            if(Value.equals("9"))
                return 9;
            if(Value.equals("Jack"))
                return 10;
            if(Value.equals("Queen"))
                return 12;
            if(Value.equals("King"))
                return 13;
            else
                return 1;
        }
    @Override
        public String toString(){
            return Value + " of " + Suit;
        }
}
public class CardgamesOverNetwork{

    public static void main (String[] args){
       new Introduction();
    }
    
}


