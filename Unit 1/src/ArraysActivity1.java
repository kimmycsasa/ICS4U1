import java.util.*;

public class ArraysActivity1 {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        String[] course = new String[4];
        double[] mark = new double[4];
        double highestMark = -1;
        double lowestMark = 101;
        String highestCourse = "";
        String lowestCourse = "";
        
        System.out.println("Determine your Highest and Lowest Marks from 4 Courses");
        
        System.out.print("Enter your first course: ");
        course[0] = input.next();
        System.out.print("Enter your " + course[0] + " mark: ");
        mark[0] = input.nextDouble();

        System.out.print("Enter your second course: ");
        course[1] = input.next();
        System.out.print("Enter your " + course[1] + " mark: ");
        mark[1] = input.nextDouble();        

        System.out.print("Enter your third course: ");
        course[2] = input.next();
        System.out.print("Enter your " + course[2] + " mark: ");
        mark[2] = input.nextDouble();        

        System.out.print("Enter your fourth course: ");
        course[3] = input.next();
        System.out.print("Enter your " + course[3] + " mark: ");
        mark[3] = input.nextDouble();
        
        for(int i = 0; i < mark.length; i++){
            
            if(lowestMark > mark[i]){
                lowestMark = mark[i];
                lowestCourse = course[i];
                
            }
            
            else{
                
            } // end of if else statement 
            
        } // end of for loop 
        
        for(int i = 0; i < mark.length; i++){
            
            if(highestMark < mark[i]){
                highestMark = mark[i];
                highestCourse = course[i];
                
            }
            
            else{
                
            } // end of if else statement 
            
        } // end of for loop 
        
        System.out.println("Your highest mark was in " + highestCourse + "(" + highestMark + "%)" + "\nYour lowest mark was in " + lowestCourse + "(" + lowestMark + "%)");
        
    } // end of main 
    
} // end of class

