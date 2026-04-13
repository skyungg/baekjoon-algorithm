import java.io.*;
import java.util.*;

/*
 * 함정: 아무 지역도 물에 잠기지 않을 수도 있다.
 * -> 0부터 최고 높이까지 돌리기
 * */
public class Main {
	static int N;
	static int [][] map;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		int high = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				high = Math.max(high, map[i][j]);	// 가장 높은 높이
			}
		}
		
		int count = 0;
		boolean [][] visited;
		for(int h = 0; h < high; h++) {
			visited = new boolean[N][N];
			
			// 물 잠기기
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] > h && !visited[i][j]) {
						bfs(i, j, h, visited);
						cnt++;
					}
				}
			}
			
			// 3. 안전영역 판단
			count = Math.max(count, cnt);
		}
		
		// 정답 출력
		System.out.println(count);
		
	}
	
	static void bfs(int sx, int sy, int height, boolean [][] visited) {
		visited[sx][sy] = true;
		Queue<int []> que = new LinkedList<>();
		que.add(new int [] {sx, sy});
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = point[0] + dx[i];
				int ty = point[1] + dy[i];
				
				if(tx >= 0 && tx < N && ty >= 0 && ty < N) {
					if(map[tx][ty] > height && !visited[tx][ty]) {
						visited[tx][ty] = true;
						que.add(new int[] {tx, ty});
					}
				}
			}
		}
		
	}

}
