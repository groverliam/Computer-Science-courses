public class BankApp {

	public static void main(String[] args) 
	{
		
		final int LENGTH=100;
		BankAccount[] acc = new BankAccount[LENGTH];
		int currentSize = 0;

		BankAccount bank = new BankAccount(123, 100);
		acc[currentSize].addAccount(123,100);
		currentSize++;
		/*accounts[0].deposit(30);
		System.out.println(accounts[0].getBalance());
		System.out.println(accounts[0].getAccNum());
		accounts[0].withdraw(100);
		System.out.println(accounts[0].getBalance());
*/
	}

}



