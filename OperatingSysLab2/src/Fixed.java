
public class Fixed {
	
	public static void main (String [] args)
	{
		
		Job j = new Job();
		j.addJob("one", 65.9);
		j.addJob("two", 67.2);
		j.addJob("three", 74.9);
		j.addJob("four", 99.9);
		j.addJob("five", 5.6);
		j.addJob("six", 25.4);
		j.addJob("seven", 37.8);
		j.addJob("eight", 50.1);
		j.addJob("nine", 84.3);
		j.addJob("ten", 1.0);
		
		//j.printWaiting();
		/*j.runWaiting("one");
		j.countRunning();
		j.runWaiting("two");
		j.countRunning();
		j.runWaiting("three");
		j.countRunning();
		j.runWaiting("four");
		*/
		 
		while(j.getWaitLength() != 0)
		{
			j.runAllWaiting();
			j.countRunning();
		}
		while(j.going())
		{
			
			
			j.countRunning();
			
			
		}
		System.out.println("\n ALL JOBS ARE COMPLETE!");
	}

}
