import java.util.Scanner;

public class bankApp {

	public static void main (String [] args)
	{
		final int LENGTH = 100; 
		int nAccounts= 0;
		int accNum;
		double amount;
		
		Bank bank = new Bank(123,100);
		BankAccount[] accounts = new BankAccount[LENGTH];
		Bank aBank;
		
		accounts[0]= new BankAccount(123, 100);
		nAccounts++;
		accounts[1]= new BankAccount(234, 1000);
		nAccounts++;
		accounts[2]= new BankAccount(345, 30);
		nAccounts++;
		
		
		bank.printOut(accounts, nAccounts);
		bank.add(accounts, 1, 120, nAccounts);
		bank.printOut(accounts, nAccounts);
		
		bank.findAccount(123);
	}
}

