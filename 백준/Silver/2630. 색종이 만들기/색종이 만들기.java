import java.io.*;
import java.util.*;

public class Main {
	static int [][] map;
	static int wCount, bCount;	// 하얀색, 파란색 
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		wCount = 0;
		bCount = 0;
		
		dfs(0, 0, N);
		
		System.out.println(wCount+"\n"+bCount);

	}
	
	static void dfs(int x, int y, int length) {
		int standard = map[x][y];	// 기준 색
		boolean flag = true;
		
		int sx = x;
		int sy = y;
		int ex = x + length;
		int ey = y + length;
		for(int i = sx; i < ex; i++) {
			for(int j = sy; j < ey; j++) {	
				if(map[x][y] != map[i][j]) {			// 현재 구역에서 다른 색 발견
					flag = false;
					break;
				}
			}
			if(!flag) break;
		}
		
		if(flag) {		// 현재 구역이 모두 같은 색상 -> 해당 구역의 color 증가
			if(map[x][y] == 0) wCount++;		// 하얀색
			else bCount++;						// 파란색
			return;
		}else {
			int half = length/2;
			
			dfs(sx, sy, half);		// 1사분면
			dfs(sx, sy+half, half);		// 2사분면
			dfs(sx+half, sy, half);		// 3사분면
			dfs(sx+half, sy+half, half);		// 4사분면
		}
		
	}

}
