//LoginEvent.java
import java.util.*;

public class LoginEvent extends EventObject 
{
public String userName;	
public String password;	
public LoginEvent(Object obj,String userName,String password)	
{            
//Invoke the base class constructor		
super(obj);		
this.userName=userName;		
this.password=password;	
}
}