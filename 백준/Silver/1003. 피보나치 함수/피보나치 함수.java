import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	//  테스트케이스 수
		
		// 미리 40까지 구하기
		int [][] dp = new int[41][2];	//  dp[i][0]: i번째수에서 0이 호출되는 횟수,  dp[i][1]: i번째 수에서 1이 호출되는 횟수
		dp[0][0] = 1;
		dp[1][1] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;
		
		for(int i = 3; i <= 40; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-2][0];
			dp[i][1] = dp[i-1][1] + dp[i-2][1];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(dp[num][0]+" "+dp[num][1]+"\n");
		}
		
		System.out.println(sb);
		
		

	}

}
