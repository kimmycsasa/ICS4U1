import java.util.*; 
import java.io.*; 

public class A2Q1 {
    public static void main(String[] args) throws IOException{
        
        Scanner input = new Scanner(System.in); // allows for user input 
        String text = "";
        
        boolean correctInput = false; // sets a flag to check if the program is given the correct input 
        
        while(!correctInput){ // executes program until the program is given a valid input 
            try{
                System.out.print("Enter the name of the file you want to read: ");
                text = input.next(); // sets variable 'text' to the string the user inputs 
                readFile(text); // uses method 'readFile' to see if their inputted file is valid 
                correctInput = true; // exits the loop 

            }
        
            catch(Exception e){ // if it catches an exception it restarts the program instead of crashing 
                input.nextLine(); // clears input buffer
                System.out.println("The file does not exist... try again (file should be a txt file e.g. nameOfFile.txt)");
            
            } // end of try catch statement 
        } // end of while loop 
        
        ArrayList<Integer> numChars = new ArrayList<Integer>(); // creates a new array list called numChars
        numChars = frequencies(readFile(text)); // sets variable 'numChars' to the array list outputted by the 'frequencies' method 
        printFrequencies(numChars); // calls on method 'printFrequencies' 
        
        System.out.println("\nThe frequencies of each letter are printed in a document file...");
        
    } // end of main 
    
    public static ArrayList<String> readFile(String text) throws IOException{ // creates 'readFile' method that takes in a string and outputs an array list of type string (reads file and inputs the lines into an array list)
        
        Scanner reader = new Scanner(new File(text)); // creates a reader object that can read text from a file 

        ArrayList<String> textLines = new ArrayList<String>(); // creates an array list called 'textLines' to store each line from the text 
        
        while(reader.hasNext()){ // goes through each line in the text 
            String line = reader.nextLine(); // sets variable 'line' equal to the line from the file 
            textLines.add(line); // adds line to array list 'textLines'
            
        } // end of while loop
        
        return textLines; // returns array list 'textLines' 
        
    } // end of 'readFile' method 
    
    public static ArrayList<Integer> frequencies(ArrayList<String> characters){ // creates a method called 'frequencies' that takes in an array list of type string and returns and array list of type integer (records the number of instances of each letter)
        
        int[] numChars = new int[26]; // creates an array with 26 addresses to store the letters (used as a parallel array for the frequencies)
        ArrayList<Integer> frequency = new ArrayList<Integer>(); // creates an array list called 'frequency' to store the instances of each letter
        
        for(int i = 0; i < numChars.length; i++){ // goes through each address in 'numChars' array 
            numChars[i] = 0; // sets each address to 0
            
        }
        
        for(int i = 0; i < characters.size(); i++){ // goes through each address in the array list inputted in the parameteres
            String line = characters.get(i); // sets variable 'line' to the value at each index 
            
            for(int j = 0; j < line.length(); j++){ // goes through each character from the line of text 
                char letter = line.charAt(j); // sets variable 'letter' to the character found at index j in the string
                
                // checks which letter the character corresponds to (or if it's not a letter) and updates the frequency of that letter
                if(letter == 'A' || letter == 'a'){
                    numChars[0] = numChars[0] + 1;  
                }
                
                else if(letter == 'B' || letter == 'b'){
                    numChars[1] = numChars[1] + 1;
                }
                
                else if(letter == 'C' || letter == 'c'){
                    numChars[2] = numChars[2] + 1;
                }
                
                else if(letter == 'D' || letter == 'd'){
                    numChars[3] = numChars[3] + 1;
                }
                
                else if(letter == 'E' || letter == 'e'){
                    numChars[4] = numChars[4] + 1;
                }
                
                else if(letter == 'F' || letter == 'f'){
                    numChars[5] = numChars[5] + 1;
                }
                
                else if(letter == 'G' || letter == 'g'){
                    numChars[6] = numChars[6] + 1;
                }
                
                else if(letter == 'H' || letter == 'h'){
                    numChars[7] = numChars[7] + 1;
                }
                
                else if(letter == 'I' || letter == 'i'){
                    numChars[8] = numChars[8] + 1;
                }
                
                else if(letter == 'J' || letter == 'j'){
                    numChars[9] = numChars[9] + 1;
                }
                
                else if(letter == 'K' || letter == 'k'){
                    numChars[10] = numChars[10] + 1;
                }
                
                else if(letter == 'L' || letter == 'l'){
                    numChars[11] = numChars[11] + 1;
                }
                
                else if(letter == 'M' || letter == 'm'){
                    numChars[12] = numChars[12] + 1;
                }
                
                else if(letter == 'N' || letter == 'n'){
                    numChars[13] = numChars[13] + 1;
                }
                
                else if(letter == 'O' || letter == 'o'){
                    numChars[14] = numChars[14] + 1;
                }
                
                else if(letter == 'P' || letter == 'p'){
                    numChars[15] = numChars[15] + 1;
                }
                
                else if(letter == 'Q' || letter == 'q'){
                    numChars[16] = numChars[16] + 1;
                }
                
                else if(letter == 'R' || letter == 'r'){
                    numChars[17] = numChars[17] + 1;
                }
                
                else if(letter == 'S' || letter == 's'){
                    numChars[18] = numChars[18] + 1;
                }
                
                else if(letter == 'T' || letter == 't'){
                    numChars[19] = numChars[19] + 1;
                }
                
                else if(letter == 'U' || letter == 'u'){
                    numChars[20] = numChars[20] + 1;
                }
                
                else if(letter == 'V' || letter == 'v'){
                    numChars[21] = numChars[21] + 1;
                }
                
                else if(letter == 'W' || letter == 'w'){
                    numChars[22] = numChars[22] + 1;
                }
                
                else if(letter == 'X' || letter == 'x'){
                    numChars[23] = numChars[23] + 1;
                }

                else if(letter == 'Y' || letter == 'y'){
                    numChars[24] = numChars[24] + 1;
                }
                
                else if(letter == 'Z' || letter == 'z'){
                    numChars[25] = numChars[25] + 1;
                }
                
                else{   
                } // end of if else statement 
            } // end of for loop 
        } // end of for loop 
        
        for(int j = 0; j < numChars.length; j++){ // goes through each address in 'numChars' 
            frequency.add(numChars[j]); // adds the value of an index from 'numChars' and adds it to the 'frequency' array list 
   
        } // end of for loop 
        
        return frequency; // returns array list 'frequency' 
        
    } // end of 'frequencies' method
    
    public static void printFrequencies(ArrayList<Integer> frequencies) throws IOException{
        
        PrintWriter writer = new PrintWriter(new File("frequencies.txt")); // creates a writer object that can print outputs to a file 
        ArrayList<String> letters = new ArrayList<String>(); // creates a parallel array list called 'letters' 
        
        // sets the values of the parallel array list equal to their correspondening letters 
        letters.add("A = ");
        letters.add("B = ");
        letters.add("C = ");            
        letters.add("D = ");        
        letters.add("E = ");        
        letters.add("F = ");
        letters.add("G = ");
        letters.add("H = ");
        letters.add("I = ");
        letters.add("J = ");
        letters.add("K = ");
        letters.add("L = ");
        letters.add("M = ");
        letters.add("N = ");
        letters.add("O = ");
        letters.add("P = "); 
        letters.add("Q = ");
        letters.add("R = ");
        letters.add("S = ");
        letters.add("T = ");
        letters.add("U = ");
        letters.add("V = ");
        letters.add("W = ");
        letters.add("X = ");
        letters.add("Y = ");
        letters.add("Z = ");  
        
        for(int i = 0; i < letters.size(); i++){ // prints out the frequencies of each letter in alphabetical order 
            writer.print(letters.get(i) + frequencies.get(i) + " ");
            
        }
        
        int k = 0; 
        boolean exchangeMade = true; // sets condition as true (checks to see if any values were switched to check if the array list is sorted)
        
        while((k < frequencies.size()- 1) && exchangeMade){ // continues loop if the array list isn't sorted
            exchangeMade = false; // updates condition to false
            k++; // increments variable 'k'
            
            for(int j = 0; j < frequencies.size() - k; j++){ // compares the values at each address
                if(frequencies.get(j) > frequencies.get(j+1)){ // runs program if the value at the address is greater than the value at the next address
                    int num1 = frequencies.get(j); // sets variable 'num1' to the original value at the address of the array list 
                    int num2 = frequencies.get(j+1); // sets variable 'num2' to the original value at the address of the array list 
                    frequencies.set(j+1, num1); // swaps the values
                    frequencies.set(j, num2); // swaps the values
                    
                    String char1 = letters.get(j); // sets variable 'char1' to the original value at the address of the array list 
                    String char2 = letters.get(j+1); // sets variable 'char2' to the original value at the address of the array list 
                    letters.set(j+1, char1); // swaps the values 
                    letters.set(j, char2); // swaps the values 
                    
                    exchangeMade = true; // updates condition to true
                    
                } // end of if statement 
            } // end of for loop 
            
        } // end of while loop 
        
        writer.println("\n\nBottom 5 Letters: "); // prints output to a file 
        
        for(int i = 4; i >= 0; i--){ // goes through the 5 values at the beginning of the array list 
            writer.println(letters.get(i) + frequencies.get(i)); // prints out the bottom 5 letters and ther frequencies to a file 
            
        }
        
        writer.println("\nTop 5 Letters: "); // prints output to a file 
        
        for(int i = 25; i > 20; i--){ // goes through the 5 values at the end of the array list 
            writer.println(letters.get(i) + frequencies.get(i)); // prints out the top 5 letters and their frequencies to a file
            
        } // end of for loop 
        
        writer.close(); 
        
    } // end of 'printFrequencies' method 
     
} // end of class
