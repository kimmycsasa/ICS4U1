import java.util.*;

public class BooleanExample {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in); // allows for keyboard input 
        
        System.out.print("What is your age?: ");
        int age = input.nextInt();
        
        System.out.print("What is your first name?: ");
        String firstName = input.next();
        
        if(age == 40 && firstName.equalsIgnoreCase("Rodolfo")){
            System.out.println("You must be the teacher.");
            
        }
        
        else if(age <= 18 && age > 16 && !firstName.equalsIgnoreCase("Rodolfo")){
            System.out.println("You must be a student.");
            
        }
        
        else{
            System.out.println("I'm not sure who you are.");
            
        }
        
    } // end of main 
    
} // end of class

