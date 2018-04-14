import java.util.*;

public class Main {
	static int N, M;
	static int r, c, d;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int map[][];
	
	public static void main(String[] args)
	{
		init();
		
		map[r][c] = 2;
		sweep(r, c, d);
		
		count();
	}
	
	static void init()
	{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		r = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();
		
		sc.close();
	}
	
	static void sweep(int r, int c, int d)
	{	
		int next_d = d;
		
		for (int i = 0; i < 4; i++)
		{
			next_d = (next_d + 3) % 4;
			
			if (r + dx[next_d] < 0 || r + dx[next_d] >= N || c + dy[next_d] < 0 || c + dy[next_d] >= M || map[r + dx[next_d]][c + dy[next_d]] == 1)
				continue;
			
			if(map[r + dx[next_d]][c + dy[next_d]] == 0)
			{
				map[r + dx[next_d]][c + dy[next_d]] = 2;
				sweep(r + dx[next_d], c + dy[next_d], next_d);
				return;
			}
		}
		
		next_d = (d + 2) % 4;
		
		if (map[r + dx[next_d]][c + dy[next_d]] == 1)
			return;
		else
			sweep(r + dx[next_d], c + dy[next_d], d);
		
	}
	
	static void count()
	{
		int cnt = 0;
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[i][j] == 2)
					cnt++;
		
		System.out.println(cnt);
	}
	
	static void print()
	{
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < M; j++)
				System.out.print(map[i][j]);
			System.out.println("");
		}
	}
}
