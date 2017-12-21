import java.util.*;

/**
 * 
 * @author Liam Grover
 *	This class is a sender class that is to be used by a user to enter text to the message board.
 *
 */
public class Sender implements Runnable{

	private Thread t;
	private String name;
	Scanner in = new Scanner(System.in);

	/**
	 * Creates a sender object with a name that can be turned into a thread with the start method.
	 * @param name of thread
	 */
	public Sender(String name)
	{
		this.name = name;

	}


	@Override
	public void run()
	{


		try {
			//Thread.sleep(100);
			while(true)
			{
				if(!Message.lock.isLocked())
				{
					Message.lock.lock();
					Thread.sleep(10);
					if(Message.lock.isHeldByCurrentThread())
					{
						System.out.print(this.name+ ", please enter text: ");
						addMSG();

						Thread.sleep(500);
					}
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	/**
	 * allows sender to input a message and then adds that message to the message board.
	 * @throws InterruptedException
	 */
	public void addMSG() throws InterruptedException
	{


		Message.msg.add(this.name+ " said: " + in.nextLine());
		System.out.print("\n");
		//Message.msg.add("hi");
		Message.lock.unlock();

	}
	/**
	 * Creates and starts the threads for both the senders.
	 */
	public void start()
	{
		System.out.println(this.name+ " has entered the message board.");
		if (t == null) {
			t = new Thread (this, name);
			t.start ();
		}
	}

	/*public  String readMSG() throws InterruptedException {

        String message = Message.msg.get(0);
        Message.msg.remove(message);
        return message;
    }*/


}
