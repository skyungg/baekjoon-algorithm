import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean [][] visited;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char [][] map = new char[N][N];
		char [][] rMap = new char[N][N];	// 적록색약 전용
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				rMap[i][j] = map[i][j];
				if(map[i][j] == 'G') rMap[i][j] = 'R';	// G -> R 변환
			}
		}
		
		// 일반 구역
		int normalCount = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i, j, map);
					normalCount++;
				}
			}
		}
		
		// 적록색약 구역
		visited = new boolean[N][N];
		int rCount = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i, j, rMap);
					rCount++;
				}
			}
		}
			
		// 구현 및 출력
		System.out.println(normalCount+" "+rCount);
		
	}
	
	// 일반 : 현재 위치 사방탐색해서 같은 색 위치 인접영역 표시하기
	static void bfs(int x, int y, char [][] curMap) {
		Queue<int []> que = new LinkedList<>();
		que.add(new int [] {x, y});
		visited[x][y] = true;	// 방문 처리
		char targetColor = curMap[x][y];
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = dx[i] + point[0];
				int ty = dy[i] + point[1];
				
				if(isRange(tx, ty) && !visited[tx][ty]) {
					if(targetColor == curMap[tx][ty]) {
						visited[tx][ty] = true;
						que.add(new int [] {tx, ty});
					}
				}
			}
		}
	}
	
	// 범위조건
	static boolean isRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
