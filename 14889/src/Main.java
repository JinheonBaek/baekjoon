import java.util.*;

public class Main {
	static int N;
	static int[] team;
	static int[][] map;
	static int diff = 100;
	
	public static void main(String[] args)
	{
		init();
		dfs(0, 0);
		System.out.println(diff);
	}
	
	static void init()
	{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		team = new int[N];
		map = new int[N][N];
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();
		
		sc.close();
	}
	
	static void dfs(int n, int len)
	{
		if (len == N / 2)
		{
			teamScore();
		}
		else
		{
			for (int i = n + 1; i < N; i++)
			{
				team[i] = 1;
				dfs(i, len + 1);
			}
		}
		
		team[n] = 0;
		
	}
	
	static void teamScore()
	{
		int A = 0;
		int B = 0;
		
		for (int i = 0; i < N; i++)
		{
			for (int j = i + 1; j < N; j++)
			{
				if (team[i] == 0 && team[j] == 0)
					A += map[i][j] + map[j][i];
				else if (team[i] == 1 && team[j] == 1)
					B += map[i][j] + map[j][i];
			}
		}
		
		diff = Math.min(diff, Math.abs(A - B));
	}
}
