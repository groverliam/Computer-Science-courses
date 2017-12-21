/**
 * 
 * @author Liam Grover
 * This is a custom made singly linked list class.
 */
public class MyLinkedList {
	private MyNode head;
	private MyNode tail;
	private int size;
	/**
	 * Constructor
	 */
	public MyLinkedList()
	{
		
	}
	public void add1(double x)
	{
		size++;
		if(head == null)
		{
			head = new MyNode(x);
			tail = head;
		}
		else
		{
			MyNode n = new MyNode(x);
			n.setNext(head);
			head = n;
		}
	}
	/**
	 * Adds a new node to the linked list.
	 * @param x x-value that is stored into a newly added node.
	 * @param y y-value that is stored into a newly added node.
	 */
	public void add2(double x, double y)
	{
		size++;
		if(head == null)
		{
			head = new MyNode(x, y, null, null);
			tail = head;
		}
		else
		{
			MyNode n = new MyNode(x, y, head, null);
			n.setNext(head);
			head = n;
		}
	}
	/**
	 * Adds a new node to the linked list.
	 * @param x x-value that is stored into a newly added node.
	 * @param y y-value that is stored into a newly added node.
	 */
	public void addnd(String name, double y)
	{
		size++;
		if(head == null)
		{
			head = new MyNode(name, y);
			tail = head;
		}
		else
		{
			MyNode n = new MyNode(name, y);
			n.setNext(head);
			head = n;
		}
	}
	public void add3(String name, double y, double z)
	{
		size++;
		if(head == null)
		{
			head = new MyNode(name, y, z, null, null);
			tail = head;
		}
		else
		{
			MyNode n = new MyNode(name, y, z, head, null);
			n.setNext(head);
			head = n;
		}
	}
	/**
	 * Checks to see if linked list is empty.
	 * @return boolean on whether or not the list is empty.
	 */
	public boolean isEmpty()
	{
		if(head == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Removes first node in the linked list.
	 */
	public void removeFirst()
	{
		if(head!= null)
		{
			size--;
			head = head.getNext();
		}
		else
		{
			head = null;
			tail = null;
		}
	}
	/**
	 * Gets size of the linked list.
	 * @return size
	 */
	public int getSize()
	{
		return size;
	}
	
	public String getName()
	{
		String contents;
		contents = head.getName();
		return contents;
	}
	
	/**
	 * Gets value of the head node.
	 * @return contents
	 */
	public double getXValue()
	{
		double contents;
		contents = head.getXValue();
		return contents;
	}
	
	public double getYValue()
	{
		double contents;
		contents = head.getYValue();
		return contents;
	}
}
