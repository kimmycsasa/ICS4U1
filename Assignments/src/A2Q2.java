import java.util.*;
import java.io.*;

public class A2Q2 {
    public static void main(String[] args) throws IOException{
        
        Scanner input = new Scanner(System.in); // allows for user input 
        PrintWriter writer = new PrintWriter(new File("marks.txt"));
        
        boolean correctInput = false; // sets variable 'correctInput' to false
        String text = "";
        
        while(!correctInput){ // continues loop while it doesn't have the correct input 
            try{
                System.out.print("Enter the name of the file: "); 
                text = input.next(); // sets variable 'text' to the string a user inputs 
                readFile(text);
                correctInput = true; // ends loop 
                
            }
            
            catch(Exception e){ // if it catches an exception it restarts the program instead of crashing 
                input.nextLine(); // clears input buffer
                System.out.println("The file does not exist... try again (file should be a txt file e.g. nameOfFile.txt)");
                
            } // end of try catch statement 
        } // end of while loop
        
        ArrayList<String> firstName = new ArrayList<String>(); // creates a parallel array list to store first names 
        ArrayList<String> lastName = new ArrayList<String>(); // creates a parallel array list to store last names    
        
        ArrayList<String> textLines = new ArrayList<String>();
        textLines = readFile(text);
        
        for(int i = 0; i < 8; i++){ // executes the code 8 times (removes the headers in the file)
            textLines.remove(0); // removes the value at the first address of the array list
        } // end of for loop 
        
        for(int i = 0; i < textLines.size(); i = i + 6){ // goes through each address in the array list that contains first names 
            String name1 = textLines.get(i); // sets variable 'name1' to the value of 'textLines' at address i 
            firstName.add(name1); // adds value of 'name1' to 'firstName' array list
        }
        
        for(int i = 1; i < textLines.size(); i = i + 6){ // goes through each address in the array list that contains last names
            String name2 = textLines.get(i); // sets variable 'name2' to the value of 'textLines' at address i
            lastName.add(name2); // adds value of 'name2' to 'lastName' array list 
        }
        
        for(int i = 2; i < textLines.size(); i = i + 6){ // goes through all the art marks 
            writer.println(textLines.get(i));

        }
        
        for(int i = 3; i < textLines.size(); i = i + 6){ // goes through all the english marks 
            writer.println(textLines.get(i));

        }
        
        for(int i = 4; i < textLines.size(); i = i + 6){ // goes through all the science marks 
            writer.println(textLines.get(i));

        }

        for(int i = 5; i < textLines.size(); i = i + 6){ // goes through all the art marks 
            writer.println(textLines.get(i));

        }
        
        writer.close();
        
        Scanner reader = new Scanner(new File("marks.txt")); // creates a reader to read text from 'marks.txt' file 
        ArrayList<Integer> studentMarks = new ArrayList<Integer>(); // creates an array to store all the grades
        
        while(reader.hasNext()){ // goes through each line in the text file 
            int grade = reader.nextInt();  // stores an integer from the file into variable 'grade'
            studentMarks.add(grade); // adds the value of 'grade' to 'studentMarks' array list 
            
        }
        
        ArrayList<Integer> studentAvg = new ArrayList<Integer>(); // creates an array list to store each student's average mark
        ArrayList<Integer> courseAvg = new ArrayList<Integer>(); // creates an array list to store the average mark in each course
        
        studentAvg = studentAvg(studentMarks); // uses 'studentAvg' method 
        courseAvg = courseAvg(studentMarks); // uses 'courseAvg' method
        
        reportCard(textLines, studentAvg, courseAvg); // uses 'reportCard' method
        
        System.out.println("\nStudent report cards have been printed into your document files...");
        
    } // end of main 
    
    public static ArrayList<String> readFile(String text) throws IOException{
        
        Scanner reader = new Scanner(new File(text)); // creates a reader object to read file the user inputted
        
        ArrayList<String> textLines = new ArrayList<String>(); // creates an array list to store each line from the file 
        
        while(reader.hasNext()){ // goes through each line in the file 
            String word = reader.next(); // sets variable 'line' each line in the file
            textLines.add(word); // adds each line to 'textLines' array list 
            
        } // end of while loop        
        
        return textLines; // return 'textLines' array list 
        
    } // end of 'readFile' method 
   
    public static ArrayList<Integer> studentAvg(ArrayList<Integer> marks){ // creates a 'studentAvg' method that takes in an array list and outputs and array list (calculates and stores the averages of the students)
        
        ArrayList<Integer> averages = new ArrayList<Integer>(); // creates an array list to store the averages of each student 
        int indexCounter = 0; // creates a counter to keep track of what index is being used
        
        for(int i = 0; i < 20; i++){ // executes the code 20 times
            int mark = 0; // resets the initial total of a students mark to 0
        
            for(int j = 0; j < 4; j++ ){ // executes the code 4 times (for each subject)
                
                mark = mark + marks.get(indexCounter); // updates value of variable 'mark' to get the sum of their grades
                indexCounter = indexCounter + 20; // updates variable 'indexCounter' to find all the marks for one student 
                
            } // end of for loop  
            
            averages.add(mark/4); // adds the average of a students grades to the array list 
            indexCounter = i + 1; // updates counter to go to the next student 
            
        } // end of while loop  
        
        return averages; // returns 'averages' array list 
        
    } // end of 'studentAvg' method 
    
    public static ArrayList<Integer> courseAvg(ArrayList<Integer> marks){ // creates a 'courseAvg' method that takes in an array list and outputs an array list (caclulates the average grade in each course)
        
        ArrayList<Integer> averages = new ArrayList<Integer>(); // creates an array list to store the average mark in each course
        int avg; 
        int indexCounter = 0; // creates a counter to keep track of what index is being used
        
        for(int i = 0; i < 4; i++){ // executes the program 4 times (for each course)
            
            int sumGrades = 0; // resets the sum of the grades to 0 for each course 
            
            for(int j = 0; j < 20; j++){ // executes the program 20 times to go through each student's grade in a course
                
                sumGrades = sumGrades + marks.get(indexCounter); // updates the value of 'sumGrades' (calculates the sum of the student's grades in a course)
                indexCounter++; // increments counter
                
            } // end of for loop 
            
            avg = sumGrades / 20; // calculates the average mark in a course
            averages.add(avg); // adds the value of 'avg' to the array list 
            
        } // end of for loop 
        
        return averages; // returns 'averages' array list 
        
    } // end of 'courseAvg' method 
    
    public static void reportCard(ArrayList<String> textLines, ArrayList<Integer> studentAvg, ArrayList<Integer> courseAvg) throws IOException{ // creates a 'reportCard' method that takes in an array list of type string and two array lists of type integer (creates a file for each student with their grades)
        
        int indexCounter = 0; // creates a counter to keep track of each student 
        
        for(int i = 0; i < 20; i++){ // executes the code 20 times (makes separate files for each student)
            
            String fileName = textLines.get(indexCounter + 1); // sets variable 'fileName' to a students last name
            
            PrintWriter writer = new PrintWriter(new File(fileName + ".txt")); // creates a writer to print output to a file (sets file name as the students last name)
            
            // prints the students report card 
            writer.println("Student Name: " + textLines.get(indexCounter + 1) + ", " + textLines.get(indexCounter));
            writer.println("Average Mark: " + studentAvg.get(i));
            writer.println();
            writer.println("Course:        Final Mark:    Course Average:");
            writer.println("Math                " + textLines.get(indexCounter + 2) + "                " + courseAvg.get(0));
            writer.println("English             " + textLines.get(indexCounter + 3) + "                " + courseAvg.get(1));
            writer.println("Science             " + textLines.get(indexCounter + 4) + "                " + courseAvg.get(2));
            writer.println("Art                 " + textLines.get(indexCounter + 5) + "                " + courseAvg.get(3));
            
            indexCounter = indexCounter + 6; // updates counter to go to the next student
            
            writer.close();
            
        } // end of for loop 
        
    } // end of 'reportCard' method
    
} // end of class

