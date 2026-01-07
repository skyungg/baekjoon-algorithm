import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		long [] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		
		for(int i = 6; i <= 100; i++) {
			dp[i] = dp[i-2] + dp[i-3];
		}
		for(int t = 0; t < T; t++) {
			int num = Integer.parseInt(br.readLine());
			
			sb.append(dp[num]+"\n");
		}
		
		// 결과 출력
		System.out.println(sb);

	}

}
