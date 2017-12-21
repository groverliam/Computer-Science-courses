/**
 * @author Robert Thompson
 * Dec 7, 2017
 */

public class TransitionLogic
{
	private int[] transitionInput;
	private int[] transitionOutput;
	
	public boolean firingStatus = false;

	public TransitionLogic (int numberTransitions)
	{
		transitionInput = new int [numberTransitions];
		transitionOutput = new int [numberTransitions];
	}
	
	public int [] getInput()
	{
		return transitionInput;
	}
	
	public int[] getOutput()
	{
		return transitionOutput;
	}
	
	public void setInput (int[] inputNum)
	{
		this.transitionInput = inputNum;
	}
	
	public void setOutput (int[] outputNum)
	{
		this.transitionOutput = outputNum;
	}
	
	public int[] subtractInputTransition (int[] markings)
	{
		for (int i = 0; i < transitionInput.length; i++)
		{
			if (markings[i] != -1)
			{
				markings[i] += transitionOutput[i];
			}
		}
		
		return markings;
	}
	
	public int[] addOutputTransition (int[] markings)
	{
		for (int i = 0; i < transitionOutput.length; i++)
		{
			if (markings[i] != -1)
			{
				markings[i] += transitionOutput[i];
			}
		}
		
		return markings;
	}
	
	public boolean isTransitionFireable (int[] markings)
	{
		for (int i = 0; i < transitionInput.length; i++)
		{
			if (markings[i] != -1)
			{
				if (markings[i] >= transitionInput[i])
				{
					firingStatus = true;
				}
				else
				{
					return false;
				}
			}
			else if (markings[i] == -1)
			{
				firingStatus = true;
			}
		}
		
		return firingStatus;
	}
	

}
