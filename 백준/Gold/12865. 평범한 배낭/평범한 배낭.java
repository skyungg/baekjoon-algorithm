import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int [][] arr = new int[N+1][2];	//(무게, 가치)
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());	// 무게
			arr[i][1] = Integer.parseInt(st.nextToken());	// 가치
		}
		
		int [][] dp = new int[N+1][K+1];	//i번째 물건까지 고려했을 때, w에서의 최대 가치

		for(int i = 1; i <= N; i++) {
			int weight = arr[i][0];
			int value = arr[i][1];
			
			for(int w = 0; w <= K; w++) {
				if(w < weight) {	// 현재 물건 선택 못하는 경우
					dp[i][w] = dp[i-1][w];	// 이전 물건까지의 최적값으로 저장
				}else {
					// 현재 물건 선택 가능한 경우
					// 안담기 vs (현재물건 + 남음 무게 최적값) 비교
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weight] + value);
				}
			}
		}
		
		// 정답 출력
		System.out.println(dp[N][K]);

	}

}
