import java.util.*;

public class RandomGenerator {
    public static void main(String[] args){
        
        Random generator = new Random();
        
        int randomValue;
        
        for(int i = 0; i < 10; i++){ // outputs 10 random integers from 1-10 
            randomValue = generator.nextInt(10)+1;
            System.out.println(randomValue);    
            
        } // end of for loop 
        
    } // end of main 
    
} // end of class

