import java.io.*;
import java.util.*;

/*
 * (구) 주어진 치즈가 모두 녹아 없어지는 데 걸리는 시간
 * 
 * (포인트)
 * 1. 치즈 내부 공간 공기는 공기로 취급X
 * 2. 공간의 맨가장자리는 외부 공기로 취급 -> (0, 0)에서 시작해서 외부공기 해버리면 됨
 * */
public class Main {
	static int N, M;
	static int [][] area;
	static boolean [][] visited;
	
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		area = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 치즈가 녹을때까지 진행
		int time = 0;
		while(true) {
			// 1. 외부 공기 표시
			visited = new boolean[N][M];
			markAir();
			
			// 2. 녹일 치즈 찾기
			List<int []> list = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(area[i][j] == 1) {
						int cnt = 0;
						
						for(int idx = 0; idx < 4; idx++) {
							int tx = i + dx[idx];
							int ty = j + dy[idx];
							
							if(tx >= 0 && tx < N && ty >= 0 && ty < M) {
								if(area[tx][ty] == -1) cnt++;
							}
						}
						
						if(cnt >= 2) {
							list.add(new int[] {i, j});
						}
					}
				}
			}
			
			// 더이상 녹을 치즈 존재X -> 종료
			if(list.isEmpty()) break;
			
			// 3. 치즈 녹이기
			for(int [] ch : list) {
				area[ch[0]][ch[1]] = 0;	// 표시
			}
			
			// 4. 외부 공기 복원
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(area[i][j] == -1) area[i][j] = 0;
				}
			}
			
			time++;
		}
		
		// 정답 출력
		System.out.println(time);

	}
	
	static void markAir() {
		Queue<int []> que = new LinkedList<>();
		que.add(new int [] {0, 0});		// 외부 공기 시작점
		visited[0][0] = true;
		area[0][0] = -1;
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = point[0] + dx[i];
				int ty = point[1] + dy[i];
				
				if(tx >= 0 && tx < N && ty >= 0 && ty < M) {
					if(!visited[tx][ty] && area[tx][ty] == 0) {
						visited[tx][ty] = true;
						area[tx][ty] = -1;	// 외부 공기 표시
						que.add(new int[] {tx, ty});
					}
				}
			}
			
		}
	}

}
