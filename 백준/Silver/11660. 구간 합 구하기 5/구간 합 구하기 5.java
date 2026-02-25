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
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] =  tmp + map[i-1][j] + map[i][j-1] - map[i-1][j-1];	// (1, 1) - (i, j)까지의 사각형 합
				}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int sum = map[x2][y2] - map[x2][y1-1] - map[x1-1][y2] + map[x1-1][y1-1];	
			
			sb.append(sum+"\n");
		}
		
		// 정답 출력
		System.out.println(sb);

	}

}
