import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [][] map;
	static boolean [][] visited;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	static Queue<int []> q;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		while(true) {
			q = new LinkedList<>();
			
			// 1. 구역 확인
			int count = 0;
			visited = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] > 0 && !visited[i][j]) {
						visited[i][j] = true;
						
						getArea(i, j);
						count++;
					}
				}
			}

			if(count == 0) {	// 다 녹음 -> 분리X
				time = 0;
				break;
			} else if(count >= 2) {
				break;
			}
			
			// 2.녹이기
			melt();
			
			time++;
		}
		
		// 정답 출력
		System.out.println(time);

	}
	
	static void getArea(int x, int y) {
		Queue<int []> que = new LinkedList<>();
		que.add(new int [] {x, y});
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			q.add(new int [] {point[0], point[1]});
			
			for(int i = 0; i < 4; i++) {
				int tx = point[0] + dx[i];
				int ty = point[1] + dy[i];
				
				if(tx >= 0 && tx < N && ty >= 0 && ty < M) {
					if(map[tx][ty] > 0 && !visited[tx][ty]) {
						visited[tx][ty] = true;
						que.add(new int[] {tx, ty});
						
					}
				}
			}
		}
	}
	
	
	static void melt() {
		
		while(!q.isEmpty()) {
			int [] point = q.poll();
			
			int cnt = 0;
			
			for(int i = 0; i < 4; i++) {
				int tx = point[0] + dx[i];
				int ty = point[1] + dy[i];
				
				if(tx >= 0 && tx < N && ty >= 0 && ty < M) {
					if(!visited[tx][ty]) cnt++;
				}
			}
			
			if(map[point[0]][point[1]] < cnt) map[point[0]][point[1]] = 0;
			else map[point[0]][point[1]] -= cnt;	
		}
	}
}
