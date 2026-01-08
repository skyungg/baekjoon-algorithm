import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] dp = new int[N+1];	// dp[i] :  i를 만드는데 필요한 최소 제곱수
		dp[0] = 0;
		
		for(int i = 1; i <= N; i++) {
			dp[i] = i;		// 1^2 로 i만들었다는 걸 초기값으로 설정
			for(int j = 1; j*j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
			
		}
		
		System.out.println(dp[N]);

	}

}
