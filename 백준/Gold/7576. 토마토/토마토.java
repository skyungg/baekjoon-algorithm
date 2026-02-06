import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [][] map;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	static Queue<int[]> que = new LinkedList<>();
//	static boolean [][] visited;
	static int count = 0;	// 익지 않은 토마토 개수
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());	// 열
		N = Integer.parseInt(st.nextToken());	// 행
		
		map = new int[N][M];
//		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					que.add(new int [] {i, j, 0});	// 토마토인 경우
//					visited[i][j] = true;
				}
				if(map[i][j] == 0)count++;	// 익지 않은 토마토
			}
		}
		
		// 출력
		System.out.println(bfs());
		
	}
	
	static int bfs() {
		int result = 0 ;	// 최소 일수
		
		// bfs 탐색
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			if(count == 0) break;
			
			for(int i = 0; i < 4; i++) {
				int tx = point[0] + dx[i];
				int ty = point[1] + dy[i];
				
				if(checkRange(tx, ty)) {			// 범위 확인
					if(map[tx][ty] == 0) {		// 익지 않은 토마토 + 아직 방문전
						map[tx][ty] = 1;
						que.add(new int [] {tx, ty, point[2]+1});
						result = Math.max(result, point[2]+1);
						count--;
						}
					}
				}
			}
		// 개수 비교
		if(count == 0) {	
			// 다 익음
			return result;
		}else {
			// 토마토가 모두 익지 못 함
			return -1;
		}
	}
	
	static boolean checkRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}
