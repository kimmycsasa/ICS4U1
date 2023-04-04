import java.util.*;

public class MathExample {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in); // allows for keyboard input 
        
        System.out.print("Enter a number: ");
        double num = input.nextDouble();
        
        System.out.println("The absolute value of " + num + " is: " + Math.abs(num));
        System.out.println("The sqare root of " + num + " is: " + Math.sqrt(num));
        System.out.println("The quartic value of " + num + " is " + Math.pow(num, 4));
        
    } // end of main 
    
} // end of class

