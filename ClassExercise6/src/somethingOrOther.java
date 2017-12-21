import java.util.Stack;


public class somethingOrOther {

	public static void main(String[] args) {
		int x= 12345;
		int y= 54321;
		Stack s = new Stack();
		System.out.println(x +" = x");
		System.out.println(y +" = y \n");

		while (x>0)
		{
			int d = x%10;
			s.push(d);
			x= x/10;
			System.out.println(x);

		}
		int m= 1;
		int z;
		while (!s.empty())
		{
			z = (int) s.pop();
			y += z*m;
			m= m*10;
			System.out.println(y);

		}
		System.out.println(x);
		System.out.println(y);

	}

}
