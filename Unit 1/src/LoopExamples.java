import java.util.*;

public class LoopExamples {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        int number = 1; 
        
        while(number < 6){ // checks if number is less than 6 
            System.out.println(number); // prints value of number 
            number++; // adds 1 to the value of number 
            
        } // end of while loop (loop is done when number is 6)
        
        System.out.println("Done!");
        
        for(int i = 0; i < 100; i++){
            System.out.println(i + ": Hello World!");
            
        } // end of for loop 
        
        while(true){ 
            System.out.print("Enter a positive number: ");
            int num = input.nextInt();
            
            if(num > 0){ // input is ok; jump out of loop 
                System.out.println("Your number is positive.");
                break;
                
            }
            
            else{
                System.out.println("Invalid entry... number should be positive.");
                
            } // end of if-else statement 
            
        } // end of while loop 
        
    } // end of main 
    
} // end of class
