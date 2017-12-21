
public class MMT {
	private boolean free;
	private int frameNum;
	private int frameSize = 100;
	private Job job = null;
	
	public MMT(int index)
	{
		free = true;
		frameNum = index;
	}
	public MMT()
	{
		free = true;
	}
	
	public void addJob(Job j)
	{
		job = j;
		free = false;
	}
	
	public int getFrameNum()
	{
		return frameNum;
	}
	
	public void removeJob()
	{
		job = null;
		free = true;
	}
	
	public boolean getStat()
	{
		return free;
	}
	
	public void printMT()
	{
		//System.out.println("Memory Map Table: ");
		System.out.println("Frame #: " + getFrameNum()+ ", Free Status: " + getStat());

	}
	
	public int getML()
	{
		return job.getML();
	}
	
	public void setML(int i)
	{
		job.setML(i);
	}
}
