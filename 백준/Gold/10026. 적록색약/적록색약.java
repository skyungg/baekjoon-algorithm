import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static char [][] map;
	static boolean [][] visited;
	static boolean [][] rgVisited;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		rgVisited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 일반 구역
		int normalCount = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i, j);
					normalCount++;
				}
			}
		}
		
		// 적록색약 구역
		int rgCount = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!rgVisited[i][j]) {
					rgBfs(i, j);
					rgCount++;
				}
			}
		}
		
		
		// 구현 및 출력
		System.out.println(normalCount+" "+rgCount);
		
	}
	
	// 일반 : 현재 위치 사방탐색해서 같은 색 위치 인접영역 표시하기
	static void bfs(int x, int y) {
		Queue<int []> que = new LinkedList<>();
		que.add(new int [] {x, y});
		visited[x][y] = true;	// 방문 처리
		char targetColor = map[x][y];
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = dx[i] + point[0];
				int ty = dy[i] + point[1];
				
				if(isRange(tx, ty) && !visited[tx][ty]) {
					if(targetColor == map[tx][ty]) {
						visited[tx][ty] = true;
						que.add(new int [] {tx, ty});
					}
				}
				
			}
			
		}
		
	}
	
	
	
	// 적록색약 bfs (빨강 == 파랑)
	static void rgBfs(int x, int y) {
		Queue<int []> que = new LinkedList<>();
		que.add(new int [] {x, y});
		rgVisited[x][y] = true;	// 방문 처리
		char targetColor = map[x][y];
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = dx[i] + point[0];
				int ty = dy[i] + point[1];
				
				if(isRange(tx, ty) && !rgVisited[tx][ty]) {
					if(targetColor != 'B') {	// 베이스: R || G
						if(map[tx][ty] != 'B') { 	// 현재위치 : 적록색약 구역
							rgVisited[tx][ty] = true;
							que.add(new int [] {tx, ty});
						}
					}else {		// 베이스: B
						if(targetColor == map[tx][ty]) {
							rgVisited[tx][ty] = true;
							que.add(new int [] {tx, ty});
						}
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
