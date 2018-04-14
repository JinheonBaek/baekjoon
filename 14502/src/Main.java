import java.util.*;

public class Main {

	static int N, M;
	static int map[][], visit[][];
	static int safety_area_size = 0;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		// Input Map Size
		N = sc.nextInt();
		M = sc.nextInt();
		
		// Initialize Map
		map = new int[N][M];
		visit = new int[N][M];
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();
		
		for (int i = 0; i < N * M; i++)
		{
			int row = i / M;
			int col = i % M;
			
			if (map[row][col] == 0)
			{
				map[row][col] = 1;
				makeBlock(i, 1);
				map[row][col] = 0;
			}
	
		}
	
		System.out.println(safety_area_size);
		
		sc.close();
		
	}
	
	static void mapSetting()
	{
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				visit[i][j] = map[i][j];
	}
	
	// put block based on DFS
	static void makeBlock(int v, int cnt)
	{
		
		if (cnt == 3)
		{
			mapSetting();
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < M; j++)
				{
					if (visit[i][j] == 2)
					{
						spreadVirus(i, j);
					}
				}
			}	
			safetyArea();
		}
		else
		{
			for (int i = v + 1; i < N * M; i++)
			{
				int r = i / M;
				int c = i % M;
				
				if (map[r][c] == 0)
				{
					map[r][c] = 1;
					makeBlock(i, cnt + 1);
					map[r][c] = 0;
				}
			}
		}
	}
	
	// spread virus based on BFS
	static void spreadVirus(int row, int col)
	{	
		for (int i = 0; i < 4; i++)
		{
			int nextRow = row + dx[i];
			int nextCol = col + dy[i];
			
			if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M)
			{
				if(visit[nextRow][nextCol] == 0)
				{
					visit[nextRow][nextCol] = 2;
					spreadVirus(nextRow, nextCol);	
				}
			}
		}
	}
	
	static void safetyArea()
	{
		int tmp_safety_area_size = 0;
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (visit[i][j] == 0)
					tmp_safety_area_size ++;
		
		safety_area_size = Math.max(safety_area_size, tmp_safety_area_size);
	}
	
}
