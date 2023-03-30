import java.awt.event.*; 
import javax.swing.*; 

public class GUIWindow implements ActionListener{
    
    private JButton buttonA; 
    private JButton buttonB; 
    private JButton buttonC; 
    
    public GUIWindow(){
        
    }
    
    public void outputGUI(){
        JFrame frame = new JFrame("Button Example"); 
        JPanel content = new JPanel(); 
        frame.add(content); 
    
        buttonA = new JButton("A"); 
        buttonB = new JButton("B"); 
        buttonC = new JButton("Quit"); 
    
        buttonA.addActionListener(this); 
        buttonB.addActionListener(this); 
        buttonC.addActionListener(this);
    
        content.add(buttonA); 
        content.add(buttonB); 
        content.add(buttonC); 
    
        frame.setSize(300, 100); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == buttonA){
            System.out.println("You pressed button 'A'"); 
            
        }
        
        else if (e.getSource() == buttonB){
            System.out.println("You pressed button 'B'"); 
            
        }
        
        else if (e.getSource() == buttonC){
            System.out.println("Exiting..."); 
            System.exit(0); 
        }
    }
    
}

