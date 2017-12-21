
public class MyLinkedList {
	private MyNode head;
	private MyNode tail;
	private int size;
	
	public MyLinkedList()
	{
		
	}
	public void add(double v)
	{
		size++;
		if(head == null)
		{
			head = new MyNode(v, null, null);
			tail = head;
		}
		else
		{
			MyNode n = new MyNode(v, head, null);
			n.setNext(head);
			head = n;
		}
	}
	/*public void addLast(double v)
	{
		size++;
		if(tail == null)
		{
			head = new MyNode(v, null, null);
			tail = head;
		}
		else
		{
			MyNode n = new MyNode(v, tail, null);
			n.setPrev(tail);
			tail= n;
		}
	}*/
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
	public void removeFirst()
	{
		//MyNode temp = null;
		if(head!= null)
		{
			size--;
			//temp = head.getValue();
			head = head.getNext();
		}
		else
		{
			head = null;
			tail = null;
		}
	}
	/*public void removeLast()
	{
		//MyNode temp = null;
		if(tail!= null)
		{
			size--;
			//temp = head.getValue();
			tail = tail.getPrev();
		}
		else
		{
			head = null;
			tail = null;
		}
	}*/
	public int getSize()
	{
		return size;
	}
	/*public void show()
	{
		//MyLinkedList temp = new MyLinkedList();
		//temp = l;
		for(int i = 0; i < size; i++)
		{
			System.out.println();
		}
	}*/
	public double getValue()
	{
		double contents;
		contents = head.getValue();
		return contents;
	}
	
}
