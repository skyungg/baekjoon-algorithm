import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [][] map;
	static boolean [][] visited;
	static int [][] cost;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		cost = new int[N][M];
		
		int sx = 0;
		int sy = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					sx = i;
					sy = j;
				}
			}
		}
		
		// 탐색
		bfs(sx, sy);

		// 도달하지 못한 곳
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				
				if(i == sx && j == sy) {
					sb.append(0 + " ");
					continue;
				}
				if(!visited[i][j] && map[i][j] != 0) cost[i][j] = -1; 
				sb.append(cost[i][j]+" ");
			}
			sb.append("\n");
		}
		
		// 정답
		System.out.println(sb);
	}
	
	static void bfs(int x, int y) {
		int [] dx = {-1, 0, 1, 0};
		int [] dy = {0, 1, 0, -1};
		
		Queue<int []> que = new LinkedList<>();
		que.add(new int [] {x, y, 0});		// 위치, 비용
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = point[0] + dx[i];
				int ty = point[1] + dy[i];
				
				if(isRange(tx, ty) && !visited[tx][ty]) {		// 범위 조건 내, 방문 전  
					if(map[tx][ty] == 1) {	// 이동 가능지점
						cost[tx][ty] = point[2]+1;
						visited[tx][ty] = true;		// 방문 처리
						que.add(new int[] {tx, ty, cost[tx][ty]});
					}
				}
			}
		}
	}
	
	static boolean isRange(int x, int y) {
		return x >= 0&& x < N && y >= 0 && y < M;
	}
}
