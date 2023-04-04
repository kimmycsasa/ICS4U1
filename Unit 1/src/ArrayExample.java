public class ArrayExample {
    public static void main(String[] args){
        
        String[] cards = new String[52]; // defines a String array with 52 elements (0-51)
        
        cards[0] = "Ace of Spades"; // assign value to array index 0 
        cards[1] = "Two of Spades";
        cards[2] = "Three of Spades";
        cards[51] = "King of Hearts";
        
        System.out.println(cards[51]); // [rints the value of index 
        
        // print all elements in an array 
        for(int i = 0; i < cards.length; i++){
            System.out.println(cards[i]);
            
        } // end of for loop 
        
        //prints all elements in array to "Joker"
        for(int i = 0; i < cards.length; i++){
            cards[i] = "Joker";
            System.out.println(cards[i]);
            
        } // end of for loop 
        
        int[] testScores = new int[5]; // int array with 5 elements 
        testScores[0] = 85;
        testScores[1] = 100;
        testScores[2] = 75;
        testScores[3] = 87;
        testScores[4] = 68;
        
        int sum = 0;
        
        for(int i =0; i < testScores.length; i++){
            sum = sum + testScores[i];
            
        } // end of for loop 
        
        System.out.println("The sum of your test scores is: " + sum);
        
    } // end of main 
    
} // end of class

