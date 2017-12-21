public class Bank extends BankAccount{
	Bank(int newNum, double amount) {
		super(newNum,amount);
	}
	private int nAccounts=0;
	private final int LENGTH= 100;
	BankAccount[] accounts = new BankAccount[LENGTH];
	BankAccount aBank;
	public void add(BankAccount[] accounts, int accNum, double amount, int n)
	{
		aBank = new BankAccount(accNum, amount);
		accounts[n] = aBank;
		nAccounts++;
	}
	public void withdraw(int accNum, double amount)
	{
		for(int i = 0; i < nAccounts;i++)
		{
			if (accounts[i].getAccNum()== accNum)
			{
				accounts[i].withdraw(amount);
			}
		}
	}
	public void deposit(int accNum, double amount)
	{
		for(int i = 0; i < nAccounts;i++)
		{
			if (accounts[i].getAccNum()== accNum)
			{
				accounts[i].deposit(amount);
			}
		}
	}
	public void remove(int accNum)
	{
		for(int i = 0; i < nAccounts;i++)
		{
			if (accounts[i].getAccNum()== accNum)
			{
				accounts[i]= accounts[nAccounts-1];
				nAccounts--;
				break;
			}
			if(i == nAccounts-1)
			{
				System.out.println("That account has been removed");
			}
		}
		System.out.println("Account Removed");
	}
	public void printOut(BankAccount[] accounts, int n)
	{
		nAccounts= n;
		for(int i =0; i < nAccounts  ; i++)
		{
			System.out.println ((i+1)+ ") The account number is: " + accounts[i].getAccNum() + 
					" with a balnce of: $"+ accounts[i].getBalance() +".\n");
		}

	}
	public void findAccount(int accNum)
	{
		for(int i = 0; i < nAccounts;i++)
		{
			if (accounts[i].getAccNum()== accNum)
			{
				System.out.println("The account number is: " + accounts[i].getAccNum() + 
					" with a balance of: $"+ accounts[i].getBalance());
			}
			else
			{
				
			}
		}

	}
	
}
