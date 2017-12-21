/**
 * @author Robert Thompson, Alexander Kaczynski, Liam Grover
 * April 5, 2017
 */

public class SENode<E>
{
	private double element;
	private SENode<E> next;
	
	public SENode(double e)
	{
		this.element = e;
		next = null;
	}
	
	public double getElement()
	{
		return element;
	}
	
	public SENode<E> getNext()
	{
		return next;
	}
	
	public void setNext(SENode<E> n)
	{
		this.next = n;
	}
}
