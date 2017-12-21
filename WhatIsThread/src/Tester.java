public class Tester {

	public static void main(String[] args) {
		
		
		Reciever reciever = new Reciever();
		Thread r1 = new Thread(reciever, "r1");
		r1.start();
		
	}

}
