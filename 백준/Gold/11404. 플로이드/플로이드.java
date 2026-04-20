import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int [][] dist = new int[N+1][N+1];
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= N; j++) {
				if(i == j) dist[i][j] = 0;
				else dist[i][j] = MAX;
			}
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			dist[a][b] = Math.min(dist[a][b], c);	// a -> b로 가는데 c
		}
		
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(dist[i][k] != MAX && dist[k][j] != MAX)
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(dist[i][j] == MAX) sb.append(0+" ");
				else sb.append(dist[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
		
		

	}

}
