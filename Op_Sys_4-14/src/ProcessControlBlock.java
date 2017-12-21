
public class ProcessControlBlock {
	
	//make variables for each item needed for each job.
	int index;
	
	int time;
	
	
	
	public ProcessControlBlock(int index, int time)
	{
		this.index = index;
		this.time = time;
	}

	public int getPCBIndex()
	{
		return index;
	}
	
	public int getPCBTime()
	{
		return time;
	}
	
}
