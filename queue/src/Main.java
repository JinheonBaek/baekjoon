import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		Queue que = new LinkedList();
		
		que.add("A");
		que.add("B");
		que.add("C");
		
		System.out.println("## Queue ##");
		
		while(!que.isEmpty())
		{
			System.out.println(que.poll());
		}
	}
}
