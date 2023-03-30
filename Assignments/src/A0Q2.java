import java.util.*;

public class A0Q2 {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in); // allows for user input 
        Random generator = new Random(); // generates random numbers
        
        int counter = 0; // creates a counter for the number of rounds played 
        int score1 = 0; // creates a variable that counts the number of times player 1 wins
        int score2 = 0; // creates a variable that counts the number of times player 2 wins
        
        System.out.println("High Card Game");
        
        while(true){ // loop will run infinitely 
            
            System.out.print("\nDeal cards? (enter 'y' or 'n'): "); // asks user if they want to run the program 
            String answer = input.next(); // sets variable 'answer' to the string given by the user 
            
            if(answer.equalsIgnoreCase("y")){ // checks if user inputs 'yes'
                counter++; // increases counter by 1
                
                int play1Num = generator.nextInt(13)+1; // sets variable 'play1Num' to a random integer from 1-13
                int play1Suit = generator.nextInt(4)+1; // sets variable 'play1Suit' to a random integer from 1-4
                
                int play2Num = generator.nextInt(13)+1; // sets variable 'play2Num' to a random integer from 1-13
                int play2Suit = generator.nextInt(4)+1; // sets variable 'play2Suit' to a random integer from 1-4
                
                System.out.println("Round " + counter); // outputs round number 
                System.out.println("Player 1: " + getCardValue(play1Num) + " of " + getCardSuit(play1Suit)); // tells the user what card player 1 got 
                System.out.println("Player 2: " + getCardValue(play2Num) + " of " + getCardSuit(play2Suit)); // tells the user what card player 2 got 
                
                if(play1Num > play2Num){ // checks if player 1 has a higher card than player 2 
                    System.out.println("Player 1 Wins!");
                    score1++; // gives player 1 a point
                    
                }
                
                else if(play2Num > play1Num){ // checks if player 2 has a higher card than player 2 
                    System.out.println("Player 2 Wins!");
                    score2++; // gives player 2 a point
                
                }
                
                else{ // runs program if both cards are the same value 
                    System.out.println("It's a tie!");
                    
                } // end of if else statement 
                
                System.out.println("Score: " + score1 + " - " + score2); // outputs the score 
            
            } 
            
            else if(answer.equalsIgnoreCase("n")){ // checks if user inputs 'n'
                System.out.println("You exited the program...");
                break; // breaks loop 
                
            }
            
            else{ 
                System.out.println("Invalid input... enter 'y' or 'n'."); // tells player what strings are valid for the question 
                
            } // end of if else statement 
            
    } // end of while loop 
        
    } // end of main 
    
    public static String getCardValue(int cardNum){ // takes an integer from 1-13 and returns the card's value 
        
        String value;
        
        if(cardNum == 1){
            value = ("Ace");
            
        }
        
        else if(cardNum == 2){
            value = ("Two");
            
        }
        
        else if(cardNum == 3){
            value = ("Three");
            
        }
        
        else if(cardNum == 4){
            value = ("Four");
            
        }
        
        else if(cardNum == 5){
            value = ("Five");
            
        }
        
        else if(cardNum == 6){
            value = ("Six");
            
        }
        
        else if(cardNum == 7){
            value = ("Seven");
            
        }
        
        else if(cardNum == 8){
            value = ("Eight");
            
        }
        
        else if(cardNum == 9){
            value = ("Nine");
            
        }
        
        else if(cardNum == 10){
            value = ("Ten");
            
        }
        
        else if(cardNum == 11){
            value = ("Jack");
            
        }
        
        else if(cardNum == 12){
            value = ("Queen");
            
        }
        
        else{
            value = ("King");
            
        }
        
        return value; // returns the string value of variable 'value'
        
    } // end of method "getCardValue"
    
    public static String getCardSuit(int cardSuit){ // takes an integer from 1-4 and returns the card's suit
        
        String suit; 
        
        if(cardSuit == 1){
            suit = ("Hearts");
            
        }
        
        else if(cardSuit == 2){
            suit = ("Diamonds");
            
        }
        
        else if(cardSuit == 3){
            suit = ("Spades");
            
        }
        
        else{
            suit = ("Clubs");
            
        }
        
        return suit; // returns the string value of variable 'suit'
        
    } // end of method 'getCardSuit'
    
} // end of class

