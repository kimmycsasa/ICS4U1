import java.util.*;

public class ReviewActivity3 {
    public static void main(String[] args){
        
        Random generator = new Random(); // creates a random number generator 
        Scanner input = new Scanner(System.in); // allows for user input 
        System.out.print("Do you want to roll? (type 'yes' or 'no'): ");
        String answer = input.nextLine();
        
        while(true){ // generates two random numbers from 1-6
            
            if(answer.equalsIgnoreCase("yes")){ // continues loop 
                int roll1 = generator.nextInt(5)+1;
                int roll2 = generator.nextInt(5)+1; 
            
                System.out.println("Roll 1: " + roll1);
                System.out.println("Roll 2: " + roll2);
            
                System.out.print("Do you want to roll again?: "); 
                answer = input.next();  
                
            }
            
            else if(answer.equalsIgnoreCase("no")){ // breaks out of loop 
                break;
                    
            }
            
            else{ // asks the question again 
                System.out.println("Invalid input... type yes or no.");
                System.out.print("Do you want to roll again?: ");
                answer = input.next();
                
            } // end of if-else statement 
            
        } // end of while loop 
        
    } // end of main 
    
} // end of class

