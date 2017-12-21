public class Fibonacci extends Progression2
{
	protected long second;
	Fibonacci()
	{
		second = 1;
		cur = first+second;
		
	}
	Fibonacci(long a) // //The first numbers will be a and b.
	{
		second= 0;
		cur= a;
		first = a;
		
	}
	protected long nextValue()
	{
		first = second; //first is now the value of second value.
		second = cur; //second is now what the cur was.
		cur = first + second; //and this calculates the Fibonacci sequence
		return cur;
	}
}
