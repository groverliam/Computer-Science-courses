/**
 * Creates a job object.
 * @author Liam Grover
 *
 */
public class Job implements Runnable{
	private int size;
	private int jId;
	private int time;
	private int loca;
	private String name;
	private boolean waiting = true;
	private Thread t;
	
	/**
	 * Contructor for Job
	 * @param memSize is the size of memory for a job.
	 * @param jobName is the name of the job.
	 */
	public Job(int jobId, int memSize, int jobTime)
	{
		size = memSize;
		jId= jobId;
		time = jobTime; //seconds
	}
	
	
	public void run()
	{
		System.out.println("Job "+jId + " is running with a job size of: "+size+".");
		waiting = false;
		while(time > 0)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count();
		}
		
	}
	
	public void start()
	{
		name = ("Job "+jId);
		System.out.println(name + " has started.");
		if (t == null) {
			t = new Thread (this);
			t.start ();
		}
	}
	public boolean isWaiting()
	{
		return waiting;
	}
	
	public void setL(int k)
	{
		loca = k;
	}
	public void count()
	{
		time= time -1000;
		if (time <= 0)
		{
			System.out.println(jId + " has ended.");
			FixedPart.jobList.remove(this);
			FixedPart.busy[loca] = false;
			
		}
	}
	public int getTime()
	{
		return time;
	}
	public int getJobId()
	{
		return jId;
	}
	public int getSize()
	{
		return size;
	}
	public void setTime(int t)
	{
		time = t;
	}
	
}
