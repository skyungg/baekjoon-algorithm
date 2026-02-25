import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [][] map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) + map[i][j-1];	// 누적합
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			for(int i = x1; i <= x2; i++) {
				sum += map[i][y2] - map[i][y1 - 1];			
			}
			
			sb.append(sum+"\n");
		}
		
		// 정답 출력
		System.out.println(sb);

	}

}
