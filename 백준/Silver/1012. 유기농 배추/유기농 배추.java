import java.io.*;
import java.util.*;

/*
 * (구) 배추들이 몇 군데 존재하는지
 * 처음 접근: 조합으로 지렁이 위치 구하기 + 완탐으로 1부터 지렁이 개수 설정해서 -> 문제 다시 읽어보니 아님
 * -> 완탐해서 배추들 영역 구하기 -> 0행 0열부터 쭉 돌기
 * bfs or dfs -> bfs -> 인접 영역으로 한 번에 구하면 될듯해서
 * */
public class Main {
	static int N, M;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	static boolean [][] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			// 입력 받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());	// 열
			N = Integer.parseInt(st.nextToken());	// 행
			int K = Integer.parseInt(st.nextToken());
			
			// 배추 위치
			int [][] map = new int[N][M];
			visited = new boolean[N][M];
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				map[x][y] = 1;		// 배추 존재
			}
			
			// 구하기
			int count = 0 ;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						bfs(map, i, j);
						count++;
					}
				}
			}
			sb.append(count+"\n");
		}
		
		// 결과 출력
		System.out.println(sb);
	}
	
	static void bfs(int [][] map, int x, int y) {
		Queue<int []> que = new LinkedList<>();
		que.add(new int [] {x, y});
		visited[x][y] = true;	// 시작 위치 방문처리
		
		while(!que.isEmpty()) {
			int [] curPoint = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = curPoint[0] + dx[i];
				int ty = curPoint[1] + dy[i];
				
				if(!checkRange(tx, ty)) continue;	// 범위 밖
				if(map[tx][ty] == 1 && !visited[tx][ty]) {
					que.add(new int[] {tx, ty});
					visited[tx][ty] = true;
				}
				
			}
		}
	}
	
	static boolean checkRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
