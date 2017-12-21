import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ProcessorManager implements Runnable{

	ReentrantLock lock = new ReentrantLock();
	Thread t;
	static ArrayList<ProcessControlBlock> readyQueue = new ArrayList<ProcessControlBlock>();
	//static ArrayList<Job> readyQueue = new ArrayList<Job>();
	//ProcessControlBlock pcb = new ProcessControlBlock();
	Job shortest = null;
	static int s;
	int Mindex;
	int Sindex;

	public ProcessorManager()
	{

	}

	public void run()
	{
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		runSJN();
		
		System.out.println(MemoryManager.MMT);
		

	}

	public void start()
	{

		if (t == null) {
			t = new Thread (this);
			t.start ();
		}
	}

	public void runSJN()
	{
		lock.lock();
		
		try{
		for(int i = 0; i < readyQueue.size(); i++)
			{
			
				if(s==0)
				{
					s = readyQueue.get(i).getPCBIndex();
				}
				else if (readyQueue.get(i).getPCBTime() < readyQueue.get(s).getPCBTime())
				{
					s = readyQueue.get(i).getPCBIndex();
				}
			}
		} finally {
		try{
			MemoryManager.MMT.get(s).start();
		} catch (IllegalThreadStateException e) {
			
		}
		System.out.println(MemoryManager.MMT);
		lock.unlock();
		}
	}
	

}
