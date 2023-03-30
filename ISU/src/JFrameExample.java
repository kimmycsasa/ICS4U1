import java.awt.*; 
import javax.swing.*;

public class JFrameExample {
    public static void main(String[] args){
        
        JFrame frame = new JFrame("Title of Frame"); 
        frame.setSize(300, 200); // set size of frame 
        frame.setLocationRelativeTo(null); // center frame on screen 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true); // makes frame appear 
        
        JPanel panel = new JPanel(); 
        frame.add(panel); // add JPanel to JFrame 
        
        JLabel label = new JLabel("Hello World!"); 
        panel.add(label); // add JLabel to JPanel 
        
        JButton startButton = new JButton("START"); 
        panel.add(startButton); 
        
    } // end of main 
    
} // end of class

