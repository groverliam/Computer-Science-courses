public class BankAccount {
	private int accNum;
	private double balance;
	
	BankAccount(int newNum, double newBalance)
	{
		balance= newBalance;
		accNum = newNum;
	}
	public void deposit(double amount)
	{
		balance = balance + amount;
	}
	public void withdraw(double amount)
	{
		if (balance >= amount)
		{
			balance = balance - amount;
		}
		else
		{
			System.out.println("Insufficient funds.");
		}
	}
	public int getAccNum()
	{
		return accNum;
	}
	public double getBalance()
	{
		return balance;
	}
	
}
