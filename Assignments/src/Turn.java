import java.util.*; 
import java.io.*; 
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

public class Turn implements ActionListener{
    
    // declares instance variables
    private ArrayList<Player> player = new ArrayList<Player>();
    private ArrayList<Properties> properties = new ArrayList<Properties>(); 
    private ArrayList<String> board = new ArrayList<String>(); 
    private ArrayList<String> owned = new ArrayList<String>(); 
    private ArrayList<String> owners = new ArrayList<String>(); 
    private JButton start; 
    private JButton rules; 
    private JFrame frame = new JFrame("Monopoly - Main Menu"); 
    private JFrame frame2 = new JFrame("Monopoly - Set Up"); 
    private JFrame frame3 = new JFrame("Monopoly - Playing");
    private JLabel numOfPlayers; 
    private JButton select; 
    private JComboBox<String> ddBox; 
    private JPanel setUp = new JPanel(); 
    private JPanel pTurn = new JPanel(); 
    private JButton roll; 
    private JButton sellProp; 
    private JButton endTurn; 
    private JButton selectn1; 
    private JButton selectn2;
    private JButton selectn3;
    private JButton selectn4;
    private  JTextField pName1;  
    private  JTextField pName2; 
    private  JTextField pName3; 
    private  JTextField pName4; 
    private JLabel enterName = new JLabel("Enter the name of Player 1: "); 
    private JLabel enterName2 = new JLabel("Enter the name of Player 2: "); 
    private JLabel enterName3 = new JLabel("Enter the name of Player 3: "); 
    private JLabel enterName4 = new JLabel("Enter the name of Player 4: "); 
    private Player currentPlayer;   
    private String currentPos; 
    private int turnCount = 0; 
    private int numPlayers = -1;  
    private JLabel playerTurn = new JLabel(""); 
    private JLabel selectProp = new JLabel("ENTER PROPERTY NAME:"); 
    private JTextField enterProp = new JTextField(20); 
    private JButton propSell = new JButton("SELECT"); 
    private JLabel pBalance = new JLabel(""); 
    private JLabel pProps = new JLabel(""); 
    private JLabel buyProp = new JLabel(""); 
    private JButton yes = new JButton("YES"); 
    private JButton no = new JButton("NO"); 
    private Properties temp; 
    private JLabel winner = new JLabel(""); 
    private JButton exit = new JButton("EXIT"); 
    
    public Turn() throws IOException{ // sets the information of the board game
        
        Scanner reader = new Scanner(new File("gameboard.txt")); // reads infromation from 'gameboard.txt' file
        
        while(reader.hasNext()){ // continues while there's still information 
            String space = reader.next(); // reads information from file 
            board.add(space); // adds information from file to 'board' array list 
            
        } // end of while loop 
        
        Scanner reader2 = new Scanner(new File("properties.txt")); // reads information from 'properties.txt' file
        
        while(reader2.hasNext()){ // continues while there's still information 
            
            // reads information from file 
            String prop = reader2.next(); 
            int buy = reader2.nextInt(); 
            int earn = reader2.nextInt(); 
            int sell = reader2.nextInt(); 
            
            Properties temp = new Properties(prop, buy, sell, earn); // creates a temporary Properties object 
            properties.add(temp); // adds temporary object to 'properties' array list 
            
        } // end of while loop 
        
    } // end of 'Turn' constructor method 
    
    public void outputGUI(){ // outputs GUI
        JPanel menu = new JPanel(); 
        menu.setLayout(null); // resets the layout of 'menu' 
        frame.add(menu); 
        
        // creates new JButton and sets their name
        start = new JButton("START"); 
        rules = new JButton("RULES"); 
        
        // adds action listener to buttons
        start.addActionListener(this); 
        rules.addActionListener(this); 
        
        // sets location of buttons
        start.setBounds(50, 125, 400, 150);
        rules.setBounds(525, 125, 400, 150);
        
        // adds JButtons to JPanel
        menu.add(start); 
        menu.add(rules);         
        
        frame.setSize(1000, 500); 
        frame.setLocationRelativeTo(null); // sets frame to the middle of the screen
        frame.setVisible(true); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes window when they press 'x'
        
        frame2.add(setUp); 
        numOfPlayers = new JLabel("Select the number of players: "); 
        setUp.add(numOfPlayers); 
        select = new JButton("SELECT"); 
        select.addActionListener(this); 
        setUp.add(select); 
        String[] nums = {"2", "3", "4"}; // creates array of strings for amount of players
        ddBox = new JComboBox<String>(nums); // makes 'nums' array the options for the drop down box
        setUp.add(ddBox); 
            
        frame2.setSize(1000, 500); 
        frame2.setLocationRelativeTo(null); 
        frame2.setVisible(false); 
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            
        frame3.add(pTurn); 
        roll = new JButton("ROLL"); 
        sellProp = new JButton("SELL PROPERTY"); 
        endTurn = new JButton("END TURN"); 
        roll.addActionListener(this); 
        sellProp.addActionListener(this); 
        propSell.addActionListener(this); 
        endTurn.addActionListener(this);  
        yes.addActionListener(this); 
        no.addActionListener(this); 
        exit.addActionListener(this); 
            
        frame3.setSize(1000, 500); 
        frame3.setLocationRelativeTo(null); 
        frame3.setVisible(false); 
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
        
        
        
    } // end of 'outputGUI' method 
    
    public void actionPerformed(ActionEvent e){ // performs certain programs depending on which button is pressed 
        
        Random generator = new Random(); // generates random numbers
        
        if(e.getSource() == start){ // if 'start' is pressed
            frame.setVisible(false); // closes 'frame' 
            
            // resets layout of 'setUp' 
            setUp.setLayout(null); 
            select.setBounds(400, 50, 100, 50); 
            numOfPlayers.setBounds(100, 50, 200, 50); 
            ddBox.setBounds(300, 50, 100, 50);
            
            frame2.setVisible(true); // opens 'frame2'              
            
        }
            
        if(e.getSource() == select){ // if 'select' is pressed 

            if(ddBox.getSelectedItem() == "2"){
                    
                    numPlayers = 2;
                    
                    // closes drop down box GUI
                    numOfPlayers.setBounds(0, 0, 0, 0);
                    select.setBounds(0, 0, 0, 0); 
                    ddBox.setBounds(0, 0, 0, 0); 

                    // opens 2 GUI components for entering a player's name 
                    setUp.add(enterName);  
                    enterName.setBounds(50, 200, 300, 50); 
                    pName1 = new JTextField(20); 
                    
                    setUp.add(pName1); 
                    pName1.setBounds(50, 250, 100, 50);
                    selectn1 = new JButton("SELECT"); 
                    setUp.add(selectn1); 
                    
                    selectn1.setBounds(50, 300, 100, 50); 
                    selectn1.addActionListener(this); 

        
                    setUp.add(enterName2);  
                    enterName2.setBounds(250, 200, 300, 50); 
                    pName2 = new JTextField(20); 
                    
                    setUp.add(pName2); 
                    pName2.setBounds(250, 250, 100, 50);
                    selectn2 = new JButton("SELECT"); 
                    setUp.add(selectn2); 
                    
                    selectn2.setBounds(250, 300, 100, 50); 
                    selectn2.addActionListener(this);                       

                }
                
                else if(ddBox.getSelectedItem() == "3"){
                    
                    numPlayers = 3; 
                    
                    // closes drop down box GUI
                    numOfPlayers.setBounds(0, 0, 0, 0);
                    select.setBounds(0, 0, 0, 0); 
                    ddBox.setBounds(0, 0, 0, 0); 
                    
                    // opens 3 GUI components for entering a player's name
                    setUp.add(enterName);  
                    enterName.setBounds(50, 200, 300, 50); 
                    pName1 = new JTextField(20); 
                    
                    setUp.add(pName1); 
                    pName1.setBounds(50, 250, 100, 50);
                    selectn1 = new JButton("SELECT"); 
                    setUp.add(selectn1); 
                    
                    selectn1.setBounds(50, 300, 100, 50); 
                    selectn1.addActionListener(this); 

          
                    setUp.add(enterName2);  
                    enterName2.setBounds(250, 200, 300, 50); 
                    pName2 = new JTextField(20); 
                    
                    setUp.add(pName2); 
                    pName2.setBounds(250, 250, 100, 50);
                    selectn2 = new JButton("SELECT"); 
                    setUp.add(selectn2); 
                    
                    selectn2.setBounds(250, 300, 100, 50); 
                    selectn2.addActionListener(this);    
                    
        
                    setUp.add(enterName3);  
                    enterName3.setBounds(450, 200, 300, 50); 
                    pName3 = new JTextField(20); 
                    
                    setUp.add(pName3); 
                    pName3.setBounds(450, 250, 100, 50);
                    selectn3 = new JButton("SELECT"); 
                    setUp.add(selectn3); 
                    
                    selectn3.setBounds(450, 300, 100, 50); 
                    selectn3.addActionListener(this);   
                    
                }

                else if(ddBox.getSelectedItem() == "4"){
                    
                    numPlayers = 4; 
                    
                    // closes drop down box GUI components 
                    numOfPlayers.setBounds(0, 0, 0, 0);
                    select.setBounds(0, 0, 0, 0); 
                    ddBox.setBounds(0, 0, 0, 0);                     

                    // opens 4 GUI components for entering a player's name 
                    setUp.add(enterName);  
                    enterName.setBounds(50, 200, 300, 50); 
                    pName1 = new JTextField(20); 
                    
                    setUp.add(pName1); 
                    pName1.setBounds(50, 250, 100, 50);
                    selectn1 = new JButton("SELECT"); 
                    setUp.add(selectn1); 
                    
                    selectn1.setBounds(50, 300, 100, 50); 
                    selectn1.addActionListener(this); 

          
                    setUp.add(enterName2);  
                    enterName2.setBounds(250, 200, 300, 50); 
                    pName2 = new JTextField(20); 
                    
                    setUp.add(pName2); 
                    pName2.setBounds(250, 250, 100, 50);
                    selectn2 = new JButton("SELECT"); 
                    setUp.add(selectn2); 
                    
                    selectn2.setBounds(250, 300, 100, 50); 
                    selectn2.addActionListener(this);    
                    

                    setUp.add(enterName3);  
                    enterName3.setBounds(450, 200, 300, 50); 
                    pName3 = new JTextField(20); 
                    
                    setUp.add(pName3); 
                    pName3.setBounds(450, 250, 100, 50);
                    selectn3 = new JButton("SELECT"); 
                    setUp.add(selectn3); 
                    
                    selectn3.setBounds(450, 300, 100, 50); 
                    selectn3.addActionListener(this);  
                    
  
                    setUp.add(enterName4);  
                    enterName4.setBounds(650, 200, 300, 50); 
                    pName4 = new JTextField(20); 
                    
                    setUp.add(pName4); 
                    pName4.setBounds(650, 250, 100, 50);
                    selectn4 = new JButton("SELECT"); 
                    setUp.add(selectn4); 
                    
                    selectn4.setBounds(650, 300, 100, 50); 
                    selectn4.addActionListener(this);                      
                    
                }
    
        } // end of if statement 
        
        if(e.getSource() == selectn1){ // if 'selectn1' is pressed 
            
            if(pName1.getText().equals("")){ // if JTextField is empty 
                
            }
                        
            else{
        
                Player temp = new Player(pName1.getText()); // creates temporary Player object
                player.add(temp); // adds Player to array list of players
                
                // closes GUI for entering player 1's name 
                enterName.setBounds(0, 0, 0, 0); 
                pName1.setBounds(0, 0, 0, 0); 
                selectn1.setBounds(0, 0, 0, 0); 
                 
            }
                        
                                
        } // end of if statement 
        
        if(e.getSource() == selectn2){ // if 'selectn2' is pressed
            
            if(pName2.getText().equals("")){ // if JTextField is empty 
                
            }
            
            else{
                
                Player temp = new Player(pName2.getText()); // creates temporary Player object 
                player.add(temp); // adds Player to array list of players 
                
                // closes GUI for entering player 2's name
                enterName2.setBounds(0, 0, 0, 0); 
                pName2.setBounds(0, 0, 0, 0); 
                selectn2.setBounds(0, 0, 0, 0);

            } // end of if else statement               
                                
        } // end of if statement 

        if(e.getSource() == selectn3){ // if 'selectn3' is pressed
            
            if(pName3.getText().equals("")){ // if JTextField is empty
                
            }
            
            else{
           
                Player temp = new Player(pName3.getText()); // creates temporary Player object
                player.add(temp); // adds Player to array list of players
                
                // closes GUI for entering player 3's name
                enterName3.setBounds(0, 0, 0, 0); 
                pName3.setBounds(0, 0, 0, 0); 
                selectn3.setBounds(0, 0, 0, 0); 
                   
            } // end of if else statement 
           
        } // end of if statement 

        if(e.getSource() == selectn4){ // if 'selectn4' is pressed
            
            if(pName4.getText().equals("")){ // if JTextField is empty
                
            }
                        
            else{
         
                Player temp = new Player(pName4.getText()); // creates temporary Player object
                player.add(temp); // adds Player to array list of players
                
                // closes GUI for entering player 4's name 
                enterName4.setBounds(0, 0, 0, 0); 
                pName4.setBounds(0, 0, 0, 0); 
                selectn4.setBounds(0, 0, 0, 0);    
              
            } // end of if else statement         
        
        } // end of if statement 
        
        if(player.size() == numPlayers){ // runs program once all Player names are entered
            
            // sets GUI components of 'frame3'
            pTurn.setLayout(null); 
            roll.setBounds (50, 50, 200, 50); 
            pTurn.add(roll); 
            currentPlayer = player.get(turnCount);

            playerTurn.setText("Player " + currentPlayer.getName() + "'s Turn");
            playerTurn.setBounds(50, 0, 200, 50); 
            pTurn.add(playerTurn);
            
            pBalance.setText("Balance: $" + currentPlayer.getBalance()); 
            pProps.setText(currentPlayer.props()); 
            pBalance.setBounds(500, 50, 100, 50); 
            pProps.setBounds(500, 75, 100, 50);  
            pTurn.add(pBalance); 
            pTurn.add(pProps); 
            
            exit.setBounds(750, 375, 200, 50); 
            pTurn.add(exit); 
            
            // closes previous frames and opens new frame
            frame2.setVisible(false); 
            frame3.setVisible(true); 
            
            numPlayers = -1; // sets 'numPlayers' to -1 so this option doesn't run again until a new game is played
            
        } // end of if statement 
        
        if(e.getSource() == roll){ // if 'roll' is pressed
            
            // sets GUI components 
            pTurn.setLayout(null); 
            roll.setBounds(0, 0, 0, 0);  
            endTurn.setBounds(50, 350, 200, 50); 
            pTurn.add(endTurn);    
            sellProp.setBounds(50, 200, 200, 50); 
            pTurn.add(sellProp);             
            
            int moves = generator.nextInt(6)+1; // rolls a 6 sided die
            System.out.println("\nPlayer " + currentPlayer.getName() + "'s Turn\n");
            System.out.println("You rolled a " + moves + "!"); 
            currentPlayer.move(moves); // moves the player according to what they rolled
            currentPos = board.get(currentPlayer.getPosition()); // sets 'currentPos' to what the player landed on 
            System.out.println("You landed on " + currentPos + "!\n"); 
            pBalance.setText("Balance: $" + currentPlayer.getBalance()); // updates player balance JLabel
            
            
     
            if(currentPos.equals("Luck")){ // if player lands on 'Luck' space
                luck(currentPlayer); // calls 'luck' method 
                pBalance.setText("Balance: $" + currentPlayer.getBalance()); // updates player balance JLabel
            } 
            
            else if(currentPos.equals("Fines")){ // if player lands on 'Fines' space
                fines(currentPlayer); // calls 'fines' method 
                pBalance.setText("Balance: $" + currentPlayer.getBalance());               
            }
            
            else if(currentPos.equals("Tax")){ // if player lands on 'Tax' space
                tax(currentPlayer); // calls 'tax' method 
                pBalance.setText("Balance: $" + currentPlayer.getBalance()); // updates player balance JLabel                 
            }
            
            else if(currentPos.equals("Go") || currentPos.equals("Visiting") || currentPos.equals("Parking")){ // if player lands on 'Go', 'Visiting', or 'Parking' space              
            }
            
            else{ // if player lands on a property space
                int index = searchProperty(properties, currentPos); // finds index of the property the player landed on
                int index2 = linearSearch(owned, currentPos); // checks if anyone owns the property 
                temp = properties.get(index); // sets 'temp' to the property at given index 
                
                if(index2 == -1){ // if no one owns the property 
                    
                    if(currentPlayer.getBalance() > temp.getBuyPrice()){ // if 'currentPlayer' has enough money to buy property 
                        
                        // sets GUI components 
                        pTurn.setLayout(null);
                        buyProp.setText("Buy " + currentPos + " for $" + temp.getBuyPrice() + "?:");
                        buyProp.setBounds(550, 150, 500, 50);
                        pTurn.add(buyProp); 
                        yes.setBounds(500, 200, 100, 50); 
                        pTurn.add(yes); 
                        no.setBounds(600, 200, 100, 50);
                        pTurn.add(no); 
                        endTurn.setBounds(0, 0, 0, 0); 
                        sellProp.setBounds(0, 0, 0, 0); 

                   }
                    
                   else{
               
                    } // end of if else statement 
                    
                }
                
                else{ // if someone owns the property 
                    
                    int index3 = linearSearch(owned, currentPos); // finds index of the property 
                    String name = owners.get(index3); // finds who owns the property
                    int index4 = searchPlayer(player, name); // finds index of the player who owns the property 
                    Player n = player.get(index4); // sets 'n' to the owner 
                    currentPlayer.transfer(temp.getIncome(), player.get(index4)); // transfers money from 'currentPlayer' to owner
                    
                    if(name.equals(currentPlayer.getName())){ // if the owner of the property is the current player
                        
                    }
                            
                    else{   
                        
                        System.out.println("You payed " + name + " $" + temp.getIncome() + " for staying overnight!");   
                        
                        // sets GUI components 
                        pTurn.setLayout(null); 
                        pBalance.setText("Balance: $" + currentPlayer.getBalance());        
                    
                    } // end of if else statement                  
                    
                } // end of if else statement 
                
            } // end of if else statement 
            
        } // end of if statement       
        
        if(e.getSource() == yes){ // if 'yes' is pressed
            
            // sets GUI components 
            pTurn.setLayout(null); 
            currentPlayer.buyProperty(currentPos, temp.getBuyPrice()); 
            pBalance.setText("Balance: $" + currentPlayer.getBalance()); 
            pProps.setText(currentPlayer.props()); 
            owned.add(currentPos); 
            owners.add(currentPlayer.getName());  
            buyProp.setBounds(0, 0, 0, 0); 
            yes.setBounds(0, 0, 0, 0); 
            no.setBounds(0, 0, 0, 0); 
            pProps.setBounds(500, 75, 500, 50);
            endTurn.setBounds(50, 350, 200, 50); 
            sellProp.setBounds(50, 200, 200, 50); 
            
        }
        
        if (e.getSource() == no){ // if 'no' is pressed
            
            // sets GUI components
            pTurn.setLayout(null); 
            buyProp.setBounds(0, 0, 0, 0); 
            yes.setBounds(0, 0, 0, 0); 
            no.setBounds(0, 0, 0, 0);  
            endTurn.setBounds(50, 350, 200, 50); 
            sellProp.setBounds(50, 200, 200, 50);             
            
        } // end of if statement 
            
        if(e.getSource() == sellProp){ // if 'sellProp; is pressed 
            
            if(currentPlayer.numProperties() == 0){ // if player has no properties 
                
            }
            
            else{
                
                // sets GUI components
                pTurn.setLayout(null); 
                selectProp.setBounds(300, 150, 200, 50); 
                pTurn.add(selectProp); 
                enterProp.setBounds(300, 200, 200, 50); 
                pTurn.add(enterProp); 
                propSell.setBounds(500, 200, 200, 50); 
                pTurn.add(propSell); 
                sellProp.setBounds(0, 0, 0, 0); 
                endTurn.setBounds(0, 0, 0, 0);     
            
            } // end of if else statement 
            
        } // end of if else statement 
        
        if(e.getSource() == propSell){ // if 'propSell' is pressed 
            
            if(enterProp.getText().equals("")){ // if JTextField is empty 
                
            }
            
            else{

                String prop = enterProp.getText();
                int index1 = linearSearch(owned, prop); // checks if anyone owns the given property
                
                if(index1 == -1){ // if player doesn't own the property they entered
                    System.out.println("This property is unowned...try again..."); 
                }
                
                else{
                    
                    String index2 = owners.get(index1); // finds who owns the property 
                    
                    if(index2.equals(currentPlayer.getName())){ // if the current player owns the property 
                        int index3 = searchProperty(properties, prop); // finds the index of the property 
                        Properties temp = properties.get(index3); // sets property as tempoarary variable 
                        currentPlayer.sellProperty(prop, temp.getSellPrice()); // transfers money into current players balance and removes their ownership of the proeprty 
                        
                        // makes the property unsold 
                        owners.remove(index1); 
                        owned.remove(index1); 
                        
                        // sets GUI component 
                        pTurn.setLayout(null);
                        selectProp.setBounds(0, 0, 0, 0);
                        enterProp.setBounds(0, 0, 0, 0); 
                        propSell.setBounds(0, 0, 0, 0); 
                        sellProp.setBounds(50, 200, 200, 50); 
                        endTurn.setBounds(50, 350, 200, 50); 
                        pBalance.setText("Balance: $" + currentPlayer.getBalance()); 
                        pProps.setText(currentPlayer.props()); 
                        pBalance.setBounds(500, 50, 100, 50); 
                        pProps.setBounds(500, 75, 500, 50);                          
          
                    }
                    
                    else{
                        System.out.println("You don't own this property...try again..."); 
                    } // end of if else statement 
                    
                } // end of if else statement 
                            
            } // end of if else statement 
        } // end of if statement 
        
        if(e.getSource() == endTurn){ // if 'endTurn' is pressed
            
            if(currentPlayer.getBalance() < 0 && currentPlayer.numProperties() == 0){ // if 'currentPlayer' cannot gain money anymore 
                System.out.println("You're bankrupt! You lost!"); 
                player.remove(turnCount); // removes player from game 

                if(player.size() == 1){ // if there's one player left
                    
                    // sets GUI components 
                    pTurn.setLayout(null); 
                    playerTurn.setBounds(0, 0, 0, 0); 
                    sellProp.setBounds(0, 0, 0, 0); 
                    endTurn.setBounds(0, 0, 0, 0); 
                    pBalance.setBounds(0, 0, 0, 0); 
                    pProps.setBounds(0, 0, 0, 0); 
                    propSell.setBounds(0, 0, 0, 0); 
                    selectProp.setBounds(0, 0, 0, 0); 
                    buyProp.setBounds(0, 0, 0, 0); 
                    yes.setBounds(0, 0, 0, 0); 
                    no.setBounds(0, 0, 0, 0); 
                    Player win = player.get(0); 
                    winner.setText("Player " + win.getName() + " Won!"); 
                    winner.setBounds(450, 150, 500, 50); 
                    pTurn.add(winner); 
                    exit.setBounds(375, 250, 200, 50); 

                }
                
                else{
                    whichPlayer(); // goes to next player 
                    
                    // sets GUI components 
                    pTurn.setLayout(null); 
                    endTurn.setBounds(50, 0, 0, 0); 
                    roll.setBounds (50, 50, 200, 50); 
                    pBalance.setText("Balance: $" + currentPlayer.getBalance()); 
                    pProps.setText(currentPlayer.props());    
                    playerTurn.setText("Player " + currentPlayer.getName() + "'s Turn");
                    pBalance.setBounds(500, 50, 100, 50); 
                    pProps.setBounds(500, 75, 500, 50);   
                    enterProp.setBounds(0, 0, 0, 0); 
                    propSell.setBounds(0, 0, 0, 0); 
                    selectProp.setBounds(0, 0, 0, 0); 
                    sellProp.setBounds(0, 0, 0, 0);                     
                    
                } // end of if else statement 
                
            }
            
            else if(currentPlayer.getBalance() < 0){ // if current player has a negative balance but can sell properties 
                System.out.println("You are in debt! You must sell properties!"); 
            }
            
            else{
                whichPlayer(); // goes to the next player 
                
                // sets GUI components 
                pTurn.setLayout(null); 
                endTurn.setBounds(50, 0, 0, 0); 
                roll.setBounds (50, 50, 200, 50); 
                pBalance.setText("Balance: $" + currentPlayer.getBalance()); 
                pProps.setText(currentPlayer.props());    
                playerTurn.setText("Player " + currentPlayer.getName() + "'s Turn");
                pBalance.setBounds(500, 50, 100, 50); 
                pProps.setBounds(500, 75, 500, 50);   
                enterProp.setBounds(0, 0, 0, 0); 
                propSell.setBounds(0, 0, 0, 0); 
                selectProp.setBounds(0, 0, 0, 0); 
                sellProp.setBounds(0, 0, 0, 0); 

            } // end of if else statement               
        
        } // end of if statement 
        
        if(e.getSource() == exit) { // if 'exit' is pressed 
            
            // goes back to main menu and sets GUI components 
            frame.setVisible(true); 
            frame3.setVisible(false);  
            pTurn.setLayout(null); 
            winner.setBounds(0, 0, 0, 0); 
            
            // resets game variables 
            player = new ArrayList<Player>();  
            owned = new ArrayList<String>(); 
            owners = new ArrayList<String>();              

        } // end of if statement 
        
        if(e.getSource() == rules){ // if 'rules' is pressed 
            System.out.println("- each player starts with $1500\n- each player takes turns rolling the die\n- buy properties to become the richest\n- sell properties to get out of debt\n- you lose when you're bankrupt and have no more properties\n\nFines space - fines you for breaking the law\nLuck space - gain money from finding cash lying around\nTax space - taxes you for the amount of properties you own\nGo space - earn $200 in salary every time you pass go\n\nNote: Visiting and Parking are free spaces\n"); 
            
        } // end of if statement 
        
    } // end of 'actionPerformed' method 
    
    
    public void whichPlayer(){ // keeps track of who's turn it is 
        turnCount++; // increments 'turnCount' 
        
        if(turnCount > player.size() - 1){ // runs if all players took a turn and restarts the loop 
            turnCount = 0; // resets loop of turns
        }
        
        else{
            
        }
        
        currentPlayer = player.get(turnCount); // sets 'currentPlayer' as the player at given index
        
    }
    
    public static void fines(Player p){ // fines players 
        Random generator = new Random(); // generates random numbers
        int fine = generator.nextInt(1000) + 1; // generates a fine amount from $1 - $1000
        System.out.println("The cops caught you doing some illegal activities! You were fined $" + fine + "!"); 
        p.pay(fine); 
    } // end of 'fines' method 
    
    public static void luck(Player p){ // gives money to players
        Random generator = new Random(); // generates random numbers
        int donation = generator.nextInt(200) + 1; // generates an amount from $1 - $200
        System.out.println("You're lucky! You found $" + donation + " on the floor!");
        p.collect(donation); 
    } // end of 'luck' method 
    
    public static void tax(Player p){ // taxes players for the amount of properties they own 
        
        if(p.numProperties() > 0){ // if player owns properties
            int tax = p.numProperties() * 100; // calculates tax amount 
            System.out.println("You need to pay an income tax! The bank took $" + tax + " from your bank account."); 
            p.pay(tax);
        }
        
        else{ // if player doesn't own any properties
            System.out.println("You dodged the tax collectors!"); 
        }
        
    } // end of 'tax' method 
    
    public static int searchPlayer(ArrayList<Player> p, String searchValue){ // finds given player in the Player array list 
        
        for(int i = 0; i < p.size(); i++){ // goes through each index in the array list 
            
            Player temp = p.get(i); // creates temporary Player variable for the given index
            String search = temp.getName(); // sets variable to compare 'searchValue' to 
            
            if(search.equals(searchValue)){ // if search value is found 
                return i; // return array index
            
            } // end of if else statement 
        } // end of for loop 

        return -1;
        
    } // end of 'searchPlayer' method 
    
    public static int searchProperty(ArrayList<Properties> p, String searchValue){ // finds given property in the Properties array list 
        
        for(int i = 0; i < p.size(); i++){ // goes through each index in the array list 
            
            Properties temp = p.get(i); // creates temporary Properties variable for the given index 
            String search = temp.getName(); // sets variable to compare 'searchValue' to 
            
            if(search.equalsIgnoreCase(searchValue)){ // if search value is found 
                return i; // return array index
            
            } // end of if else statement 
        } // end of for loop 

        return -1;
        
    } // end of linearSearch method 
    
    public static int linearSearch(ArrayList<String> a, String searchValue){ // finds given value in a string array list 
        
        for(int i = 0; i < a.size(); i++){ // goes through each index in the array list 
            
            String search = a.get(i); // sets variable to compare 'searchValue' to 
            
            if(search.equals(searchValue)){ // if search value is found 
                return i; // return array index
            
            } // end of if else statement 
        } // end of for loop 

        return -1;
        
    } // end of linearSearch method 
        
} // end of class


