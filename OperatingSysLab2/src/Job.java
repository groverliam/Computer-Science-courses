import java.util.*;
public class Job {
	private int time;
	private double size;
	private String name;
	private int part;
	private ArrayList<Job> waiting = new ArrayList<Job>();
	private ArrayList<Job> running = new ArrayList<Job>();
	private int waitingLength = 0;
	private int runningLength = 0;
	private double[] pSizes = {25.0, 25.0, 25.0, 50.0, 50.0, 50.0, 75.0, 100.0, 100.0};
	private boolean[] pfree = {true, true, true, true, true, true, true, true, true};
	private final boolean BUSY = false;
	private final boolean FREE = true;

	public Job()
	{
		
	}
	
	public Job(String n, double s)
	{
		name = n.toUpperCase();
		size = s;
		time = 5;
	}
	
	public void addJob(String n, double s)
	{
		waiting.add(new Job(n, s));
		//waitingLength++;
	}
	
	public boolean going()
	{
		if(running.size() != 0 || running.size() != 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void addWaiting (Job j)
	{
		waiting.add(j);
		//waitingLength++;
	}

	public void addRunning (Job j)
	{
		running.add(j);
		waiting.remove(j);
		//waitingLength++;
	}
	
	public void printWaiting()
	{
		System.out.println("Jobs Waiting:");
		for(int i = 0; i < waiting.size(); i++)
		{
			System.out.println(waiting.get(i).getName());
		}
	}

	
	public void runAllWaiting() //have to make a while loop in main using this. 
	{
		//double temp;
		for(int i = 0; i < waiting.size(); i++)
		{
			//temp = waiting.get(i).getSize();
				for(int k = 0; k < 9; k++)
				{
					if(waiting.get(i).getSize() <= pSizes[k] && pfree[k])
					{

							addRunning(waiting.get(i));
							//runningLength++;
							pfree[k] = BUSY;
							//System.out.println(running.size());
							running.get(i).setPart(k);
							System.out.println("\n"+running.get(running.size()-1).getName() + " can now run at size "+ running.get(running.size()-1).getSize()+ " MB. It will take 5 seconds to finish.\n");
							k = 9;
						
					}
				}
				countRunning();
			}
	}

	public String getName()
	{
		return name;
	}

	public int getTime()
	{
		return time;
	}

	public double getSize()
	{
		return size;
	}

	public void minusOne()
	{
		time--;
	}
	
	public void setPart(int k)
	{
		part = k;
	}
	
	public int getPart()
	{
		return part;
	}
	
	public int getWaitLength()
	{
		return waiting.size();
	}
	
	public void countRunning()
	{
		for(int i = 0; i < running.size(); i++)
		{
			running.get(i).minusOne();
			
			if(running.get(i).getTime() == 0)
			{
				System.out.println("\n"+running.get(i).getName() + " is now complete.\n");
				pfree[running.get(i).getPart()] = FREE;
				running.remove(i);
				//runningLength--;
			}
			else
			{
				System.out.println("time left for "+ running.get(i).getName()+ ": " +running.get(i).getTime()+ " seconds." );
			}
		}
	}
}
