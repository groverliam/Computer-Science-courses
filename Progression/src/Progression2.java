
public class Progression2 
{
	protected long first;
	protected long cur;
	
	public Progression2()
	{
		cur = 0;
		first = 0;
	}
	public Progression2(long a)
	{
		first= a;
		cur= a;
	}
	
	protected long firstValue()
	{
		cur = first;
		return cur;
	}
	
	protected long nextValue()
	{
		return ++cur;	//default next value
	}
	
	public void printProgression(int n)
	{
		System.out.print(firstValue());
		for (int i = 2; i <= n; i++)
		{
			System.out.print(" " + nextValue());
		}
	}
}
