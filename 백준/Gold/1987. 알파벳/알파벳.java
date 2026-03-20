import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static char [][] map;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	static int result = 0;
 	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int r = 0; r < R; r++) {
			String str = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		// 구현 및 정답 출력
		dfs(0, 0, 1 << (map[0][0] - 'A'), 1);
		
		System.out.println(result);

	}
	
	static void dfs(int x, int y, int mask, int depth) {
		result = Math.max(result, depth);
		
		for(int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			
			if(tx < 0 || tx >= R || ty < 0 || ty >= C) continue;
			
			int next = map[tx][ty] - 'A';
			
			if((mask & (1 << next)) != 0) continue;
			
			dfs(tx, ty, mask | (1 << next), depth + 1);
		}
	}

}
