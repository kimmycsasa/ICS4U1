import java.util.*;

public class ArraysActivity2 {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        Random generator = new Random();
        
        int[] numbers = new int[50];
        
        for(int i = 0; i < numbers.length; i++){
            
            numbers[i] = generator.nextInt(100)+1;
            
        } // end of for loop 
        
        System.out.print("Enter a number between 1 and 10: ");
        int den = input.nextInt();
        
        System.out.println("The numbers divisible by " + den + " are: ");
        
        for(int i = 0; i < numbers.length; i++){
            
            if(numbers[i]%den == 0){
                
                System.out.println(numbers[i]);
                
            }
            
            else{
                
            } // end of if else statement 
            
        } // end of for loop 
        
    } // end of main 
    
} // end of class

