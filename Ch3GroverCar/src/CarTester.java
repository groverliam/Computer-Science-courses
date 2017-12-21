//Algorithm
//Create a car with 50 mpg
//add 20 gallons of gas
//Read gas
//drive 300 miles
//Check and display the gas left
//it should be 14 gallons
//create a 2nd car with 15 mpg
//add 20 gallons of gas
//Read gas
//drive 300 miles
//Check and display the gas left
//it should be 0 gallons
//create a 3nd car with 10 mpg
//add 20 gallons of gas
//Read gas
//drive 300 miles
//Check and display the gas left
//it should read that you cannot go that far
//it should be -10 gallons
//Put more gas in 
//Read the gas

public class CarTester {

	public static void main(String[] args)
	{
		//Create a car with 50 mpg
		Car myHybrid = new Car(50);
		//add 20 gallons of gas
		myHybrid.addGas(20);
		//Read gas
		System.out.println("Gas put in hybrid is 20 gallons.");
		//drive 300 miles
		myHybrid.drive(300);
		//Check and display the gas left
		System.out.println("Gas left in hybrid is: "+myHybrid.gasLeft()+" gallons.");
		//it should be 14 gallons
		System.out.println("Gas left in hybrid should be 14.0 gallons.");
		System.out.println("");
		
		
		//create a 2nd car with 15 mpg
		Car mySedan = new Car(15);
		//add 20 gallons of gas
		mySedan.addGas(20);
		//Read gas
		System.out.println("Gas put in sedan is 20 gallons.");
		//drive 300 miles
		mySedan.drive(300);
		//Check and display the gas left
		System.out.println("Gas left in sedan is: "+mySedan.gasLeft()+" gallons.");
		//it should be 0 gallons
		System.out.println("Gas left in sedan should be 0.0 gallons.");
		System.out.println("");

		
		//create a 3nd car with 10 mpg
		Car mySuv = new Car(10);
		//add 20 gallons of gas
		mySuv.addGas(20);
		//Read gas
		System.out.println("Gas put in SUV is 20 gallons.");
		//drive 300 miles
		mySuv.drive(300);
		//Check and display the gas left
		//it should read that you cannot go that far
		System.out.println("Gas left in SUV is: "+mySuv.gasLeft()+" gallons.");
		//it should be -10 gallons
		System.out.println("Gas left in SUV should be -10.0 gallons.");
		//Put more gas in 
		mySuv.addGas(40);
		//Read the gas
		System.out.println("Gas put in SUV is 40 gallons.");
		System.out.println("Gas left in SUV is: "+mySuv.gasLeft()+" gallons.");
		System.out.println("Gas left in SUV should be 30.0 gallons.");
		
	}
}
