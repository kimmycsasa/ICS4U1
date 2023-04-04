public class StringExample {
    public static void main(String[] args){
        
        String name = "Reyes";
        System.out.println(name.length()); // returns length of string 
        
        String end = name.substring(2, 5);
        System.out.println(end); // prints 'yes' 
        
        char letter = name.charAt(4); // char at index 4 
        System.out.println(letter);
        
        System.out.println(name.indexOf('e')); // returns the index of the first instance of 'e' 
        
    } // end of main 
    
} // end of class 

