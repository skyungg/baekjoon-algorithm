import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N == 1) {
			System.out.println(1);
			return;
		}
		if(N == 2) {
			System.out.println(2);
			return;
		}
		
		int [] dp = new int[N+1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		for(int i = 4; i <= N; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		} 
		
		// 결과 출력
		System.out.println(dp[N]);
		
	}

}
