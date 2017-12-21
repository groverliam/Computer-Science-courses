
public class Reciever implements Runnable{

	Sender sender1 = new Sender();
	Sender sender2 = new Sender();
	int n = 0;
	
	@Override
	public void run()
	{
		while(n==0)
		{
		try {

			System.out.println("Sender 1 please enter your message.");
			sender1.addMSG();
			System.out.println("");
			
			
			System.out.println("Sender 1 said:\n"+ sender1.readMSG()+"\n");
			System.out.println("-----------------------------------------\n");

			
			System.out.println("Sender 2 please enter your message.");
			sender2.addMSG();
			System.out.println("");
			
			
			System.out.println("Sender 2 said:\n"+ sender2.readMSG()+"\n");
			System.out.println("-----------------------------------------\n");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
