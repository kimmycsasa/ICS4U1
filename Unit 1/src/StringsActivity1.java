import java.util.*;

public class StringsActivity1 {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in); // allows for keyboard input 
        
        System.out.print("Do you want to find the hypotenuse of a triangle? (type 'yes' or 'no'): ");
        String answer = input.next();
        
        while(true){ // loop continues forever
        
        if(answer.equalsIgnoreCase("yes")){
            
            System.out.print("Enter the value of side 'a' (has to be greater than 0): ");
            double a = input.nextDouble();
            
            if(a > 0){
                
                while(a > 0){
    
                System.out.print("Enter the value of side 'b' (has to be greater than 0): ");
                double b = input.nextDouble();
                
                if(b > 0){
                    
                    double hyp = calcHyp(a, b);
                    System.out.println("The hypotenuse of your triangle is: " + hyp);
            
                    System.out.print("Do you want to find the hypotenuse of a triangle? (type 'yes' or 'no'): ");
                    answer = input.next();
                
                    break;
                
                }
                
                else{
                    System.out.println("Invalid input... enter a number greater than 0.");
                    
                }
                
                }
                
            }
            
            else{
                System.out.println("Invalid input... enter a number greater than 0.");
                answer = "yes";
                
            } // end of if else statement 
            
        }
        
        else if(answer.equalsIgnoreCase("no")){ // checks if user inputted 'no'
            System.out.println("You exited the program...");
            break; // breaks loop 
        }
        
        else{ // runs if user puts an invalid answer i.e. anything but 'yes' or 'no'
            System.out.println("Invalid input... type 'yes' or 'no'.");
            System.out.print("Do you want to find the hypotenuse of a triangle? (type 'yes' or 'no'): ");
            answer = input.next(); 
            
        } // end of if else statement 
        
        } // end of while statement 
        
    } // end of main 
    
    public static double calcHyp(double a, double b){
        
        double hyp = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        
        return hyp;
        
    } // end of method 'calcHyp'
    
} // end of class
