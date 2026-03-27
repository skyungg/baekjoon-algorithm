import java.io.*;
import java.util.*;

/*
 * 1. 현재 칸 청소
 * 2. 현재 칸 주변 4칸에 청소해야하는 칸 존재X
 * -> (1) 현재 방향 유지한채로 한칸 후진 가능 -> 한칸 후진 + 1번
 *    (2) 바라보는 방향 뒤쪽 칸이 벽이라 후진 불가능 -> 작동 멈춤
 *  3. 현재 4칸 중 청소되지 않은 빈 칸 존재. 
 *    (1) 반시계 방향 90도 회전
 *    (2) 바라보는 방향 기준 앞쪽 칸이 청소되지 않은 빈칸 인 경우 한 칸 전지
 *    (3) 1번으로 돌아가기
 * */
public class Main {
	static int N, M;
	static int [][] map;
	static boolean [][] visited;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	static int count = 0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		int sx = 0;
		int sy = 0;
		int sd = 0;
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		sd = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(sx, sy, sd);
		
		// 정답 출력
		System.out.println(count);
		
	}
	
	static void dfs(int x, int y, int dir) {
		// 1. 현재 칸 청소
		if(map[x][y] == 0) {	// 아직 청소 전
			map[x][y] = 2;	// 청소 완료
			count++;
		}
		
		// 2. 주변 4칸 확인
		for(int i = 0; i < 4; i++) {
			dir = (dir+3) % 4;
//			int newDir = (4-(dir-1))%4;
			
			int tx = x + dx[dir];
			int ty = y + dy[dir];
			
			if(checkRange(tx, ty)) {
				if(map[tx][ty] == 0) {
					dfs(tx, ty, dir);	// 방향전환 가능한 칸 발견
					return;
				}
			}
		}
		
		// 3. 주변 4칸 중 청소되지 않은 빈칸 존재X
		int bx = x;
		int by = y;
		
		if(dir == 0) bx++;
		else if(dir == 1) by--;
		else if(dir == 2) bx--;
		else by++;
		
		if(!checkRange(bx, by)) return;	// 후진 불가
		if(map[bx][by] == 1) return;
		
		dfs(bx, by, dir);
	}
	
	static boolean checkRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
