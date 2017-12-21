//Liam Grover
public class VendingMachineClass {
	/*
	 *Create instance variables:
	 *canNumber
	 *tokenNumber
	 */
	private int canNumber;
	private int tokenNumber;
	
	/*
	 * Create 2 constructors
	 * VendingMachineClass()
	 * Starts with 10 cans
	 * VendingMachineClass(int cansIn)
	 * canNumber = cansIn
	 */
	public VendingMachineClass()
	{
		canNumber = 10;
	}
	public VendingMachineClass(int cansIn)
	{
		canNumber = cansIn;
	}
	/*
	 * Create methods
	 * getters(2)
	 * token counter
	 * can adder and subract
	 */
	public void tokenCounter()
	{
		tokenNumber++;
	}
	public int getTokenNumber()
	{
		return tokenNumber;
	}
	public void canSubtract()
	{
		canNumber--;
	}
	public void canRefill()
	{
		canNumber= canNumber + 10;
	}
	public int getCans()
	{
		return canNumber;
	}
}
