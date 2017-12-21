public class BankAccount {
	private int accNum;
	private double balance;
	private BankAccount[] accounts;
	private int nAccounts=0;

	/*BankAccount(int newNum)
	{
		balance= 0;
		accNum = newNum;
	}*/
	BankAccount (int newNum, double newBalance)
	{
		balance= newBalance;
		accNum = newNum;
		
	}
	public void addAccount(int num, int amount)
	{
		BankAccount acc = new BankAccount(num, amount);
		accounts[nAccounts]= acc;
		nAccounts++;
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
	public void findAccount(int num)
	{
		int x=-1;
		for(int i = 0; i >= nAccounts;i++)
		{
			if (accounts[i].getAccNum()== num)
			{
				x= i;
			}
		}
		if(x ==-1)
		{
			System.out.println("the account could not be found.");
		}
		else
		{
			accounts[x].toString();
		}
	}
	public void removeAccount(int num)
	{
		BankAccount temp;
		BankAccount temp2= new BankAccount(0,0);
		for(int i = 0; i >= nAccounts;i++)
		{
			if (accounts[i].getAccNum()== num)
			{
				accounts[i]=temp2;
			}
			
		}
		for(int j = (accounts.length-1); j>0; j--)
		{
			if (accounts[j-1]== temp2)
			{
				temp = accounts[j-1];
				accounts[j-1]= accounts[j];
				accounts[j]=temp;
			}
		}
	}
	
}









