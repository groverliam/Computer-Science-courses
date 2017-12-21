import java.util.*;
public class PageMapTable {
	private int numOfPages;
	HashMap<Job,Integer> pt = new HashMap<Job, Integer>();
	
	
	public PageMapTable(Job j)
	{
		numOfPages = j.getNumPages();
		for(int i = 1; i<= numOfPages; i++ )
		{
			if (i != numOfPages)
			{
				pt.put(j, -1);
			}
		}
	}

	public void setPlacedFramed(int page, int frame)
	{
		if()
		table[page] = frame;
	}

	public int getPlacedFrame(int page)
	{
		return table[page];
	}

	public int getNumPages(Job j)
	{
		int size = j.getSize();

		if(size>100)
		{
			numOfPages = (int) Math.round(size/100.0);
		}
		else if(size > 0)
		{
			numOfPages = 1;
		}
		else
		{
			numOfPages = 0;
		}
		return numOfPages;
	}

}
