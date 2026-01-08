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
		}else if(N == 2 ) {
			System.out.println(3);
			return;
			
		}
		
		int [] dp = new int[N+1];
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i = 3; i <= N; i++) {
			dp[i] = (dp[i-1] + 2 * dp[i-2])%10007;	// 2*1은 n-1에다가 하나만 붙이면 됨, 2*2, 1*2는 n-2에서 가져오면 됨
		}
		
		System.out.println(dp[N]);
	}

}
