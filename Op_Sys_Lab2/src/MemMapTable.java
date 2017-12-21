
public class MemMapTable {
	private Frame[] mmt = new Frame[10];

	public MemMapTable()
	{
		mmt[0] = new Frame(1);
		mmt[1] = new Frame(2);
		mmt[2] = new Frame(3);
		mmt[3] = new Frame(4);
		mmt[4] = new Frame(5);
		mmt[5] = new Frame(6);
		mmt[6] = new Frame(7);
		mmt[7] = new Frame(8);
		mmt[8] = new Frame(9);
		mmt[9] = new Frame(10);
	}
	
	
	
	public boolean isFrameFree(int index)
	{
		return mmt[index].isFree();
	}
	
	public void setFrameFree(int index)
	{
		mmt[index].setFree();
	}
	
	
	public void countFrames()
	{
		for(int i = 0; i < 10; i++)
		{
			if(!isFrameFree(i))
			{
				mmt[i].count();
			}
		}
	}
	public int getFreeFrameIndex(Job j)
	{
		int temp;
		for(int i = 0; i < 10; i++)
		{
			if(mmt[i].isFree())
			{
				temp = i;
				i = 10;
				mmt[temp].setBusy(j);
				return mmt[temp].getFrameNum();
			}
	
		}
		
		return -1; //have to make it print all are busy if it returns -1
		
	}
	
	public void jobDone(int i)
	{
		mmt[i].setFree();
	}
	
	public void fillT()
	{
		
	}
	
	public void addjob(Job j)
	{
		for(int i = 0; i < 10; i++)
		{
			if(mmt[i].isFree())
			{
				mmt[i].setJob(j);
				mmt[i].setBusy(j);
			}
		}
	}
	
	public void removejob(Job j, int i)
	{
		
				mmt[i].removeJob(j);
				mmt[i].setFree();
			
	}
	
	public void getMT()
	{
		System.out.println("Memory Map Table: ");

		for(int i = 0; i < mmt.length; i++)
		{
			mmt[i].printMT();
		}
		System.out.println("\n");

	}
	
}
