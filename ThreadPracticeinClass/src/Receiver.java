/**
 * 
 * @author Liam Grover
 *	This class reads the messages from the message board and prints them in a print feed.
 */
public class Receiver implements Runnable{

	Thread t;
	//int n = 0;

	@Override
	public void run()
	{

		try {
			while(true)
			{
				if(!Message.lock.isLocked())
				{
					printFeed();
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/*public  String readMSG() throws InterruptedException {

		String message = Message.msg.get(0);
		Message.msg.remove(message);
		return message;
	}*/
	
	/**
	 * This method prints the feed of the messages stored in the message board.
	 * @throws InterruptedException
	 */
	public  void printFeed() throws InterruptedException {
		System.out.println("--------------------");

		System.out.println("PRINT FEED:");

		for(int i = 0; i < Message.msg.size(); i++)
		{
			System.out.println(Message.msg.get(i));

		}
		System.out.println("--------------------\n");
		Thread.sleep(8);
	}
	
	/**
	 * Creates and starts the thread for the receiver.
	 */
	public void start()
	{
		if (t == null) {
			t = new Thread (this, "Reciever");
			t.start ();
		}
	}


}
