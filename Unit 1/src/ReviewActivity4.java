import java.util.*;

public class ReviewActivity4 {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in); // allows for user input 
        Random generator = new Random(); // creates random number generator 
        
        int answer = generator.nextInt(101); // sets a random number from 0-100 to variable "answer"
        int guess = -1;
        int numGuesses = 0;
        
        while(guess != answer){ // checks if the user guesses the correct number 
            System.out.print("Guess the integer from 0-100: ");
            guess = input.nextInt();
            
            if(guess < answer){ // checks if the guess was lower than the answer
                System.out.println("Your guess was too low. Try again.");
                
            }
            
            else if(guess > answer){ // checks if the guess was higher than the answer
                System.out.println("Your guess was too high. Try again.");
                
            } 
            
            else{ 
                
            } // end of if-else statement 
            
            numGuesses++; // counts the number of guesses from the user 
            
        } // end of while loop 
        
        System.out.println("You guessed the correct number after " + numGuesses + " guesses! The number was " + answer + "!");
        
    } // end of main 
    
} // end of class
