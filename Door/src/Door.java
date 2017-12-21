/**
 * The door class implements a door.
 * The doors can be altered in state and name.
 * @author Liam Grover
 * 
 *
 */
public class Door 
{

	private String state;
	private String name;
	/**
	 * This is the constructor for the door.
	 * @param initialState The state of the door.
	 * @param newName The name of the door.
	 */
	public Door(String newName,String initialState)
	{
		state= initialState;
		name= (newName);
	}
	public Door()
	{
		state= "closed";
	}
	public void close()
	{
		state= "closed";
	}
	public void open()
	{
		state= "open";
	}
	public void setName(String newName)
	{
		name= (newName+" ");
	}
	/**
	 * This returns the name of the door.
	 * @return The name of the door.
	 */
	public String getName()
	{
		return name;
	}
	public void setState(String newState)
	{
		if(newState.equals("open")||newState.equals("closed")||newState.equals("close"))
		{
			state= newState;
		}
		else
		{
			state= "error";
		}
	}
	public String getState()
	{
		return state;
	}
}

