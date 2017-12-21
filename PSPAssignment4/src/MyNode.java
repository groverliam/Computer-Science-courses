/**
 * 
 * @author Liam Grover
 * Custom node class to be used with custom linked list class.
 */
public class MyNode {
	private double valueX;
	private String nameX;
	private double valueY;
	private double valueZ;

	private MyNode next;
	private MyNode prev;
	public MyNode(double x)
	{
		valueX = x;
		next = null;
	}
	/**
	 * Constructor
	 * @param v value that is stored in node.
	 */
	public MyNode(double x, double y)
	{
		valueX = x;
		valueY = y;
		next = null;
	}
	
	public MyNode(String n, double y)
	{
		nameX = n;
		valueY = y;
		next = null;
	}
	
	/**
	 * Constructor
	 * @param v value that is stored in node.
	 */
	public MyNode(String n, double y, double z)
	{
		nameX = n;
		valueY = y;
		valueZ = z;
		next = null;
	}
	/**
	 * Constructor
	 * @param x x-value that is stored in node.
	 * @param y y-value that is stored in node.
	 * @param n next node in linked list.
	 * @param p previous node in linked list.
	 */
	public MyNode(String n, double y, double z, MyNode next, MyNode p)
	{
		nameX = n;
		valueY = y;
		valueZ = z;
		this.next = next;
		prev = p;
	}
	public MyNode(double x, double y, MyNode n, MyNode p)
	{
		valueX = x;
		valueY = y;
		next = n;
		prev = p;
	}
	/**
	 * Sets next node in linked list.
	 * @param n node to be set as next node.
	 */
	public void setNext(MyNode n)
	{
		next = n;
	}
	/**
	 * Sets node's value.
	 * @param x x-value that is stored in node.
	 * @param y y-value that is stored in node.
	 */
	public void setValue(double x, double y)
	{
		valueX = x;
		valueY = y;
	}
	/**
	 * Gets the next node.
	 * @return next 
	 */
	public MyNode getNext()
	{
		return next;
	}
	
	public String getName()
	{
		
		return nameX;
	}
	
	/**
	 * Get the x-value of the node.
	 * @return x-value 
	 */
	public double getXValue()
	{
		return valueX;
	}
	/**
	 * Get the y-value of the node.
	 * @return y-value 
	 */
	public double getYValue()
	{
		return valueY;
	}
}
