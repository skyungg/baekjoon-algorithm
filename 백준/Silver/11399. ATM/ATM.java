import java.io.*;
import java.util.*;

public class Main {

	public static void main(String [] args) throws IOException{
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬 시간 오름차순 
		Arrays.sort(arr);
		
		int sum = 0;
		int [] dp = new int[N+1];
		dp[0] = 0;
		for(int i = 1; i <= N; i++) {
			dp[i] = dp[i-1] + arr[i-1];
			sum += dp[i];
		}
		
		System.out.println(sum);
	}

}
