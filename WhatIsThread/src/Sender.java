import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
public class Sender implements Runnable{
	
	
	//Sender 1 and Sender 2 will use this class.
	private ReentrantLock lock = new ReentrantLock();
	Scanner in = new Scanner(System.in);
	String mes;
	private ArrayList<String> msg = new ArrayList<String>();
	
	
	@Override
	public void run()
	{
		/*lock.lock();
		System.out.println("Enter your message.");
		mes = in.nextLine();
		m.add(mes);
		lock.unlock();*/
		
		try {
            while (true) {
            	
                addMSG();
                
            }
        } catch (InterruptedException e) {
        }
		
	}
	
	public void addMSG() throws InterruptedException
	{
		
		lock.lock();
		
        msg.add(in.nextLine());
        
        lock.unlock();
	}
	
	public  String readMSG() throws InterruptedException {
       
        String message = msg.get(0);
        msg.remove(message);
        return message;
    }
	
}
