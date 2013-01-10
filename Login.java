import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Login {
        
   JFrame frame = new JFrame();
   JPanel panel6 = new JPanel();
   JPanel panel7 = new JPanel();
   
   JLabel LBLUser = new JLabel("User Name");
   JLabel LBLPass = new JLabel("Password");
   JTextField TXTUser = new JTextField();
   JPasswordField TXTPass = new JPasswordField();
   
   JButton Submit = new JButton("login");
   JButton Back = new JButton("back");
   
   
    Connection conn;
	Statement stmt;
	String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	String  sURL = "jdbc:odbc:project";
	String  sUSER = "";
	String  sPass = ""; 
   
   String userName, Passwd;
   String AccUserName, AccPasswd;

   void AccessDB()
   {
	try 
	{
		Class.forName(driver);
		conn = DriverManager.getConnection(sURL, sUSER, sPass);
		stmt = conn.createStatement();
		ResultSet myrs = stmt.executeQuery("SELECT * FROM login");
		
		while(myrs.next()) 
		{
		userName = myrs.getString(1).toString();
		Passwd = myrs.getString(2).toString();
		}
		
	}
	catch (Exception ae)
	{
		System.out.println(ae);
	}

   }
   
   void buildGUI()
   {
   		panel6.setLayout(new GridLayout(2,2));
   		panel6.add(LBLUser);
   		panel6.add(TXTUser);
   		panel6.add(LBLPass);
   		panel6.add(TXTPass);
   		
   		panel7.add(Submit);
   		panel7.add(Back);
   		
   		frame.setLayout(new BorderLayout());
   		frame.add("North",panel6);
   		frame.add("South",panel7);
   		frame.setVisible(true);
   		frame.setSize(300,300);
   		
   }
   
   void setupEventHandlers()
    {
    	Back.addActionListener(new buttonHandler());
    	Submit.addActionListener(new buttonHandler());
    }
    
    
    public class buttonHandler implements ActionListener
    {
    	

    	
    
    	public void actionPerformed(ActionEvent e)
    	{
    		if (e.getSource() == Back)
    		{
    			
    			mainMenu app1 = new mainMenu();
    			frame.setVisible(false);
    			
    			
    		}
    		if (e.getSource() == Submit)
    		{
    			AccUserName = TXTUser.getText().toString();
    			AccPasswd = TXTPass.getText().toString();
    			
    			if (AccUserName == "guru")//userName)
    			{
    				System.out.println("sukses");
				    System.out.println(userName);
					System.out.println(Passwd);
					
					System.out.println(AccUserName);
					System.out.println(AccPasswd);

    				
    				
    				/*
    				if (Passwd == AccPasswd)
    				{
    					View_2 app3 = new View_2();
    				}
    				*/
    			}
    			else 
    			{
    				System.out.println("gagal");
    				System.out.println(userName);
					System.out.println(Passwd);
					
					System.out.println(AccUserName);
					System.out.println(AccPasswd);

    			}
    			
    			
    			/*
    					System.out.println(userName);
    					System.out.println(Passwd);
    					
    					System.out.println(AccUserName);
						System.out.println(AccPasswd);
				*/		
    		}
    	}
    }
   
   
    public Login() {
    	buildGUI();
    	setupEventHandlers();
    	AccessDB();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login app = new Login();
    }
}
