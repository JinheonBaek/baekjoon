import java.util.*;

public class Main {
	static int N;
	static int[] A;
	static int[] op;
	static int max = -1000000000;
	static int min = 1000000000;
	
	public static void main(String[] args)
	{
		init();
		operation(0, 0, 0, 0, 0, A[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static void init()
	{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		A = new int[N];
		
		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		
		op = new int[4];
		
		for (int i = 0; i < 4; i++)
			op[i] = sc.nextInt();
		
		sc.close();
	}
	
	static void operation(int n, int add, int sub, int mul, int div, int sum)
	{
		if (n == N - 1)
		{
			min = Math.min(min, sum);
			max = Math.max(max, sum);
		}
		
		if (add < op[0])
		{
			operation(n + 1, add + 1, sub, mul, div, sum + A[n + 1]);
		}
		
		if (sub < op[1])
		{
			operation(n + 1, add, sub + 1, mul, div, sum - A[n + 1]);
		}
		
		if (mul < op[2])
		{
			operation(n + 1, add, sub, mul + 1, div, sum * A[n + 1]);
		}
		
		if (div < op[3])
		{
			operation(n + 1, add, sub, mul, div + 1, sum / A[n + 1]);
		}
		
	}
}
