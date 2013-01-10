import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class SQLStatement {
        
    Connection con;
	Statement stmt;
	ResultSet rs;
String driver = "com.mysql.jdbc.Driver";
String  sURL = "jdbc:mysql://localhost/pemrograman3?";
String  sUSER = "root";
String  sPass = ""; 
	
	PreparedStatement stat;
	
	//GUI Component
	Container co;
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JFrame frame = new JFrame();
	
	
	JLabel LBLtitle = new JLabel("SCIENCE 1");
	JComboBox JCo = new JComboBox();
	
	JLabel LBLID = new JLabel("ID");
	JLabel LBLFullName = new JLabel("Full Name");
	JLabel LBLNickName = new JLabel("Nick Name");
	JLabel LBLClass = new JLabel("Class");
	JLabel LBLMainPoint = new JLabel("Main Point");
	JLabel LBLSex = new JLabel("Sex");
	JLabel LBLPlace = new JLabel("Place of Birth");
	JLabel LBLDate = new JLabel("Date of Birth");
	JLabel LBLAddress = new JLabel("Address");
	JLabel LBLCity = new JLabel("City");
	JLabel LBLState = new JLabel("State");
	JLabel LBLPhoneNumber = new JLabel("Phone Number");
	JLabel LBLEmail = new JLabel("Email");
	
	
	JTextField TXTID = new JTextField(20);
	JTextField TXTFullName = new JTextField(20);
	JTextField TXTNickName = new JTextField(20);
	JTextField TXTClass = new JTextField(20);
	JTextField TXTMainPoint = new JTextField(20);
	JTextField TXTSex = new JTextField(20);
	JTextField TXTPlace = new JTextField(20);
	JTextField TXTDate = new JTextField(20);
	JTextField TXTAddress = new JTextField(20);
	JTextField TXTCity = new JTextField(20);
	JTextField TXTState = new JTextField(20);
	JTextField TXTPhoneNumber = new JTextField(20);
	JTextField TXTEmail = new JTextField(20);
	
	
	
	JLabel blank = new JLabel(" ");;
	JButton BTNInsert = new JButton("Insert");
	JButton BTNUpdate = new JButton("Update");
	JButton BTNDelete = new JButton("Delete");
	JButton BTNAddPoint = new JButton("Add Point");
	JButton BTNNext = new JButton("Next");
	JButton BTNPreview = new JButton("Preview");
	JButton BTNFirst = new JButton("First");
	JButton BTNLast = new JButton("Last");
	
	JLabel err = new JLabel("");
	
	
	
	void buildGUI()
	{
		panel1.add(LBLID);
    	panel1.add(TXTID);
    	panel1.add(JCo);
    	
    	panel2.setLayout(new GridLayout(12,2));
    	panel2.add(LBLFullName);
    	panel2.add(TXTFullName);
    	panel2.add(LBLNickName);
    	panel2.add(TXTNickName);
    	panel2.add(LBLSex);
    	panel2.add(TXTSex);
    	panel2.add(LBLClass);
    	panel2.add(TXTClass);
    	panel2.add(LBLMainPoint);
    	panel2.add(TXTMainPoint);
    	panel2.add(LBLPlace);
    	panel2.add(TXTPlace);
    	panel2.add(LBLDate);
    	panel2.add(TXTDate);
    	panel2.add(LBLAddress);
    	panel2.add(TXTAddress);
    	panel2.add(LBLCity);
    	panel2.add(TXTCity);
    	panel2.add(LBLState);
    	panel2.add(TXTState);
    	panel2.add(LBLPhoneNumber);
    	panel2.add(TXTPhoneNumber);
    	panel2.add(LBLEmail);
    	panel2.add(TXTEmail);

    	
    	panel3.add(err);
    	panel3.add(BTNInsert);
    	panel3.add(BTNUpdate);
    	panel3.add(BTNDelete);
    	
		panel4.add(BTNAddPoint);
    	
    	panel5.add(panel4);
    	panel5.add(panel3);
    	panel5.setLayout(new GridLayout(2,1));
    	
    	
      	frame.setLayout(new BorderLayout());
    	frame.add("North",panel1);
    	frame.add("Center",panel2);
    	frame.add("South",panel5);
    	frame.setVisible(true);
    	frame.setSize(400,700);

	}

	void setupDB()
	{
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(sURL, sUSER, sPass);
			stmt=con.createStatement();
			rs = stmt.executeQuery("select IdStudent from student");
			
			while(rs.next())
			{
			JCo.addItem(rs.getString(1));
			}
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	void setupEventHandlers()
	{
		JCo.addActionListener(new buttonHandler());
    	
		BTNInsert.addActionListener(new buttonHandler());	
		BTNUpdate.addActionListener(new buttonHandler());
		BTNDelete.addActionListener(new buttonHandler());
		BTNNext.addActionListener(new buttonHandler());
		BTNPreview.addActionListener(new buttonHandler());
		BTNFirst.addActionListener(new buttonHandler());
		BTNLast.addActionListener(new buttonHandler());
		BTNAddPoint.addActionListener(new buttonHandler());
	}
	
	
	public class buttonHandler implements ActionListener
    {
    	public void actionPerformed(ActionEvent ae)
    	{
    		if(ae.getSource()==JCo)
    		{
    			try
				{
			
					con = DriverManager.getConnection(sURL, sUSER, sPass);
					
					String id_terpilih = JCo.getSelectedItem().toString();
					
					stmt=con.createStatement();
					rs=stmt.executeQuery("SELECT IdStudent,FullName,NickName,Kelas, MainPoint, Sex, PlaceofBirth,DateofBirth,Address,City,States,PhoneNumber,Email FROM student WHERE IdStudent = " + "'" + id_terpilih + "'");
					rs.next();
					TXTID.setText(id_terpilih);
					TXTFullName.setText(rs.getString(2));
					TXTNickName.setText(rs.getString(3));
					TXTClass.setText(rs.getString(4));
					TXTMainPoint.setText(rs.getString(5));
					TXTSex.setText(rs.getString(6));
					TXTPlace.setText(rs.getString(7));
					TXTDate.setText(rs.getString(8));
					TXTAddress.setText(rs.getString(9));
					TXTCity.setText(rs.getString(10));
					TXTState.setText(rs.getString(11));
					TXTPhoneNumber.setText(rs.getString(12));
					TXTEmail.setText(rs.getString(13));
	
					
					con.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
    			
    		}
    		
    		if(ae.getSource() == BTNInsert)
			{
				try
				{
							
					con = DriverManager.getConnection(sURL, sUSER, sPass);
					stat = con.prepareStatement("INSERT INTO student(IdStudent,FullName,NickName,Kelas, MainPoint, Sex, PlaceofBirth,DateofBirth,Address,City,States,PhoneNumber,Email) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
					
					String id_terpilih = TXTID.getText();
					String TEMPFullName = TXTFullName.getText();
					String TEMPNickName = TXTNickName.getText();
					String TEMPClass = TXTClass.getText();
					String TEMPMainPoint = TXTMainPoint.getText();
					String TEMPSex = TXTSex.getText();
					String TEMPPlaceofBirth = TXTPlace.getText();
					String TEMPDateofBirth = TXTDate.getText();
					String TEMPAddress = TXTAddress.getText();
					String TEMPCity = TXTCity.getText();
					String TEMPState = TXTState.getText();
					String TEMPPhoneNumber = TXTPhoneNumber.getText();
					String TEMPEmail = TXTEmail.getText();
					

					stat.setString(1,id_terpilih);
					stat.setString(2, TEMPFullName);
					stat.setString(3, TEMPNickName);
					stat.setString(4, TEMPClass);
					stat.setString(5, TEMPMainPoint);
					stat.setString(6, TEMPSex);
					stat.setString(7, TEMPPlaceofBirth);
					stat.setString(8, TEMPDateofBirth);
					stat.setString(9, TEMPAddress);
					stat.setString(10, TEMPCity);
					stat.setString(11, TEMPState);
					stat.setString(12, TEMPPhoneNumber);
					stat.setString(13, TEMPEmail);

					stat.executeUpdate();
					
					InsertSuccessfull app0 = new InsertSuccessfull();
					frame.setVisible(false);
					
					con.close();
					
					
					
					
				}
				
				catch (Exception e)
				{
					e.printStackTrace();
				}
    		
    		}
    		
    		
    		if(ae.getSource()==BTNDelete)
			{
				try
				{
				
					con = DriverManager.getConnection(sURL, sUSER, sPass);
					stat = con.prepareStatement("delete from student where IdStudent = ?");
					String id_pilihan = JCo.getSelectedItem().toString();
					
					stat.setString(1,id_pilihan);
					stat.executeUpdate();
					
					InsertSuccessfull app0 = new InsertSuccessfull();
					frame.setVisible(false);
					
					con.close();
					
				
				}
				
				catch (Exception e)
				{
					e.printStackTrace();
					err.setText("baris tidak dapat dihapus");
				}
			}
			
			
			if(ae.getSource()==BTNUpdate)
			{
				try
				{
				
					con = DriverManager.getConnection(sURL, sUSER, sPass);
					stat = con.prepareStatement("update student set FullName = ?, NickName = ?, Kelas = ?, MainPoint = ?, Sex = ?, PlaceofBirth = ?, DateofBirth = ?,  Address = ?, City = ?, States = ?, PhoneNumber = ?,  Email = ? where IdStudent = ?");
					String id_terpilih = TXTID.getText();
					String TEMPFullName = TXTFullName.getText();
					String TEMPNickName = TXTNickName.getText();
					String TEMPClass = TXTClass.getText();
					String TEMPMainPoint = TXTMainPoint.getText();
					String TEMPSex = TXTSex.getText();
					String TEMPPlaceofBirth = TXTPlace.getText();
					String TEMPDateofBirth = TXTDate.getText();
					String TEMPAddress = TXTAddress.getText();
					String TEMPCity = TXTCity.getText();
					String TEMPState = TXTState.getText();
					String TEMPPhoneNumber = TXTPhoneNumber.getText();
					String TEMPEmail = TXTEmail.getText();
					
					
					
					
					stat.setString(1, TEMPFullName);
					stat.setString(2, TEMPNickName);
					stat.setString(3, TEMPClass);
					stat.setString(4, TEMPMainPoint);
					stat.setString(5, TEMPSex);
					stat.setString(6, TEMPPlaceofBirth);
					stat.setString(7, TEMPDateofBirth);
					stat.setString(8, TEMPAddress);
					stat.setString(9, TEMPCity);
					stat.setString(10, TEMPState);
					stat.setString(11, TEMPPhoneNumber);
					stat.setString(12, TEMPEmail);
					stat.setString(13,id_terpilih);

					stat.executeUpdate();
					con.close();
					
				
				
					err.setText("baris telah diupdate");
				}
					
					
			 
				
				catch (Exception e)
				{
					e.printStackTrace();
					err.setText("error");
					
				}
			}
			if (ae.getSource()==BTNAddPoint)
			{
				addPoint app9 = new addPoint();
				frame.setVisible(false);
			
			}
			
    		
    	}

    }
    
    public SQLStatement() 
    {
    	buildGUI();
    	setupDB();
    	setupEventHandlers();
    }
    
    public static void main(String[] args) {
        SQLStatement app = new SQLStatement();
    }
}
