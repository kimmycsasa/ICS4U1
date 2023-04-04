import java.util.*;

public class ReviewActivity5 {
    public static void main(String[] args){ 
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Average of Integers from 1 to a Given Integer");
        System.out.print("Enter an integer: "); 
        int limit = input.nextInt();
        sumAndAverage(limit);
        
    } // end of main 
    
    public static void sumAndAverage(int limit){ // creates a method called "sumAndAverage" that takes in an integer
        
        int sum = 0; // sets variable "sum" to 0 
        double ogLimit = limit; // sets variable "ogLimit" to the value that the user inputs 
        double avg; // declares double variable called "avg"
        
        while(limit != 0){ // continues the loop if variable "limit" doesn't equal 0 
            
            sum = sum + limit; 
            limit--; // decrements the value of variable "limit" 
            
        } // end of while loop 
        
        avg = sum/ogLimit; // finds the average of the sum of numbers from 1 to the number the user input
        
        System.out.println("The average of the sum of all numbers from 1 to " + ogLimit + " is " + avg + ".");
        
    } // end of sumAndAverage method 
    
} // end of class

