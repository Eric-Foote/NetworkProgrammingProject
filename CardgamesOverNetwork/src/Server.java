import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private ServerSocket s;
    private int numPlayers;
    private ServerRunnable player1;
    private ServerRunnable player2;
    String gameChoice = "Blackjack"; // This was going to be able to be set for different games, I had it set to blackjack for debugging the connection
    int [] deckOfCards = {0,1,2,3,4,5}; // this was just temporary
    int playerTotal;
    int DealerTotal;
    
    Random r = new Random();
    int numberOfCardsDrawn = 0;
    
    class Card {
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
    }
    
    public Server(){
        System.out.println("Starting Server");
        numPlayers = 0;
        try{
            s = new ServerSocket(6666);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void playerConnections(){
        try{
            System.out.println("Waiting for player connections");
            while(numPlayers < 2 ){
                Socket socket = s.accept();
                numPlayers++;
                ServerRunnable srun = new ServerRunnable(socket,numPlayers);
                if (numPlayers == 1){
                    player1 = srun;
                }
                else
                    player2 = srun;
                Thread t = new Thread(srun);
                t.start();
                System.out.println("Player " + numPlayers + " Connected");   
            }
            System.out.println("Lobby is full. No longer accepting players");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
   
        
    private class ServerRunnable implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private BufferedWriter writer;
        private int playerNumber;
        
        int turnNumber = 0;
        int Total = 0;
        
        
        public boolean winningConditions(){
            if(playerTotal >= 21 | DealerTotal >= 21){ // Implements the winning conditions for an individual player 
                try {
                    if(playerTotal >= 21)
                        writer.write(playerNumber + " Loses");
                    return false;
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        return true;
        }
     
        public void BlackJack(){
            while(!winningConditions()) // Checks to make sure that the game is not already lost
            try{
            if (turnNumber == 0){ // Sets up the initial state of the games
                        if(playerNumber == 1){
                            writer.write(deckOfCards[0]); // Send the second dealer card
                            writer.flush();
                            writer.write(deckOfCards[1]); // Send the first player card
                            writer.flush();
                            writer.write(deckOfCards[2]); // Send the second player card
                            writer.flush();
                            Total = deckOfCards[1] + deckOfCards[2];
                        }
                        else if(playerNumber == 2){
                            writer.write(deckOfCards[0]); // Send the second dealer card
                            writer.flush();
                            writer.write(deckOfCards[3]);
                            writer.flush();
                            writer.write(deckOfCards[4]);
                            writer.flush();
                            Total = deckOfCards[3] + deckOfCards[4];
                        }
                        
                        turnNumber++;
                    }
                        else{
                            String response = "";
                            response = reader.readLine();
                            if(response.equals("HIT")){
                                if(playerNumber == 1){
                                writer.write(deckOfCards[5]);
                                writer.flush();
                                }
                                else if(playerNumber == 2){
                                    writer.write(deckOfCards[6]);
                                writer.flush();
                                }
                            }
            
        }
            }
            catch(Exception e){
                e.printStackTrace();
        }
        }
        
        public void Poker(){
            
        }
        
        public ServerRunnable(Socket s, int pNum){
            socket = s;
            playerNumber = pNum;
            try{
                reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
                writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        public void run(){
            try{
                writer.write(playerNumber);
                writer.flush();
                       if(gameChoice.equals("BlackJack")){
                           BlackJack();
                        }
                //        else if(gameChoice.equals("Poker")){
                 //           Poker();
                 //       }

                }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

public static void main(String[] args){
    Server server = new Server();
    server.playerConnections();
}

}
