import java.util.*;

public class A1Q1 {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in); // allows for user input
        
        String[] deckSuit = new String[52]; // creates an array with 52 addresses that holds the suit value of each card in a standard deck
        String[] deckValue = new String[52]; // creates an array with 52 addresses that holds the face value of each card in a standard deck
        
        // sets each card in the deckSuit array to a designated suit (13 of each suit)
        for(int i = 0; i <= 12; i++){
            deckSuit[i] = "Hearts";
        }
        
        for(int i = 13; i <= 25; i++){
            deckSuit[i] = "Diamonds"; 
        }
        
        for(int i = 26; i <= 38; i++){
            deckSuit[i] = "Clubs";
        }
        
        for(int i = 39; i <= 51; i++){
            deckSuit[i] = "Spades";
        }
        
        // sets each address in the deckValue array to a designated face value (4 of each value)
        for(int i = 0; i < deckValue.length; i = i + 13){
            deckValue[i] = "Ace"; 
        }
        
        for(int i = 1; i < deckValue.length; i = i + 13){
            deckValue[i] = "Two";
        }
        
        for(int i = 2; i < deckValue.length; i = i + 13){
            deckValue[i] = "Three";
        }
        
        for(int i = 3; i < deckValue.length; i = i + 13){
            deckValue[i] = "Four";
        }
        
        for(int i = 4; i < deckValue.length; i = i + 13){
            deckValue[i] = "Five";
        }
        
        for(int i = 5; i < deckValue.length; i = i + 13){
            deckValue[i] = "Six";
        }
        
        for(int i = 6; i < deckValue.length; i = i + 13){
            deckValue[i] = "Seven";
        }

        for(int i = 7; i < deckValue.length; i = i + 13){
            deckValue[i] = "Eight";
        }
        
        for(int i = 8; i < deckValue.length; i = i + 13){
            deckValue[i] = "Nine";
        }
        
        for(int i = 9; i < deckValue.length; i = i + 13){
            deckValue[i] = "Ten";
        }
        
        for(int i = 10; i < deckValue.length; i = i + 13){
            deckValue[i] = "Jack";
        }
        
        for(int i = 11; i < deckValue.length; i = i + 13){
            deckValue[i] = "Queen";
        }
        
        for(int i = 12; i < deckValue.length; i = i + 13){
            deckValue[i] = "King";
        }
        
        int answer; // declares variable called 'answer' (used to store users input for the options)
        
        while(true){ // creates a loop that continuously lets the user choose from four options in the program 
            System.out.println("\n1 - print deck \n2 - shuffle deck \n3 - deal cards \n0 - exit"); // prints out the options and their corresponding number
            System.out.print("Enter your Option: "); // asks the user to input the number corresponding to their desired option
            answer = input.nextInt(); // sets variable answer to the integer the user inputs
            
            if(answer == 1){ // checks to see if user inputs 1
                printDeck(deckValue, deckSuit); // calls on the method printDeck
            }
            
            else if(answer == 2){ // checks to see if user inputs 2
                shuffleDeck(deckValue, deckSuit); // calls on the method shuffleDeck
                
            }
            
            else if(answer == 3){ // checks to see if user inputs 3
                
                while(true){ // runs the following program in a continuous loop 
                
                System.out.print("\nEnter the number of hands to be dealt: "); // asks the user to enter an integer 
                int numHands = input.nextInt(); // sets variable 'numHands' to the integer the user inputs 
                
                System.out.print("Enter the number of cards in each hand: "); // asks the user to enter an integer 
                int numCards = input.nextInt(); // sets variable 'numCards' to the integer the user inputs 
                
                if(numHands*numCards > 52 || numHands <=0 || numCards <= 0){ // checks to see if the user wants to deal more than 52 cards, or a negative number of hands or cards
                    System.out.println("Invalid input... enter positive numbers (the deck as 52 cards)."); // tells the user they can't deal that amount of cards
                    
                }
                
                else{ // runs if the user asks to deal cards that are within the 52 card limit
                    dealCards(deckValue, deckSuit, numHands, numCards); // calls on method dealCards
                    break; // breaks while loop (goes back to main menu)
                    
                }
                
                } // end of while loop
                
            } 
            
            else if(answer == 0){ // checks to see if the user inputs 0
                System.out.println("You exited the program..."); // tells the user they exited the program 
                break; // breaks loop; ends program 
                
            }
            
            else{ // runs if the user has an invalid input i.e. none of the above options listed in the menu
                System.out.println("Invalid input... enter the number of your corresponding choice."); // tells the user they put an invalid input 
                
            } // end of if else statement
            
        } // end of while loop 
        
    } // end of main 
    
    public static void printDeck(String[] value, String[] suit){ // prints out the value of each address in the parallel arrays 
        System.out.println();
        
        for(int i = 0; i < value.length; i++){ // goes through all 52 addresses in the parallel arrays 
            System.out.println(value[i] + " of " + suit[i]); // prints out the card's suit and face value
        } // end of for loop 
        
    } // end of printDeck method 
    
    public static void shuffleDeck(String[] value, String[] suit){ // rearranges the the values of the addresses
        
        Random generator = new Random(); // creates a random class to generate random numbers
        String newValue, newSuit;
        
        for(int i = 0; i < value.length; i++){ // goes through all 52 addresses in the parallel arrays      
            int shuffle = generator.nextInt(52); // sets variable 'shuffle' to a random number between 0-51
            
            newValue = value[shuffle]; // sets value of variable 'newValue' to value of address at a random index (stores original value of the card)
            newSuit = suit[shuffle]; // sets value of variable 'newSuit' to value of address at a random index (stores original value of the card)
            
            value[shuffle] = value[i]; // switches the face value at index 'shuffle' to face value at index 'i'
            suit[shuffle] = suit[i]; // switches the suit at index 'shuffle' to suit at index 'i'
            
            value[i] = newValue; // sets the face value at index 'i' to old face value of index 'shuffle'
            suit[i] = newSuit; // sets the suit at index 'i' to old suit of index 'shuffle'
            
        } // end of for loop 
        
    } // end of method 'shuffleDeck'
    
    public static void dealCards(String[] value, String[] suit, int numHands, int numCards){ // deals cards depending on the number of hands and cards in each hand inputted by the user, and prints out the total value of each hand
        
        int topCard = 0; // sets variable 'topCard' equal to 0 
        
        for(int i = 1; i <= numHands; i++){ // prints out the number of hands that are dealt
            int total = 0; // sets variable 'total' equal to 0
            
            System.out.println("\nHand #" + i); // counts which hand the cards are given to
            
            for(int j = 0; j < numCards; j++){ // prints out the number of cards in each hand 
                System.out.println(value[topCard] + " of " + suit[topCard]); // prints out the card at the top of the deck
                
                //checks the string value of index and adds its corresponding number value to the total 
                if(value[topCard].equalsIgnoreCase("ace")){
                    total = total + 1;
                    
                }
                
                else if(value[topCard].equalsIgnoreCase("two")){
                    total = total + 2;
     
                }
                
                else if(value[topCard].equalsIgnoreCase("three")){
                    total = total + 3;
                    
                }
                
                else if(value[topCard].equalsIgnoreCase("four")){
                    total = total + 4;
                    
                }
                
                else if(value[topCard].equalsIgnoreCase("five")){
                    total = total + 5;
                    
                }
                
                else if(value[topCard].equalsIgnoreCase("six")){
                    total = total + 6;
                    
                }
                
                else if(value[topCard].equalsIgnoreCase("seven")){
                    total = total + 7;
                    
                }
                
                else if(value[topCard].equalsIgnoreCase("eight")){
                    total = total + 8;
                    
                }
                
                else if(value[topCard].equalsIgnoreCase("nine")){
                    total = total + 9;
                            
                }
                
                else if(value[topCard].equalsIgnoreCase("ten")){
                    total = total + 10;
                    
                }
                
                else if(value[topCard].equalsIgnoreCase("jack")){
                    total = total + 11;
                    
                }
                
                else if(value[topCard].equalsIgnoreCase("queen")){
                    total = total + 12;
                            
                }
                
                else{
                    total = total + 13;
                    
                } // end of if else statement
                
                topCard++; // increments variable (keeps track of how many cards were already dealt)
                
            } // end of for loop     
            
            System.out.println("Total: " + total); // prints out the total value of the hand
            
        } // end of for loop 
        
    } // end of 'dealCards' method
    
} // end of class

