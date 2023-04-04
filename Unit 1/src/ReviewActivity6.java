import java.util.*;

public class ReviewActivity6 {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in); // allows for user input 
        
        System.out.println("Find the Sum of Integers between Two Integers");
        System.out.print("Enter the lowest integer: ");
        int lowest = input.nextInt(); // sets variable "lowest" to integer the user inputs
        System.out.print("Enter the highest integer: "); 
        int highest = input.nextInt(); // sets variable "highest" to integer the user inputs
        int sum = sumOfNums(lowest, highest); // sets variable "sum" to the value returned by "sumOfNums" method 
        System.out.println("The sum of integers from " + lowest + " to " + highest + " is " + sum + ".");
        
    } // end of main 
    
    public static int sumOfNums(int lowest, int highest){ // creates method called "sumOfNums" that takes in two integers and returns an integer
        
        int sum = 0;
        
        while(highest >= lowest){ // continues loop while variable "highest" has a greater or equal value to variable "lowest"
            
            sum = sum + highest; 
            highest--; // decrements the value of variable "highest"
            
        } // end of while loop 
        
        return sum; // returns value of variable "sum"
        
    } // end of "sumOfNums" method 
    
} // end of class


