import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static int [][] map;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	static boolean [] visited = new boolean[26];	// 알파벳 방문 여부
	static int result = 0;
 	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			String str = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c) - 'A';
			}
		}
		
		// 구현 및 정답 출력
		visited[map[0][0]] = true;	// 출발 위치 
		dfs(0, 0, 1);	// 자기 자신
		
		System.out.println(result);

	}
	
	static void dfs(int x, int y, int length) {
		result = Math.max(result, length);
		
		for(int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			
			if(tx < 0 || tx >= R || ty < 0 || ty >= C) continue;
			if(visited[map[tx][ty]]) continue;	// 이미 방문
			
			visited[map[tx][ty]] = true;
			dfs(tx, ty, length+1);
			visited[map[tx][ty]] = false;
		}
	}

}
