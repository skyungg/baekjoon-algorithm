import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int [][] score = new int[2][n+1];
			
			for(int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= n; j++) {
					score[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int [][] dp = new int[2][n+1];	// 열 중심으로 판단
			dp[0][1] = score[0][1];
			dp[1][1] = score[1][1];
			
			for(int col = 2; col <= n; col++) {
				dp[0][col] = Math.max(dp[1][col-1], dp[1][col-2]) + score[0][col];	// 0행 선택했을 경우
				dp[1][col] = Math.max(dp[0][col-1], dp[0][col-2]) + score[1][col];	// 1행 선택했을 경우
			}
			
			sb.append(Math.max(dp[0][n], dp[1][n])+"\n");
		}
		
		System.out.println(sb);
		

	}

}
