
public class Job {
	private double size;
	private String name;
	private int time;
	public Job(double memSize, String jobName)
	{
		size = memSize;
		name= jobName;
		time = 5; //seconds
	}
	public void count()
	{
		time--;
	}
	public int getTime()
	{
		return time;
	}
	public String getName()
	{
		return name;
	}
	public double getSize()
	{
		return size;
	}
	public void setTime(int t)
	{
		time = t;
	}
	
}
