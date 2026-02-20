import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
			
		int [] dp = new int[N];	// dp[i]: i번째 수를 마지막으로 했을 때, 최장 길이
		for(int i = 0; i < N; i++) dp[i] = 1;	// 적어도 자기자신 1개는 보장
		
		int result = 1;
		for(int i = 1; i < N; i++) {
			for(int j = i-1; j >= 0; j--) {
				if(A[i] > A [j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			result = Math.max(dp[i], result);
		}
		
		//출력
		System.out.println(result);

	}

}
