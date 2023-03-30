import java.util.*;

public class A1Q2 {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in); // allows for user input 
        Random generator = new Random(); // generates random numbers 
        
        System.out.print("Enter the number of rows in your 2D array: "); // asks user to enter an integer
        int numRows = input.nextInt(); // sets variable 'numRows' to the integer the user inputs 
        System.out.print("Enter the number of columns in your 2D array: "); // asks the user to enter an integer
        int numColumns = input.nextInt(); // sets variable 'numColumns' to the integer the user inputs 
        System.out.println(); 
        
        int[][] userArray = new int[numRows][numColumns]; // creates an array with the number of rows and colums the user inputted
        
        // goes through each address in the 2D array
        for(int i = 0; i < userArray.length; i++){ 
            for(int j = 0; j < userArray[i].length; j++){
                userArray[i][j] = generator.nextInt(100)+1; // fills the address with a random number from 0-100
                System.out.print(userArray[i][j] + " "); // prints out each value in a row
            }
            
            System.out.println(); // goes to next row 
            
        } // end of nested for loop
        
        while(true){ // shows this menu until the user exits the program
            System.out.println("\n1 - sum of 2D array\n2 - average of 2D array\n3 - maximum value in the 2D array\n4 - minimum value in the 2D array\n5 - sum of a row in the 2D array\n6 - sum of a column in the 2D array\n7 - number of instances of a value in the 2D array\n0 - exit"); // shows the options for the program 
            System.out.print("Enter your option: "); // tells the user to enter an integer
            int answer = input.nextInt(); // sets variable 'answer' to the integer the user inputs
            
            if(answer == 1){ // checks if user inputted 1
                System.out.println("\nThe sum of your 2D array is: " + calcSum(userArray)); // prints out the sum of the addresses in the array 
                
            }
            
            else if(answer == 2){ // chcecks if user inputted 2
                System.out.println("\nThe average of your 2D array is: " + calcAvg(userArray)); // prints out the average of the addresses in the array 
                
            }
            
            else if(answer == 3){ // checks if user inputted 3
                System.out.println("\nThe maximum value of your 2D array is: " + findMax(userArray)); // prints the highest value in the array
                
            }
            
            else if(answer == 4){ // checks if user inputted 4
                System.out.println("\nThe minimum value of your 2D array is: " + findMin(userArray)); // prints the lowest value in the array
                
            }
            
            else if(answer == 5){ // checks if user inputted 5 
                
                while(true){ // creates a continuous loop (in case user inputs invalid inputs this option will run again)
                    System.out.print("\nEnter a row number: "); 
                    int rowNum = input.nextInt(); // sets variable 'rowNum' to the integer a user inputs 
                    
                    if(rowNum > numRows || rowNum <= 0){ // checks for invalid inputs 
                        System.out.println("Invalid input... that row number does not exist.");
                        
                    }
                    
                    else{ // runs if they put a valid row number 
                        System.out.println("The sum of row " + rowNum + " is " + rowSum(userArray, rowNum)); // prints the sum of a row 
                        break; // breaks out of loop, goes back to main menu 
                    
                    } // end of if else statement 
                } // end of while loop 
                
            }
           
            else if(answer == 6){ // checks if user inputted 6 
                
                while(true){ // creates a continuous loop (in case user inputs invalid inputs this option will run again)
                    System.out.print("\nEnter a column number: ");
                    int colNum = input.nextInt(); // sets variable 'colNum' to the integer a user inputs 
                    
                    if(colNum > numColumns || colNum <= 0){ // checks for invalid inputs 
                        System.out.println("Invalid input... that column number does not exist.");
                        
                    }
                    
                    else{ // runs if they put a valid column number 
                        System.out.println("The sum of column " + colNum + " is " + colSum(userArray, colNum)); // prints the sum of a column
                        break; // breaks out of loop; goes back to main menu 
                        
                    } // end of if else statement 
                } // end of while loop 
                
            }
            
            else if(answer == 7){ // checks if user inputted 7
                System.out.print("\nEnter a number: ");
                int num = input.nextInt(); // sets variable 'num' to the integer a user inputs 
                System.out.println(num + " appears " + countInstances(userArray, num) + " time(s) in your array."); // prints the number of times their number appears in the array 
                
            }
            
            else if(answer == 0){ // checks if user inputted 0 
                System.out.print("You exited the program...");
                break; // breaks while loop 
                
            }
            
            else{ // runs if user doesn't put a valid integer
                System.out.println("Invalid input... select a number corresponding to a designated option.");
                
            } // end of if else statement 
            
        } // end of while loop 
        
    } // end of main
    
    //takes in a 2D array of type int and outputs the sum of the addresses as type int
    public static int calcSum(int array[][]){
        int sum = 0; // sets variable 'sum' to 0
        
        // goes through each address in array and adds the value to the existing value of variable 'sum'
        for(int i = 0; i < array.length; i++){ 
            for(int j = 0; j < array[i].length; j++){
                sum = sum + array[i][j];
                
            }
        } // end of nested for loop 
        
        return sum; // returns value of 'sum' 
        
    } // end of method 'calcSum'
    
    // takes in a 2D array of type int and outputs the average of the addresses as type int
    public static double calcAvg(int array[][]){
        int numAddresses = 0;// sets variable 'numAddresses' to 0 (counter for number of addresses)
        int sum = 0; // sets variable 'sum' to 0 
        double average; // declares double variable called 'average'
        
        // goes through each address in array to calculate the sum of all the values
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                sum = sum + array[i][j];
                numAddresses++; // increments counter by 1
                
            }
        } // end of nested for loop 
        
        average = sum / (double)numAddresses; // calculates the average of the 2D array
        return average; // retruns the value of variable 'avaerage'
        
    } // end of method 'calcAvg'
    
    // takes in a 2D array of type int and outputs the highest number found in the array as type int 
    public static int findMax(int array[][]){
        int max = 0; // sets variable 'max' to 0 
        
        // goes through each address in the array
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                
                if(array[i][j] > max){ // checks if value at the address is higher than the value of variable 'max'
                    max = array[i][j]; // sets variable 'max' equal to the value at the current address
                    
                }
                
                else{ // runs if value at address is lower than variable max
                
                } // end of if else statement 
                
            }
        } // end of nested for loop 
        
        return max; // returns value of variable 'max'
        
    } // end of method 'findMax'
    
    // takes in a 2D array of type int and outputs the lowest number found in the array as type int 
    public static int findMin(int array[][]){
        int min = 101; // sets variable 'min' to 101
        
        // goes through each address in the array 
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                
                if(array[i][j] < min){ // checks if value at address is lower than value of variable 'min'
                    min = array[i][j]; // sets variable 'min' to the value of the address
                    
                }
                
                else{ // runs if value at address is higher than variable 'min'
                    
                } // end of if else statement 
                
            }
        } // end of nested for loop 
        
        return min; // returns value of variable 'min'
        
    } // end of method 'findMin'
    
    // takes in 2D array of type int and an integer for the row number, then outputs the sum of the addresses of the row as type int 
    public static int rowSum(int array[][], int rowNum){
        int sum = 0; // sets variable 'sum' to 0 
        
        for(int i = 0; i < array[rowNum - 1].length; i++){ // goes through each address in a row number (subtracting 1 because the rows start at index 0)
            sum = sum + array[rowNum - 1][i]; // calculates the sum of the row number
            
        } // end of for loop 
        
        return sum; // returns the vlaue of variable 'sum'
        
    } // end of method 'rowSum'
    
    // takes in 2D array of type int and an integer for the column number, then outputs the sum of the addresses of the column as type int
    public static int colSum(int array[][], int colNum){
        int sum = 0; // sets variable 'sum' to 0 
        
        for(int i = 0; i < array.length; i++){ // goes through each address in a column number (subtracting 1 because the columns start at index 0)
            sum = sum + array[i][colNum - 1]; // calculates the sum of the column number 
            
        } // end of for loop 
        
        return sum; // returns value of variable 'sum'
        
    } // end of method 'colSum'
    
    // takes in a 2D array of type int and an integer, then outputs the amount of times the integer shows up in the array
    public static int countInstances(int array[][], int num){
        int counter = 0; // sets variable 'counter' to 0 
        
        // goes through each address in the array 
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                
                if(array[i][j] == num){ // checks if value of address equals the number entered by the user
                    counter++; // increments counter
                    
                }
                
                else{ // runs if value of address doesn't equal the number entered by the user
                    
                } // end of if else statment 
                
            }
        } // end of nested for loop 
        
        return counter; // returns value of variable 'counter'
        
    } // end of method 'countInstances'
    
} // end of class

