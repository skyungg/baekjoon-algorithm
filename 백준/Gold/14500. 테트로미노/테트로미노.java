import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [][] map;
	static boolean [][] visited;
	static int result = 0;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 완탐
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, map[i][j], 1);
				visited[i][j] =false;	// 복구
			}
		}
		
		// 출력
		System.out.println(result);
		

	}
	
	static void dfs(int x, int y, int sum, int count) {
		if(count == 4) {
			// 4피스 모임
			result = Math.max(result, sum);
			return;
		}
		
		// 상하좌우 탐색
		for(int i = 0; i < 4; i++) {
			int tx = dx[i] + x;
			int ty = dy[i] + y;
			
			if(!isRange(tx, ty)) continue;	// 범위 밖
			
			if(!visited[tx][ty]) {
				if(count == 2) {
					visited[tx][ty] = true;
					dfs(x, y, sum + map[tx][ty], count+1);
					visited[tx][ty] = false;
				}
				
				visited[tx][ty] = true;
				dfs(tx, ty, sum + map[tx][ty], count+1);
				visited[tx][ty] = false;
			}
		}
	}
	
	static boolean isRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
