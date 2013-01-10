//LoginBean.java
import java.util.* ;
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.*;
public class LoginBean extends JPanel implements ActionListener 
{
	JLabel l1=new JLabel("Insert User Name:");
	JLabel l2=new JLabel("Insert Password:");
	JTextField tf1 = new JTextField(15);
	JPasswordField tf2 = new JPasswordField(15);
	JButton ok = new JButton("submit");
	JButton back = new JButton("back");
	public LoginBean() 
	{
		setLayout(new GridLayout(3,2));
		add(l1);
		add(tf1);
		add(l2);
		add(tf2);
		add(ok);
		add(back);
		ok.addActionListener(this);
		back.addActionListener(this);
	}

	LoginListener mel;

      // Method to register login listeners
	public void addLoginListener(LoginListener mel) 
	{
		this.mel = mel;
	}

	LoginEvent mec;
	public void fireLoginEvent(LoginEvent mec) 
	{
		mel.validateLogin(mec);
	}
	public void actionPerformed(ActionEvent ae) 
	{
		if (ae.getSource()==ok) 
		{
/* When the user clicks the ‘ok’ button, create an event object and store the login information. Then, fire an event that can be used by listeners to use the login information */
			String temp1=tf1.getText();
			String temp2=new String(tf2.getPassword());
			mec = new LoginEvent(ok,temp1,temp2);
			fireLoginEvent(mec);
		}
		if (ae.getSource()==back) 
		{
			mainMenu app1 = new mainMenu();
		}
	}
}