import java.util.*;

public class Main {
	static int K;
	static int[][] rotate;
	static int[][] state = new int[4][8];
	
	public static void main(String[] args)
	{
		init();
		
		for (int i = 0; i < K; i++)
		{
			go(i, rotate[i][0] - 1);
		}
		
		int sum = 0;
		if (state[0][0] == 1) sum += 1;
		if (state[1][0] == 1) sum += 2;
		if (state[2][0] == 1) sum += 4;
		if (state[3][0] == 1) sum += 8;
		
		System.out.println(sum);
	}
	
	static void init()
	{
		Scanner sc = new Scanner(System.in);
		
		String tmp;
		
		for (int i = 0; i < 4; i++)
		{
			tmp = sc.nextLine();
			for (int j = 0; j < 8; j++)
			{
				state[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		K = sc.nextInt();
		
		rotate = new int[K][2];
		
		for (int i = 0; i < K; i++)
			for (int j = 0; j < 2; j++)
				rotate[i][j] = sc.nextInt();
		
		sc.close();
	}
	
	static void go(int i, int wheel)
	{
		int[] dir = {0, 0, 0, 0};
		dir[wheel] = rotate[i][1];
		
		int nextIndex = wheel - 1;
		while (true)
		{
			if (nextIndex < 0)
				break;
			if (state[nextIndex + 1][6] == state[nextIndex][2])
				break;
			else
			{
				dir[nextIndex] = - dir[nextIndex + 1];
				nextIndex--;
			}
		}
		
		nextIndex = wheel + 1;
		while(true)
		{
			if (nextIndex > 3)
				break;
			if (state[nextIndex - 1][2] == state[nextIndex][6])
				break;
			else
			{
				dir[nextIndex] = - dir[nextIndex - 1];
				nextIndex++;
			}
		}
		
		for (int j = 0; j < 4; j++)
			if (dir[j] == 1)
				clkRotate(j);
			else if (dir[j] == -1)
				cntClkRotate(j);
	}
	
	static void clkRotate(int i)
	{
		int temp = state[i][7];
		
		for (int j = 7; j > 0; j--)
			state[i][j] = state[i][j - 1];
		
		state[i][0] = temp;
	}
	
	static void cntClkRotate(int i)
	{
		int temp = state[i][0];
		
		for (int j = 0; j < 7; j++)
			state[i][j] = state[i][j+1];
		
		state[i][7] = temp;
	}
}
