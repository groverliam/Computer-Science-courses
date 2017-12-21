import java.util.Scanner;


public class bank {
protected static double balance;
protected static String pass;
protected static int num;


	public void setBal(double n)
	{
		balance = n;
	}
	public static double getBal()
	{
		return balance;
	}
	public void setPass(String p)
	{
		pass = p;
	}
	public static String getPass()
	{
		return pass;
	}
	public int getNum()
	{
		return num;
	}
	
	public static void main (String[] args)
	{
		Scanner in = new Scanner (System.in);
		num= 1230;
		pass= "2L9o!";
		balance = 16279.20;
		int q = 1;
		while(q != 0)
		{
		
		System.out.println("Please enter the password for Account: "+ num +".");
		String l = in.next();
		if(l.equals(pass))
		{
			System.out.println("What would you like to do?");
			System.out.println("1: Get balance");
			System.out.println("2: Withdraw");
			System.out.println("3: Deposit");
			System.out.println("4: Change password");
			System.out.println("0: Quit");
			q = in.nextInt();
			if (q==1)
			{
				System.out.println(getBal());
			}
			else if(q==2)
			{
				System.out.println("How much?");
				double amount = in.nextDouble();
				if(amount> balance)
				{
					System.out.println("Insufficient Funds");
				}
				else 
				{
					balance = balance - amount;
					System.out.println( "Balance: " + getBal());
					
				}

			}
			else if(q==3)
			{
				System.out.println("How much?");
				double amount = in.nextDouble();
				balance = balance + amount;
				System.out.println( "Balance: " + getBal());

			}
			else if (q==4)
			{
				System.out.println("What would you like to change it to?");
				pass = in.next();
				System.out.println( "New Password: " + getPass());

			}

		}
		else
		{
			System.out.println( "Wrong Password");

		}
		
	}
	}
}
