
public class JobTable {
	
	Job job;
	PageMapTable pmt;
	
	public JobTable()
	{
		
	}
	
	public JobTable(Job j)
	{
		job = j;
		pmt = new PageMapTable(j);
	}
	
	public PageMapTable getPmt()
	{
		return pmt;
	}
	
	public Job getJob()
	{
		return job;
	}
	
}
