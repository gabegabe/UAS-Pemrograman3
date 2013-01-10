import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class OutofBonds {
        

 
	
    public static void main(String[] args) 
    {
        JFrame framex = new JFrame();
	
		JLabel firstWarning = new JLabel("The first record....");
		JPanel panelx = new JPanel();
		JButton OK = new JButton("OK");
		panelx.add(firstWarning);
		panelx.add(OK);
		framex.add(panelx);
		framex.setVisible(true);
		framex.setSize(150,150);
    }
}
