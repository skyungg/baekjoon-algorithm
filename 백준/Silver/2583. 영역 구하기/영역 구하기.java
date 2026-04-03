import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static boolean [][] map;
	static boolean [][] visited;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());	// 행
		N = Integer.parseInt(st.nextToken());	// 열
		K = Integer.parseInt(st.nextToken());	// 개수
		
		map = new boolean[M][N];
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int i = y1; i < y2; i++) {
				for(int j = x1; j < x2; j++) {
					map[i][j] = true;
				}
			}
		}
		
		// 탐색하기
		visited = new boolean[M][N];
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(!map[i][j] && !visited[i][j]) {
					result.add(bfs(i, j));
				}
			}
		}
		Collections.sort(result);	// 정렬
		
		// 출력
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()+"\n");
		for(int area : result) sb.append(area+" ");
		System.out.println(sb);
	}
	
	static int bfs(int x, int y){
		int count = 1;	// 현재 영역 개수
		
		visited[x][y] = true;	// 현재 위치 방문
		Queue<int []> que = new LinkedList<>();
		que.add(new int [] {x, y});
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = point[0] + dx[i];
				int ty = point[1] + dy[i];
				
				if(tx >= 0 && tx < M && ty >= 0 && ty < N) {
					if(!map[tx][ty] && !visited[tx][ty]) {
						visited[tx][ty] = true;	// 방문처리
						count++;
						que.add(new int [] {tx, ty});
					}
				}
			}
		}
		
		return count;
		
		
	}

}
