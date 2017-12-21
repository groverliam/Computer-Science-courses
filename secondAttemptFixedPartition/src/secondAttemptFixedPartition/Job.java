package secondAttemptFixedPartition;

public class Job {
	protected int time;
	protected static double size;
	protected boolean running;
	protected static String name;
	
	public Job(double s, String n)
	{
		size = s;
		running = false;
		time = 0;
		name = n;
	}
	public void startJob()
	{
		time = 5;
		running = true;
	}
	public boolean isRunning()
	{
		return running;
	}
	public int getTime()
	{
		return time;
	}
	public double getSize()
	{
		return size;
	}
	public String getName() //Shouldn't have to use.
	{
		return name;
	}
	public void countDownJob()
	{
		if(time != 0)
		{
			time--;
			if(time == 0)
			{
				running = false;
				System.out.println(name+" is complete!");
			}
		}
	}
}
