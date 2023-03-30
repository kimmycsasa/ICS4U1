import java.util.*; 

public class Player {
    
    // declares instance variables 
    private String name; 
    private int balance; 
    private int position; 
    private ArrayList<String> properties = new ArrayList<String>(); 
    
    public Player(String n){ // sets up a player
        name = n; 
        balance = 1500; 
        position = 0; 
    } // end of constructor method 
    
    public String getName(){ // returns player name
        return name; 
    } // end of 'getName' method
    
    public int getBalance(){ // returns player balance
        return balance; 
    } // end of 'getBalance'    
    
    public void collect(int amount){ // adds funds to player balance
        balance = balance + amount; 
    } // end of 'collect' method 
    
    public void pay(int amount){ // deducts payments from player balance
        balance = balance - amount; 
    } // end of 'pay' method 
    
    public void transfer(int amount, Player other){ // transfers money from player to another player
        balance = balance - amount; 
        other.collect(amount); 
    } // end of transfer method
    
    public void move(int roll){ // moves the player up the gameboard
        position = position + roll; 
        
        if(position > 27){ // runs program if player makes it around the gameboard
            balance = balance + 200; // adds $200 to their balance 
            int extra = position - 27; // finds the number of spaces they still need to move
            position = -1 + extra; // moves the player according to leftover dice value 
            System.out.println("You passed Go!\nYou've collected $200!");
            
        } // end of if statement 
        
    } // end of 'move' method 
    
    public int getPosition(){ // returns their position on the board
        return position; 
    } // end of 'getPosition' nethod 
    
    public void buyProperty(String name, int amount){ // takes money from player and adds given property to their 'properties' array list
        balance = balance - amount; 
        properties.add(name); // adds ownership of property 
    } // end of 'buyProperty' method 
    
    public int numProperties(){ // returns the number of properties they own 
        int amount = properties.size();
        return amount; 
           
    } // end of 'numProperties' 
    
    public void sellProperty(String name, int amount){ // adds funds to balance and takes away given properties from their 'properties' array list 
        balance = balance + amount;
        int index = linearSearch(properties, name); // calls 'linearSearch' method to find index of given property 
        properties.remove(index); // removes property from their ownership     
    } // end of 'sellProperty' method
    
    public String props(){ // returns the list of properties they own 
        String d = ("Properties: " + properties); 
        return d; 
    } // end of 'props' method 
    
    public static int linearSearch(ArrayList<String> a, String searchValue){
        
        for(int i = 0; i < a.size(); i++){ // goes through entire array list
            
            String search = a.get(i); 
            
            if(search.equals(searchValue)){ // if search value is found 
                return i; // return array index
            
            } // end of if else statement 
        } // end of for loop 

        return -1; // returns if not found
    
    } // end of linearSearch method 

} // end of class
