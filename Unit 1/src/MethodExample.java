public class MethodExample {
    public static void main(String[] args){
        
        double average = getAverage(75, 82, 94); // calls the "getAverage" method 
        System.out.println("The average is: " + average + ".");
        
        getAverage2(79, 85, 98); // calls getAverage2 method 
        
        int test1 = 67; 
        int test2 = 78; 
        int test3 = 82; 
        
        getAverage2(test1, test2, test3); // calls getAverage2 method using 3 variables 
        
    } // end of main 
    
    public static double getAverage(int mark1, int mark2, int mark3){
        
        double avg = 0.0; 
        avg = (mark1 + mark2 + mark3)/3.0; // calculates average of 3 marks
        return avg; // returns average
        
    } // end of getAverage method 
    
    public static void getAverage2(int mark1, int mark2, int mark3){
        
        double avg = 0.0;
        avg = (mark1 + mark2 + mark3)/3.0; // calculates the average of 3 marks
        System.out.println("The average is: " + avg); // prints the average
        
    } // end of getAverage2 method 
    
} // end of class
