//LoginValidator.java
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.*;
import java.sql.*;

public class LoginValidator extends JFrame implements LoginListener 
{
Connection con;
Statement stmt;
ResultSet rs;
LoginBean meb;

String driver = "com.mysql.jdbc.Driver";
String  sURL = "jdbc:mysql://localhost/pemrograman3?";
String  sUSER = "root";
String  sPass = ""; 

	public LoginValidator() 
	{
		super("Login Form");
            //Initialise the login bean
		meb = new LoginBean();

            //Add the login bean to the frame window
		getContentPane().add(meb);

            /* Register LoginValidator as a listener of the 
            LoginEvent by invoking the following method of the 
            LoginBean */
		meb.addLoginListener(this);
	}
	public void validateLogin(LoginEvent mec) 
	{
		String temp1=mec.userName;
		String temp2=mec.password;
		try
		{
		Class.forName(driver);
		con = DriverManager.getConnection(sURL, sUSER, sPass);
		stmt=con.createStatement();
		rs = stmt.executeQuery("select * from login where username = '" + temp1 + "' and password = '" + temp2 + "'");
		if(rs.next())
		{
		JOptionPane.showMessageDialog(this,new String("Login Successfull"));
        AdminMainNav mc = new AdminMainNav();
		//mc.setSize(500,100);
		//mc.setVisible(true);
		this.setVisible(false);
                    }
		else
			
		{	
			JOptionPane.showMessageDialog(this,new String("Login Failed. Check Again Your User Name and Password..."));
			mainMenu app3 = new mainMenu();
		}
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	

	}
	public static void main(String a[]) 
	{
		LoginValidator mec = new LoginValidator();
		mec.setSize(300, 300);
		mec.setVisible(true);
	}
}