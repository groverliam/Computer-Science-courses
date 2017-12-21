import java.util.ArrayList;
/**
 * 
 * @author Liam Grover
 *	A class to run the message board.
 */
public class Tester {


	public static void main(String[] args) {



		Sender sender1 = new Sender("sender1");
		Sender sender2 = new Sender("sender2");
		//Thread s1 = new Thread(sender1, "s1");
		//Thread s2 = new Thread(sender2, "s2");
		Receiver reciever = new Receiver();
		Thread r1 = new Thread(reciever, "r1");
		sender1.start(); //then started by this method.
		sender2.start();
		r1.start();


	}

}
