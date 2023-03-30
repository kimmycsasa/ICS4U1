import java.util.*; 

public class A0Q1 {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in); // allows for user input 
        
        System.out.println("1 - Solve Quadratic Equation\n0 - Exit"); // asks the user if they want to use the program 
        int answer = input.nextInt(); // sets variable 'answer' to the integer the user inputs        
        
        while(true){ // continues loop forever 
            
            double a, b, c; // declares variables of type double named 'a', 'b', and 'c'
            
            if(answer == 1){ // checks if user inputted 1 
                System.out.print("\nEnter the 'a' value (cannot be equal to 0): "); 
                a = input.nextDouble(); // sets variable 'a' to the integer the user inputs 
                
                if(a != 0){ // checks if variable 'a' doesn't equal 0 
                
                System.out.print("Enter the 'b' value: ");
                b = input.nextDouble(); // sets variable 'b' to the integer the user inputs 
                System.out.print("Enter the 'c' value: ");
                c = input.nextDouble(); // sets variable 'c' to the integer the user inputs 
                
                quadEq(a, b, c); // uses method 'quadEq' to calculate the solution to the quadratic equation the user inputted 
                
                System.out.println("\n1 - Solve Quadratic Equation\n0  - Exit"); // asks if they want to solve another quadratic equation 
                answer = input.nextInt(); 
                
                }
                
                else{ // runs program if user enters 0 for variable 'a' 
                    System.out.println("Invalid input... the number cannot equal 0.");
                    answer = 1; // goes back to the first condition of the if statement i.e. asks again for the 'a' value 
                            
                }
                
            }
            
            else if(answer == 0){ // checks if user inputted 0
                System.out.println("\nYou exited the program...");
                break; // breaks loop 
                
            }
            
            else{ // runs program if user neither puts 1 or 0
                System.out.println("\nInvalid input... enter 1 or 0."); 
                System.out.println("1 - Solve Quadratic Equation\n0 - Exit");
                answer = input.nextInt();                 
                
            } // end of if else statement 
            
        } // end of while loop 
        
    } // end of main 
    
    public static void quadEq(double a, double b, double c){ // creates a method called 'quadEq' that takes in 3 doubles as values of a quadratic equation and finds its solutions
        double x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a); // calculates a zero of the quadratic equation using +sqrt
        double x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a); // calculates a zero of the quadratic equation using -sqrt
        
        System.out.println("\nSolutions:"); // prints out the solutions of the quadratic equation
        System.out.println("x1 = " + x1);
        System.out.println("x2: " + x2);
        
    } // end of 'quadEq' method 
    
} // end of class

