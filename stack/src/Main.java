import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		Stack stk = new Stack();
		
		stk.push("A");
		stk.push("B");
		stk.push("C");
		
		System.out.println("## Stack ##");
		
		while(!stk.isEmpty())
		{
			System.out.println(stk.pop());
		}
	}
}
