import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char [][] map;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		int sx = 0;	// 도연 초기위치
		int sy = 0;
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'I') {
					sx = i;			// 도연 초기 위치
					sy = j;
				}
			}
		}
		
		// bfs 탐색 돌리기
		if(bfs(sx, sy) == 0) {
			System.out.println("TT");
		}else {
			System.out.println(bfs(sx, sy));			
		}

	}
	
	static int bfs(int x, int y) {
		Queue<int []> que = new LinkedList<>();
		boolean [][] visited = new boolean[N][M];	// 방문 확인 배열
		int count = 0;	// 만난 사람 수
		
		que.add(new int [] {x, y});
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			int [] curPoint = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = dx[i] + curPoint[0];		// 현재 위치로 사방탐색 
				int ty = dy[i] + curPoint[1];
			
				// 범위 탐색
				if(isRange(tx, ty) && !visited[tx][ty]) {
					if(map[tx][ty] != 'X') {
						if(map[tx][ty] == 'P') count++;
						
						// 방문처리 및 확장
						visited[tx][ty] = true;
						que.add(new int[] {tx, ty});
					}
				}
			}
			
		}
		
		return count;
	}
	
	static boolean isRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
