import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] graph = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			Queue<int []> que = new LinkedList<>();
			for(int j = 0; j < N; j++) {
				if(graph[i][j] == 1) {
					que.add(new int [] {j, i});
				}
			}
			
			while(!que.isEmpty()) {
				int [] point = que.poll();
				int x = point[0];
				int y = point[1];
				for(int k = 0; k < N; k++) {
					if(graph[x][k] == 1) {
						if(graph[i][k] == 0) {
							que.add(new int[] {k, x});
							graph[i][k] = 1;
						}
					}
				}
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(graph[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
