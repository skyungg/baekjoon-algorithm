import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int [] dp = new int[N];		//dp[i] : i를 마지막 숫자로 했을때, 가장 긴 증가 수열의 값
		
		for(int i = 0; i < N; i++) {
			dp[i] = 1;	// 자기자신
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		// 정답 출력
		int result = 0;
		for(int i = 0; i < N; i++) {
			result = Math.max(result, dp[i]);
		}
		
		System.out.println(result);

	}

}
