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
		
		int [] dp1 = new int[N];	// i에서 끝나는 증가하는 부분수열의 최대 길이
		int [] dp2 = new int[N];	// i에서 시작하는 감소하는 부분수열의 최대 길이
		
		// 증가하는 부분수열
		for(int i = 0; i < N; i++) {
			dp1[i] = 1;	// 초기값
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					dp1[i] = Math.max(dp1[i], dp1[j]+1);
				}
			}
		}
		
		// 감소하는 부분수열
		for(int i = N-1; i >= 0; i--) {
			dp2[i] = 1;	// 초기값
			for(int j = N-1; j > i; j--) {
				if(nums[j] < nums[i]) {
					dp2[i] = Math.max(dp2[i], dp2[j]+1);
				}
			}
		}
		
		// 결과
		int result = 0;
		for(int i = 0; i < N; i++) {
			result = Math.max(result, dp1[i]+dp2[i]-1);
		}
		
		// 출력
		System.out.println(result);
		
		
	}

}
