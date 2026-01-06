import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int [] dp = new int[12];
		dp[1] = 1;	// 1
		dp[2] = 2;	// 1+1, 2
		dp[3] = 4; // 1+1+1, 1+2, 2+1, 3
		
		for(int i = 4; i < 12; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int test_num = Integer.parseInt(br.readLine());
			sb.append(dp[test_num]+"\n");
		}
		
		System.out.println(sb);
	}

}
