import java.io.*;
import java.util.*;

/*
 * 현재 값은 이전값 영향 받음 -> dp로 접근해보자
 * */
public class Main {
	static int N;
	static int [][] map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][3];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int [][][] dp = new int[N][3][2];
		for(int j = 0; j < 3; j++) {
			dp[0][j][0] = map[0][j];	// 최댓값
			dp[0][j][1] = map[0][j];	// 최솟값
		}
		
		for(int i = 1; i < N; i++) {
			dp[i][0][0] = Math.max(dp[i-1][0][0], dp[i-1][1][0]) + map[i][0];
			dp[i][0][1] = Math.min(dp[i-1][0][1], dp[i-1][1][1]) + map[i][0];

			dp[i][1][0] = Math.max(Math.max(dp[i-1][1][0], dp[i-1][0][0]), dp[i-1][2][0]) + map[i][1];
			dp[i][1][1] = Math.min(Math.min(dp[i-1][1][1], dp[i-1][0][1]), dp[i-1][2][1]) + map[i][1];
			
			dp[i][2][0] = Math.max(dp[i-1][1][0], dp[i-1][2][0]) + map[i][2];
			dp[i][2][1] = Math.min(dp[i-1][1][1], dp[i-1][2][1]) + map[i][2];
			
		}
		
		// 정답
		int maxResult = 0;
		int minResult = Integer.MAX_VALUE;
		for(int j = 0; j < 3; j++) {
			maxResult = Math.max(maxResult, dp[N-1][j][0]);
			minResult = Math.min(minResult, dp[N-1][j][1]);
		}
		
		// 출력
		System.out.println(maxResult+" "+minResult);
		
		
	}

}
