//LoginListener.java
import java.util.* ;
public interface LoginListener extends EventListener 
{
	public void validateLogin(LoginEvent mec);
}