public class CastingExample {
    public static void main(String[] args){
        
        double j = 3.2; 
        int i = (int)j; // cast the double 'j' into an integer value 
        System.out.println(i); // prints 3 
        double k = (double)i; // cast int 'i' into a double value 
        System.out.println(k); // print 3.0 
        
        int num1 = 10;
        int num2 = 3; 
        System.out.println(num1/num2); // integer division 
        System.out.println((double)num1/num2); // proper division 
        
    } // end of main 
    
} // end of class

