import java.util.*; 
import java.io.*; 

public class A3Q1 {
    public static void main(String[] args) throws IOException{
        
        Scanner input = new Scanner(System.in); // allows for user input 
        boolean correctInput = false; 
        String file = ""; 
        
        while(!correctInput){
            try{ // checks if file exists 
                System.out.print("Enter the file name you want to read: "); 
                file = input.next(); 
                readFile(file); // reads user given file 
                correctInput = true; 
            
            }
            
            catch(Exception e){
                input.nextLine(); // clears input buffer 
                System.out.println("Couldn't find the file... try again (should be name.txt file)"); 
                
            } // end of try catch statement 
        
        } // end of while loop 
        
        ArrayList<Account> accounts = new ArrayList<Account>(); // creates an Account arry list to store all accounts
        accounts = readFile(file); // assign the array list the 'readFile' method returns to 'accounts' array list 
        
        while(true){
            System.out.print("1: create a new account\n2: get account balance\n3: deposit amount\n4: withdraw amount\n5: transfer funds to other account\n6: print account info\n7: export listing of all accounts (numerically ordered)\n8: export listing of all accounts (alphabetically ordered)\n0: exit\n");
            boolean correctInput2 = false; // creates a flag to check if the user puts correct input 
            int answer = -1;
            
            while(!correctInput2){
                try{ // checks if user inputted an integer 
                    System.out.print("\nEnter the option number: ");
                    answer = input.nextInt(); 
                
                    if(answer == 0 || answer == 1 || answer == 2 || answer == 3 || answer == 4 || answer == 5 || answer == 6 || answer == 7 || answer == 8){ // checks if user chooses a valid option number 
                        correctInput2 = true; 
                    }
                
                    else{
                        input.nextLine(); // clears input buffer
                        System.out.println("incorrect input... can only use numbers 0-8... try again...\n");
                        
                    } // end of if else statement 
            
                }
            
                catch(Exception e){
                    input.nextLine(); // clears input buffer
                    System.out.println("incorrect input... not an integer... try again...\n");
                
                } // end of try catch statement
            } // end of while loop 
            
            if(answer == 0){
                System.out.println("you exited the program..."); 
                break; // exits the program 
            }
            
            int numOfAcc = 999999; // creates a variable for the value of account numbers
            
            if(answer == 1){
                System.out.print("\nEnter your first name: ");
                String n1 = input.next(); 
                System.out.print("Enter your last name: "); 
                String n2 = input.next(); 
                
                while(true){ // continues loop to find unused numbers for the account number
                    
                int available = linearSearch(accounts, numOfAcc); // uses 'linearSearch' method to see if the account number already exists 
                
                    if(available == -1){ // runs if account number does not exist
                        Account newAcct = new Account(n1, n2, numOfAcc, 0); // sets account information to user given information 
                        accounts.add(newAcct); // adds account information to 'accounts' array list 
                        System.out.println("new account created...\n"); 
                        System.out.println(newAcct.toString() + "\n"); 
                        numOfAcc--; // changes account number because the account number is used 
                        break; // breaks loop once it finds an available account number
                    }
                
                    else{ 
                        numOfAcc--; // changes account number because the account number is used 
                    } // end of if else statement 
                } // end of while loop     
            }
            
            if(answer == 2){
                boolean correctInput3 = false;
                
                while(!correctInput3){
                    try{ // checks if account number exists 
                        System.out.print("\nEnter the account number: "); 
                        int accNum = input.nextInt(); 
                        int index = linearSearch(accounts, accNum); // searches the array for the account number 
                        Account account = accounts.get(index); // sets account information to a temporary variable 
                        System.out.println("\nBalance: $" + account.getBalance() + "\n"); // prints the balance of the account 
                        correctInput3 = true;
                    }
                
                    catch(Exception e){
                        input.nextLine(); // clears input buffer
                        System.out.println("the account does not exist... try again...\n"); 
                    } // end of try catch statement 
                } // end of while loop 
            }
            
            if(answer == 3){
                boolean correctInput4 = false; 
                
                while(!correctInput4){
                    try{ // checks if account exists 
                        System.out.print("\nEnter the account number: "); 
                        int accNum = input.nextInt(); 
                        int index = linearSearch(accounts, accNum); // searches the array for the account number 
                        Account account = accounts.get(index); // sets account information to a temporary variable 
                        double deposit = 0; 
                        
                        boolean correctInput5 = false; 
                        while(!correctInput5){ 
                            try{ // checks if user inputs a number 
                                while(true){
                                    System.out.print("Enter the amount you would like to deposit: "); 
                                    deposit = input.nextDouble(); 
                            
                                    if(deposit >= 0){ // checks if the user inputs a valid amount 
                                        break;
                                    }
                            
                                    else{ // runs if the user puts a negative number 
                                        input.nextLine(); // clears input buffer
                                        System.out.println("cannot deposit a negative number... try again...\n"); 
                                    } // end of if else statement 
                                } // end of while looop 
                                
                                correctInput5 = true; 
                            }
                            
                            catch(Exception e){
                                input.nextLine(); // clears input buffer
                                System.out.println("that is not a number... try again\n"); 
                            } // end of try catch statement 
                        
                        } // end of while loop 
                        
                        System.out.println("Initial Balance: $" + account.getBalance());
                        account.deposit(deposit); // adds funds to an account 
                        System.out.println("New Balance: $" + account.getBalance() + "\n"); 
                        accounts.set(index, account); // update account information in the array list 
                        correctInput4 = true; 
                        
                    }
                    
                    catch(Exception e){
                        input.nextLine(); // clears input buffer
                        System.out.println("the account does not exist... try again...\n"); 
                    } // end of try catch statement    
                } // end of while loop     
            }
            
            if(answer == 4){
                boolean correctInput6 = false; 
                
                while(!correctInput6){
                    try{ // checks if account number exists
                        System.out.print("\nEnter the account number: "); 
                        int accNum = input.nextInt(); 
                        int index = linearSearch(accounts, accNum); // searches array for account number
                        Account account = accounts.get(index); // sets account information to temporary variable 
                        double withdrawal = 0; 
                        
                        boolean correctInput7 = false; 
                        while(!correctInput7){
                            try{ // checks if user inputs a number 
                                while(true){
                                    System.out.print("Enter the amount you would like to withdraw: "); 
                                    withdrawal = input.nextDouble(); 
                            
                                    if(withdrawal > 0){ // if they withdraw a valid number
                                        System.out.println("Initial Balance: $" + account.getBalance());
                                        account.withdraw(withdrawal); // withdraws money from account 
                        
                                        if (account.getBalance() < 0){ // checks if they don't have enough money 
                                            input.nextLine(); // clears input buffer
                                            System.out.println("insufficient funds... try again...\n");
                                            account.setBalance(account.getBalance() + withdrawal); //resets balance to original balance 
                                
                                        }
                            
                                        else{
                                            break;
                                        } //end of if else statement 

                                    
                                    }
                            
                                    else{ // resets loop if they enter a negative value 
                                        input.nextLine(); // clears input buffer
                                        System.out.println("cannot withdraw a negative number... try again...\n"); 
                                    } // end of if else statement 
                                } // end of while looop 
                                
                                correctInput7 = true; 

                            }
                            
                            catch(Exception e){
                                input.nextLine(); // clears input buffer 
                                System.out.println("that is not a number... try again\n"); 
                            } // end of try catch statement 
                        
                        } // end of while loop 
                        
                        System.out.println("New Balance: $" + account.getBalance()); 
                        accounts.set(index, account); // updates account information at the index 
                        correctInput6 = true; 
               
                    }
                    
                    catch(Exception e){
                        input.nextLine(); // clears input buffer 
                        System.out.println("the account does not exist... try again...\n"); 
                    } // end of try catch statement    
                } // end of while loop            
            }
            
            if(answer == 5){
                boolean correctInput8 = false; 
                int index = -1;
                int index2 = -1; 
                Account account = new Account(); 
                Account account2 = new Account(); 
                
                while(!correctInput8){
                    try{ // checks if the account number exists 
                        System.out.print("\nEnter the account number: "); 
                        int accNum = input.nextInt(); 
                        index = linearSearch(accounts, accNum); // searches array for account number 
                        account = accounts.get(index); // sets account information in a temporary variable 
                        
                        boolean correctInput9 = false; 
                        
                        while(!correctInput9){
                            try{
                                System.out.print("Enter the account you want to transfer funds to: "); 
                                int accNum2 = input.nextInt(); 
                                index2 = linearSearch(accounts, accNum2); // searches array for account number 
                                account2 = accounts.get(index2); // sets account information in a temporary variable 
                                correctInput9 = true; 
                                
                            }
                            
                            catch(Exception e){ 
                                input.nextLine(); // clears input buffer
                                System.out.println("that account does not exist... try again...\n");  
                                
                            } // end of try catch statement 
                        } // end of while loop 
                        
                        boolean correctInput10 = false; 
                        
                        while(!correctInput10){
                            try{ // checks if a number is inputted 
                                System.out.print("Enter the amount you want to transfer: "); 
                                double amount = input.nextDouble(); 
                                
                                if(amount >= 0){
                                    account.transfer(amount, account2); // transfers money from 'account' to 'account2' 
                                    
                                    if(account.getBalance() < 0){ // checks if there is not enough funds in account 
                                        account.setBalance(account.getBalance() + amount); // resets account balance to original balance 
                                        account2.setBalance(account2.getBalance() - amount); // resets account balance to originaal balance 
                                        input.nextLine(); // clears input buffer
                                        System.out.println("insufficient funds... try again...\n");
                                    }
                                    
                                    else{
                                        // updates the information of the accounts in the array list 
                                        accounts.set(index, account); 
                                        accounts.set(index2, account2);
                                        correctInput10 = true; 
                                    }
                                }
                                
                                else{
                                    System.out.println("can't transfer a negative amount... try again...\n"); 
                                } // end of if else statement 
                            }
                            
                            catch(Exception e){
                                input.nextLine(); // clears input buffer 
                                System.out.println("that is not a number... try again...\n"); 
                            } // end of try catch statement 
                        
                            correctInput8 = true; 
                        } // end of while loop 
                    }
                    
                    catch(Exception e){ // resets the while loop 
                        input.nextLine(); // clears input buffer
                        System.out.println("the account does not exist... try again...\n"); 
                        
                    } // end of try catch statement 
                } // end of while loop 
                
                System.out.println("funds have been transferred...\n"); 
               
            }
            
            if(answer == 6){
                boolean correctInput9 = false; 
                
                while(!correctInput9){
                    try{ // checks if the account number exists
                        System.out.print("\nEnter the account number: "); 
                        int accNum = input.nextInt(); 
                        int index = linearSearch(accounts, accNum); // searches array for account number 
                        Account account = accounts.get(index); // sets account information in a temporary variable 
                        System.out.println("\n" + account.toString() + "\n"); // prints account information 
                        correctInput9 = true; 
                    
                    }
                
                    catch(Exception e){ // resets the while loop 
                        input.nextLine(); // clears input buffer
                        System.out.println("the account does not exist... try again...\n"); 
                    } // end of try catch statement 
                } // end of while loop 
            }
            
            if(answer == 7){
                PrintWriter writer = new PrintWriter(new File("accounts_num.txt")); // outputs information into a txt file called 'accounts_num'
                bubbleSort(accounts); // sorts accounts from least to greatest account number 
                
                for(int i = 0; i < accounts.size(); i++){ // goes through the whole array list 
                    Account temp = accounts.get(i); // sets account information in a temporary variable 
                    writer.println(temp.toString() + "\n"); // prints account information to a file 
                } // end of for loop 
                
                writer.close(); 
                System.out.println("file created...\n"); 
                
            }
            
            if(answer == 8){
                PrintWriter writer = new PrintWriter(new File("accounts_name.txt")); // outputs information into a txt file called 'accounts_name'
                insertionSort(accounts); // sorts accounts from least to greatest account number
                
                for(int i = 0; i < accounts.size(); i++){ // goes through the whole array list 
                    Account temp = accounts.get(i); // sets account information in a temporary variable 
                    writer.println(temp.toString() + "\n"); // prints account information to a file 
                } // end of for loop 
                
                writer.close(); 
                System.out.println("file created...\n");
            
            } 
        
        } // end of while loop 
        
    } // end of main 
    
    public static ArrayList<Account> readFile(String text) throws IOException{ // reads in data from a given file, stores data into a new Account object for each user, returns Account array list
        Scanner reader = new Scanner(new File(text)); // reads data from a file given by the user 
        ArrayList<Account> accounts = new ArrayList<Account>(); // creates an array list of Account objects to store each account
        
        for(int i = 0; i < 6; i++){ // skips through the titles 
            reader.next(); 
        }
        
        while(reader.hasNext()){ // continues while there is still data in the file 
            
            // stores account info into temporary variables 
            String firstName = reader.next(); 
            String lastName = reader.next(); 
            int accNum = reader.nextInt(); 
            double balance = reader.nextDouble(); 
            
            Account temp = new Account(firstName, lastName, accNum, balance); // creates an Account object with the users info 
            accounts.add(temp); // adds accounnt info to the Account array list 
            
        } // end of while loop 
        
        return accounts; // returns array list of Accounts
        
    } // end of 'readFile' method 
    
    public static int linearSearch(ArrayList<Account> a, int searchValue){
        for(int i = 0; i < a.size(); i++){ // goes through each index in the array 
            Account accInfo = a.get(i); // sets account information to a temporary variable 
            
            if(accInfo.getAcctNum() == searchValue){ // executs program if the account number matches given account number 
                return i; // returns index of the given account 
            }
        } // end of for loop 
        
        return -1; // returns value if the account does not exist 
    } // end of 'linearSearch' method 
    
    public static void bubbleSort(ArrayList<Account> a){ // sorts the array list of accounts in numerical order by their account numbers
        int k = 0; 
        boolean exchangeMade = true; 
        
        while((k < a.size() - 1) && exchangeMade){ // continues swaps if there are exchanges being made
            exchangeMade = false; 
            k++; 
            
            for(int j = 0; j < a.size() - k; j++){ // goes through each index 
                Account account1 = a.get(j); // sets a temporary varible for the account 
                Account account2 = a.get(j+1); // sets a temporary variable for the account an index above 'account1'
                
                if(account1.getAcctNum() > account2.getAcctNum()){ // runs code if the account number for 'account1' is greater than that of 'account2' 
                    swap(a, j, j + 1); // uses the 'swap' method to swap the indexes of the accounts
                    exchangeMade = true; 
                
                } // end of if statement 
            } // end of for loop 
        }
    } // end of 'bubbleSort' method 
    
    public static void swap(ArrayList<Account> a, int x, int y){ // swaps the index of two accounts in the array list 
        Account temp = a.get(x); 
        a.set(x, a.get(y)); 
        a.set(y, temp); 
        
    } // end of 'swap' method 
    
    public static void insertionSort(ArrayList<Account> a){ // sorts the array list of accounts in alphabetical order by last name 
        String itemToInsert; 
        int index; 
        boolean stillLooking; 
        
        for(int k = 1; k < a.size(); k++){ // goes through each index in the array 
            Account temp = a.get(k); // sets account at index to a temporary variable 
            itemToInsert = temp.getName(); // sets 'itemToInsert' as the name of the account holder 
            index = k -1; 
            stillLooking = true; 
            
            while((index >= 0) && stillLooking){ // looks through each value in the array list before the given index 
                Account temp2 = a.get(index); // sets previous account to a temporary variable 
                String name = temp2.getName(); // sets account holder name to a temporary string
                int result = itemToInsert.compareTo(name); // compares the names of two accounts, checks which one is alphabetically first
                if(result < 0){ // runs code if 'itemToInsert' is alphabetically before 'name'
                    a.set(index + 1, temp2); // moves other account up by one index 
                    index--; 
                }
                
                else{
                    stillLooking = false; 
                } // end of if else statement 
                
                a.set(index + 1, temp); // sets account to it's proper alphabetical placement 
                
            } // end of while loop 
        } // end of for loop 
        
    } // end of method 'insertionSort'
    
} // end of class

