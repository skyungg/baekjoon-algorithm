import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char [][] map;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
    static int count = 0;
    static boolean [][] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
        visited = new boolean[N][M];	// 방문 확인 배열
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
        dfs(sx, sy);
		if(count == 0) {
			System.out.println("TT");
		}else {
			System.out.println(count);			
		}

	}
	
	static void dfs(int x, int y) {
        visited[x][y] = true;
        if(map[x][y] == 'P') count++;

		for(int i = 0; i < 4; i++) {
			int tx = dx[i] + x;		// 현재 위치로 사방탐색 
			int ty = dy[i] + y;
			
			// 범위 탐색
			if(isRange(tx, ty) && !visited[tx][ty]) {
				if(map[tx][ty] != 'X'){
                    dfs(tx, ty);
                } 
			}
		}
	}
	
	static boolean isRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
