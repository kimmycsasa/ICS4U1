import java.util.*;

public class ReviewActivity2 {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your first number: ");
        double num1 = input.nextDouble();
        System.out.print("Enter your second number: ");
        double num2 = input.nextDouble();
        System.out.print("Enter your third number: ");
        double num3 = input.nextDouble();
        
        double lowest, middle, greatest;
        
        if(num1>num2 && num1>num3){ // checks if num1 is the largest number
            greatest = num1;
            
            if(num2>num3){ // checks if num2 is greater than num3
                middle = num2;
                lowest = num3;
                
            }
            
            else{ // means that num3 is greater than num2
                middle = num2;
                lowest = num3;
            } // end of if-else statement 
            
        } 
        
        else if(num2>num1 && num2>num3){ // checks if num2 is the largest number
            greatest = num2;
            
            if(num1>num3){
                middle = num1;
                lowest = num3;
                
            }
            
            else{
                middle = num3;
                lowest = num1;
                
            } // end of if-else statement 
            
        }
        
        else{ // means that num3 is the largest number
            greatest = num3;
            
            if(num1>num2){
                middle = num1;
                lowest = num2;
                
            }
            
            else{
                middle = num2;
                lowest = num1;
                
            } // end of if-else statement 
        } // end of if-else statement 
        
        System.out.println("Your numbers ordered from least to greatest are: " + lowest + ", " + middle + ", " + greatest);
        
    } // end of main 
    
} // end of class

