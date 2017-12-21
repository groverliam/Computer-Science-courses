/*
 * Car
 *- gas: double
 *- mpg: double
 *+ Car ()
 *+ Car (gas: double)
 *+ addGas (amount: double):void
 *+ drive(amount: double): void
 *+ gasLeft(): double
 */
/**
 * This class is to determine the amount of gas available and the distance possible. 
 * @author Liam Grover
 *
 */
public class Car {
	//- gas: double
	private double gas;
	//- mpg: double
	private double mpg;
	//+ Car ()
	/**
	 * This creates a car object
	 */
	public Car()
	{
		
	}
	//+ Car (gas: double)
	/**
	 * This creates a car object with parameters.
	 * @param amount amount of mpg the car has
	 */
	public Car(double amount)
	{
		mpg= amount;
	}
	//+ addGas (amount: double):void
	/**
	 * Adds gas to the car
	 * @param amount amount of gas to add to current amount
	 */
	public void addGas(double amount)
	{
		gas= gas + amount;
		
	}
	//+ drive(amount: double): void
	/**
	 * Uses formula to decrease the gas by the appropriate amount.
	 * @param amount distance driven by car.
	 */
	public void drive(double amount)
	{
		gas = (gas- (amount/mpg));
	}
	//+ gasLeft(): double
	/**
	 * This returns the amount of gas left in car and a worded response if needed.
	 * @return returns the amount of gas
	 */
	public double gasLeft()
	{
		if(gas == 0.0)
		{
		System.out.println("You ran out of gas.");
		return gas;
		}
		else if (gas<0)
		{
			System.out.println("You ran out of gas, you cannot drive that far.");
			return gas;
		}
		else 
		{
			return gas;
		}
	}
}