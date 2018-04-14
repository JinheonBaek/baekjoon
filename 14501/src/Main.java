import java.util.*;

public class Main {
	static int N;
	static int[] T, P;
	static int result = 0;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		T = new int[N];
		P = new int[N];
		
		for (int i = 0; i < N; i++)
		{
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		dfs(0, 0);
		
		System.out.println(result);
		
		sc.close();
	}
	
	static void dfs(int i, int sum)
	{
		if (i == N)
			result = Math.max(sum, result);
		
		if (i < N && i + T[i] <= N)
		{
			dfs(i + T[i], sum + P[i]);
		}
		
		if (i < N)
		{
			dfs(i + 1, sum);
		}
		
	}
}
