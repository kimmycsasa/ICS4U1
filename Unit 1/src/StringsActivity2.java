import java.util.*;

public class StringsActivity2 {
    public static void main(String[] main){
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Would you like to remove the vowels of a word? (type 'yes' or 'no'): ");
        String answer = input.next();
        
        while(true){
        
            if(answer.equalsIgnoreCase("yes")){
                System.out.print("\nEnter a word: ");
                String word = input.next();
                System.out.println("Your string without vowels is: " + noVowels(word));
                System.out.print("\nWould you like to remove the vowels of a word? (type 'yes' or 'no'): ");
                answer = input.next();
            
            }
            
            else if(answer.equalsIgnoreCase("no")){
                System.out.println("\nYou exited the program...");
                break;
                
            }
            
            else{
                System.out.println("Invalid input... type 'yes' or 'no'.");
                System.out.print("\nWould you like to remove the vowels of a word? (type 'yes' or 'no'): ");
                answer = input.next();
                
            }

        }
        
    } // end of main 
    
    public static String noVowels(String word){
        
        int numChars = word.length() - 1;
        String newWord = "";
        
        for(int i = 0; i <= numChars; i++){
     
            int index = i;
            
            char value = word.charAt(i);
            
            if(value == 'a' || value == 'e' || value == 'i' || value == 'o' || value == 'u' || value == 'A' || value == 'E' || value == 'I' || value == 'O' || value == 'U'){
                
            }
            
            else{
                
                newWord = (newWord + value);
                
            } // end of if statement 
                
            
        } // end of for loop
        
        return newWord;
        
    } // end of method 'noVowels'
    
} // end of class
