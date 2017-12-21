import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 
 * @author Liam Grover
 *	This class is made to hold the messages and hold the lock variable.
 */
public class Message {
	public static ArrayList<String> msg = new ArrayList<String>();
	public static ReentrantLock lock = new ReentrantLock();

}
