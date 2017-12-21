public class Job {
	private int exTime;
	private int size;
	private int id;
	private int pageAmount; 
	private Job[] pages;
	private int mmtLoca;
	private boolean complete = false;
	private boolean running = false;
	
	public Job()
	{
		
	}
	
	public Job(int id, int s, int t)
	{
		this.id = id;
		size = s;
		exTime = t/1000;
		pageAmount = getNumPages();
		pages = new Job[pageAmount];
		mmtLoca = -1;
		//page();
	}

	public boolean complete()
	{
		return complete;
	}
	
	public boolean running()
	{
		return running;
	}
	
	public void endJob()
	{
		complete = true;
	}

	public void printPages()
	{
		System.out.println("Job "+getId()+" Page Table: ");

		for(int i = 0; i < pageAmount; i++)
		{
			pages[i].print();
		}
		System.out.println("\n");

	}
	
	public boolean done()
	{
		return complete;
	}
	
	public Job getPage(int index)
	{
		return pages[index];
	}
	
	public int getId()
	{
		return id;
	}

	public int getTime()
	{
		return exTime;
	}

	public int getSize()
	{
		return size;
	}
	
	public void setRunning()
	{
		running = true;
	}
	
	public void minusOne()
	{
		// its in ms so we will subtract 1000 each time a job is entered.
		exTime = exTime - 1;
//System.out.println("time is now: "+exTime);
		//if(exTime >= 0)
		//{
		//	complete = true;
		//}
	}
	
	public int getML()
	{
		return mmtLoca;
	}
	
	public void setML(int l)
	{
		mmtLoca = l;
	}
	
	public int getNumPages()
	{

		if(size >= 100)
		{
			pageAmount = (int) Math.round(size/100.0);
		}
		else if(size > 0)
		{
			pageAmount = 1;
		}
		else
		{
			pageAmount = 0;
		}
		return pageAmount;
	}
	
	public void page()
	{
		
		int splitTime = exTime/pageAmount;
		int leftover = size;
		int page = pageAmount;
		for(int i = 0; i < pageAmount; i++)
		{	
			if(size >= 100)
			{
				pages[i] = new Job(i, 100, splitTime);
				leftover = size-100;
				page--;
			}
			else 
			{
				pages[i] = new Job(i, leftover, splitTime);
			}
		}
	}
	
	public void printPT()
	{
		System.out.println("Job "+getId()+" Page Table: ");
		for(int i = 0; i < pageAmount; i++)
		{	
		if(getML() != (-1) && getML() != 999)
		{
			System.out.println("ID: "+pages[i].getId()+" Memory map location: "+ pages[i].getML());
		}
		else
		{
			System.out.println("ID: "+pages[i].getId()+" Memory map location: N/A");
		}
		}
		System.out.println("\n");

		//System.out.println("ID: "+getId()+", Size: "+getSize()+", Executable Time: "+getTime());
	}
	
	public void print()
	{
		System.out.println("ID: "+getId()+", Size: "+getSize()+", Executable Time: "+getTime()+" seconds.");
	}
	
}
