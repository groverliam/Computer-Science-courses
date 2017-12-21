
public class Frame {
	private boolean free;
	private int frameNum;
	private int frameSize;
	private Job job;
	
	public Frame(int index)
	{
		free = true;
		frameSize = 100;
		frameNum = index;
	}
	
	public int getFrameNum()
	{
		return frameNum;
	}
	
	public void setFrameNum(int index)
	{
		frameNum = index;
	}
	
	public boolean isFree()
	{
		return free;
	}
	
	public void setBusy(Job job)
	{
		this.job = job;
		free = false;
	}
	
	public void count()
	{
		job.minusOne();
		if(job.getTime() <= 0)
		{
			job.endJob();
			job = null;
			setFree();
		}
		else
		{
			System.out.println("Time: "+job.getTime());
		}
	}
	
	public void setFree()
	{
		free = true;
	}
	
	public void printMT()
	{
		//System.out.println("Memory Map Table: ");
		System.out.println("Frame #: " + getFrameNum()+ ", Status: " + isFree());

	}

	public int getFreeFrameIndex(Frame[] mmt, Job j)
	{
		int temp;
		for(int i = 0; i < 10; i++)
		{
			if(isFree())
			{
				temp = i;
				i = 10;
				setBusy(j);
				return getFrameNum();
			}
	
		}
		
		return -1; //have to make it print all are busy if it returns -1
		
	}
	
	public void setJob(Job j)
	{
		job = j;
		
	}
	
	public void removeJob(Job j)
	{
		job = null;
	}
	
	public Job getJob()
	{
		return job;
	}
}
