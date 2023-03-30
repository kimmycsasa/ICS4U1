public class Account {
    
    // declares instance variables 
    private String firstName; 
    private  String lastName; 
    private  int accNumber; 
    private double balance; 
    
    public Account(){ // constructor method that initializes instance variables to empty or 0
        firstName = ""; 
        lastName = ""; 
        accNumber = 0; 
        balance = 0; 
        
    } // end of constructor method 'Account' 
    
    public Account(String f, String l, int i, double a){ // constructor method that initializes instance variables inputted by the user 
        firstName = f; 
        lastName = l; 
        accNumber = i; 
        balance = a; 
        
    } // end of constructor method 'Account' 
    
    public void setName(String first, String last){ // sets first and last name inputted by the user for an account 
        firstName = first; 
        lastName = last; 
        
    } // end of 'setName' method 
    
    public String getName(){ // returns the first and last name of account holder 
        String name = lastName + ", " + firstName; 
        return name; 
        
    } // end of 'getName' method 
    
    public void setAcctNum(int num){ // sets account number to an inputted number for an account 
        accNumber = num; 
        
    } // end of 'setAcctNum' method
    
    public int getAcctNum(){ // returns account number 
        return accNumber; 
        
    } // end of 'getAcctNum' method 
    
    public void setBalance(double amount){ // sets the account balance to an inputted balance for an account 
        balance = amount; 
        
    } // end of 'setBalance' method 
    
    public double getBalance(){ // returns account balance 
        return balance; 
        
    } // end of 'getBalance' method 
    
   public void deposit(double amount){ // deposits money from account 
       balance = balance + amount; // updates balance 
       
   } // end of 'deposit' method 
   
   public void withdraw(double amount){ // withdraws money from account 
       balance = balance - amount; // updates balance
       
   } // end of 'withdraw' method 
   
   public void transfer(double amount, Account other){ // transfers funds from one account to another 
       balance = balance - amount; // updates balance of account 
       double newBalance = amount + other.getBalance(); // calculates the new balance of other account 
       other.setBalance(newBalance); // updates balance of other account 
       
   } // end of 'transfer' method
   
   public String toString(){
       String accInfo = "Account Holder Name: " + lastName + ", " + firstName + "\nAccount Number: " + accNumber + "\nBalance: $" + balance; // sets account information into a variable 
       return accInfo; // returns account information 
       
   } // end of 'toString' method 
    
} // end of class
