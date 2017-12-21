/**
 * 
 * @author Liam Grover
 * Custom node class to be used with custom linked list class.
 */
public class MyNode {
	private double valueX;
	private double valueY;
	private MyNode next;
	private MyNode prev;
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
	/**
	 * Constructor
	 * @param x x-value that is stored in node.
	 * @param y y-value that is stored in node.
	 * @param n next node in linked list.
	 * @param p previous node in linked list.
	 */
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
