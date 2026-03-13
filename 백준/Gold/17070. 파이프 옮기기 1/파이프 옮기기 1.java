import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		int [][][] dp = new int[N][N][3];	// 0: 가로, 1: 세로, 2: 대각선
		dp[0][1][0] = 1;	// 시작 상태
		
		// 구현
		for(int i = 0; i < N; i++) {
			for(int j = 1; j < N; j++) {
				if(map[i][j] == 1) continue;
				
				// 가로
				if(i==0 && j==1) continue;
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
				
				// 세로
				if(i == 0) continue;
				dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
				
				// 대각선
				if(map[i-1][j] == 1 || map[i][j-1] == 1) continue; 
				dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
			}
		}
		
		System.out.println(dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2]);
		
	}

}
