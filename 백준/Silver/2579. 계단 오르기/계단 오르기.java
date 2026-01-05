import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N+1];
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int [] dp = new int[N+1];
		
		if(N == 1) {
			System.out.println(arr[1]);
		}else if(N == 2) {
			System.out.println(arr[2]+arr[1]);
		}else {
			dp[1] = arr[1];
			dp[2] = arr[1]+arr[2];		// 연속 계단 오른게 최댓값
			dp[3] = Math.max(arr[1]+arr[3], arr[2]+arr[3]);		// 첫번째 계단+세번째계단, 두번째계단+세번째계단 중 최댓값 선택
			
			for(int i = 4; i <= N; i++) {
				dp[i] = Math.max(dp[i-2]+arr[i], +dp[i-3]+arr[i-1]+arr[i]);	// 바로이전 계단+현재계단, 세번째 전+바로 이전+현재
			}
			
			System.out.println(dp[N]);			
		}
	}

}
