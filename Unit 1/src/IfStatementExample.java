import java.util.*;

public class IfStatementExample {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("What is your age? ");
        int age = input.nextInt(); // takes integer from user 
        
        if (age<18){ // if the age is under 18 
            System.out.println("Sorry, you are too young to watch this movie.");
            
        }
        
        else{ // if the age is 18 or older
            System.out.println("Enjoy the show!");
            
        } // end of if-else statement 
        
    } // end of main 
    
} // end of class

