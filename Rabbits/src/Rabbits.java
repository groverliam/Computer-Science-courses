
public class Rabbits {
	protected long a;
	protected long b;
	protected long c;
	
	Rabbits()
	{
		a= 1;//kids
		b= 0;//adults
		c= a+b;
	}
	Rabbits(long startA)
	{
		a= startA;
		b = 0;
		c= a+b;
	}
	protected long nextValue()
	{
		a= b;
		b= c;
		c= a+b;
		return c;
	}
	protected long getKids()
	{
		return a;
	}
	protected long getAdults()
	{
		return b;
	}
	protected long firstValue()
	{
		c = a;
		return c;
	}
	/*public void printProgression(int n)
	{
		System.out.print(firstValue()+"\n");
		for (int i = 2; i <= n; i++)
		{
			System.out.print(nextValue()+"\n");
		}
	}*/
	public void duplicate(int n)
	{
		firstValue();
		for (int i = 2; i <= n; i++)
		{
			nextValue();
		}
	}
}
