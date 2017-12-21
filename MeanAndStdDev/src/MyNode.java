
public class MyNode {
	private double value;
	private MyNode next;
	private MyNode prev;
	
	public MyNode(double v)
	{
		value = v;
		next = null;
	}
	/*public MyNode(double v, MyNode n)
	{
		value = v;
		next = n;
	}*/
	public MyNode(double v, MyNode n, MyNode p)
	{
		value = v;
		next = n;
		prev = p;
	}
	public void setNext(MyNode n)
	{
		next = n;
	}
	/*public void setPrev(MyNode p)
	{
		prev = p;
	}*/
	public void setValue(double v)
	{
		value = v;
	}
	public MyNode getNext()
	{
		return next;
	}
	/*public MyNode getPrev()
	{
		return next;
	}*/
	
	public double getValue()
	{
		return value;
	}
	
}
