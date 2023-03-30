public class Properties {
    
    // decleares instance variables
    private String name; 
    private int buyPrice; 
    private int sellPrice; 
    private int income; 
    
    public Properties(String n, int b, int s, int i){ // sets variables to given parameters
        name = n; 
        buyPrice = b; 
        sellPrice = s; 
        income = i; 
    } // end of constructor method 
    
    public String getName(){ // returns property name 
        return name; 
    } // end of 'getName' method 
    
    public int getBuyPrice(){ // returns the sale value of the property
        return buyPrice; 
    } // end of 'getBuyPrice' method 
    
    public int getSellPrice(){ // returns the resell value of the property
        return sellPrice;
    } // end of 'getSellPrice' method
    
    public int getIncome(){ // returns the value an owner gets when someone lands on their property
        return income; 
    } // end of 'getIncome' 
    
} // end of class


