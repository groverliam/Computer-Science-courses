/**
 * 
 * @author Liam Grover
 * Custom node class to be used with custom linked list class.
 */
public class MyNode {
	private double value;
	private MyNode next;
	private MyNode prev;
	/**
	 * Constructor
	 * @param v value that is stored in node.
	 */
	public MyNode(double v)
	{
		value = v;
		next = null;
	}
	/**
	 * Constructor
	 * @param v value stored in node.
	 * @param n next node in linked list.
	 * @param p previous node in linked list.
	 */
	public MyNode(double v, MyNode n, MyNode p)
	{
		value = v;
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
	 * @param v value to be assigned to the node.
	 */
	public void setValue(double v)
	{
		value = v;
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
	 * Get the value of the node.
	 * @return value
	 */
	public double getValue()
	{
		return value;
	}
}
