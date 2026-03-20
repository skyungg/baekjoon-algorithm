import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static int [][] map;
	static boolean [] visited = new boolean[26];	// 알파벳 방문 여부
	static int [][] mask;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
 	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		mask = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			String str = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c) - 'A';
			}
		}
		
		// 구현 및 정답 출력
		visited[map[0][0]] = true;	// 출발 위치 
		mask[0][0] = 1 << map[0][0];	// 현재 위치 비트마스크
		
		System.out.println(dfs(0, 0));

	}
	
	static int dfs(int x, int y) {
		int result = 0;
		
		for(int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			
			if(tx < 0 || tx >= R || ty < 0 || ty >= C) continue;
			if(visited[map[tx][ty]]) continue;	// 이미 방문
			
			int num = 1 << map[tx][ty];
			if(mask[tx][ty] == (mask[x][y] | num)) continue;
			
			mask[tx][ty] = mask[tx][ty] | num;
			
			visited[map[tx][ty]] = true;
			result = Math.max(result, dfs(tx, ty));
			visited[map[tx][ty]] = false;
		}
		
		return result + 1;
	}

}
