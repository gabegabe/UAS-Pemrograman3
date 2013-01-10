import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class welcomePage {
        
    ImageIcon enter = new ImageIcon("enter.jpg");
   	JButton BTNenter = new JButton(enter);
   	JLabel LBLCaution = new JLabel("Basyar Tauhid Hadi - 4505210020 dan Satari Ahmad Tahir - 4508210070");
   	
	
   	JPanel panel1 = new JPanel();
   	JPanel panel2 = new JPanel();
   	JFrame frame = new JFrame();
   	
   	
   	void setupEventHandlers()
    {
    	BTNenter.addActionListener(new buttonHandler());
    }
    
    
    public class buttonHandler implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		if (e.getSource() == BTNenter)
    		{
    			//wel app1 = new wel();
    			mainMenu app1 = new mainMenu();
    			frame.setVisible(false);
    			//app1.setSize(300,300);
    			//app1.setVisible(true);
    			
    		}
    	}
    }
    
    
    void buildGUI()
	{
	
	   
       panel2.add(LBLCaution);
       panel1.add(BTNenter);
       frame.setLayout(new GridLayout(2,1));
       
       frame.add(panel2);
       frame.add(panel1);
       frame.setSize(500,450);
       frame.setVisible(true);
       
      
       
	}
   	
   	
    public welcomePage() {
    	buildGUI();
    	setupEventHandlers();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        welcomePage app = new welcomePage();
    }
}
