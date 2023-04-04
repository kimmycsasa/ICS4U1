import java.util.*; // imports the java.util package

public class UserInputExample {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in); // allows for keyboard input \
        
        System.out.println("What is your age? "); // ask user for age 
        int age = input.nextInt(); // takes int from user 
        System.out.println("Your age is: " + age);
        
        System.out.println("What is your first name? "); 
        String firstName = input.next(); // take single word from user 
        System.out.println("Your first name is: " + firstName);
        
        input.nextLine(); // clears the input buffer to take in the next line from user 
        System.out.println("What is the date of your birthday? ");
        String dateOfBirth = input.nextLine(); // takes multiple words from user 
        System.out.println("Your date of birth is: " + dateOfBirth);
        
    } // end of main 
    
} // end of class
