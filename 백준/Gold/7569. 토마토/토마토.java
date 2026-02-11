import java.io.*;
import java.util.*;

public class Main {
	static int N, M, H;
	static int [][][] map;
	static Queue<int[]> que = new LinkedList<>();
	static int count = 0;
	static int [] dh = {0, 0, 0, 0, -1, 1};
	static int [] dx = {-1, 0, 1, 0, 0, 0};
	static int [] dy = {0, 1, 0, -1, 0, 0};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		for(int h = 0; h < H; h++) {
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					map[h][i][j] = Integer.parseInt(st.nextToken());
					if(map[h][i][j] == 1) que.add(new int [] {h, i, j, 0});	// 익은 토마토 위치
					if(map[h][i][j] == 0) count++;	// 익지 않은 토마토 개수 증가
				}
			}
		}
	
		// 탐색 및 출력
		System.out.println(bfs());

	}
	
	static int bfs() {
		int result = 0;
		
		while(!que.isEmpty()) {
			int [] curPoint = que.poll();

			if(count == 0) break;
			
			for(int i = 0; i < 6; i++) {
				int th = dh[i] + curPoint[0];
				int tx = dx[i] + curPoint[1];
				int ty = dy[i] + curPoint[2];
				
				if(checkRange(th, tx, ty) && map[th][tx][ty] == 0) {
					map[th][tx][ty] = 1;	// 익은 처리
					count--;	// 익었으니 개수 차감
					que.add(new int [] {th, tx, ty, curPoint[3]+1});
					result = Math.max(result, curPoint[3]+1);
				}
			}
		}
		
		if(count == 0) return result;
		else return -1;		//  익지 않은 토마토 존재
	}
	
	static boolean checkRange(int h, int x, int y) {
		return h >= 0 && h < H && x >= 0 && x < N && y >= 0 && y < 	M;
	}

}
