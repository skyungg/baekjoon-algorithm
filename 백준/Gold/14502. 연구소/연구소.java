import java.io.*;
import java.util.*;

/*
 * 1. 3개의 벽 조합으로 구하기
 * 2. 1의 결과로 바이러스 확산
 * 3. 이 후 안전영역 갱신
 * */
public class Main {
	static int N, M;
	static int [][] map;
	static boolean [][] visited;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	static List<int []> virous = new ArrayList<>();
	static int maxArea = 0;
	static int count = 0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
				
		List<int []> empty = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) empty.add(new int[] {i, j});	// 빈 칸
				if(map[i][j] == 2) virous.add(new int[] {i, j});	// 바이러스
			}
		}
		
		// 3개 조합 구하기
		count = empty.size();
		recursion(empty, new int [3][2], 0, 0);
		
		
		// 정답 출력
		System.out.println(maxArea);

	}
	
	static void recursion(List<int []> list, int [][] arr, int depth, int idx) {
		if(depth == 3) {
			for(int [] ar : arr) {
				map[ar[0]][ar[1]] = 1;	// 벽 설치
			}
			
			bfs();
			
			// 벽 설치 취소
			for(int [] ar : arr) {
				map[ar[0]][ar[1]] = 0;	// 원래 값으로 복구
			}
			
			return;
		}
		
		for(int i = idx; i < list.size(); i++) {
			arr[depth][0] = list.get(i)[0];
			arr[depth][1] = list.get(i)[1];
			
			recursion(list, arr, depth+1, idx+1);
		}
	}
	
	static void bfs() {
		Queue<int []> que = new LinkedList<>(virous);
		
		for(int [] arr : virous) {
			visited[arr[0]][arr[1]] = true;
		}
		
		int cnt = count-3;		// 빈자리에 3개의 벽 설치했으니까
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			if(cnt <= maxArea) break;
			
			for(int i = 0; i < 4; i++) {
				int tx = point[0] + dx[i];
				int ty = point[1] + dy[i];
				
				if(!checkRange(tx, ty)) continue;	// 범위 밖
				if(visited[tx][ty] || map[tx][ty] != 0) continue;	// 이미 방문 or 빈 칸 아닌 경우
				
				visited[tx][ty] = true;
				que.add(new int [] {tx, ty});
				cnt--;
			}
		}
		
		// visited 초기화
		for(boolean [] v : visited) {
			Arrays.fill(v, false);
		}
		
		// 최댓값 갱신
		maxArea = Math.max(maxArea, cnt);
	}
	
	static boolean checkRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
