import java.io.*;
import java.util.*;

/*
 * 트리? -> 양방향 그래프에서 최단 거리 구하기
 * 촌수 = 간선개수 ->  bfs 최단거리 문제
 * */

public class Main {
	static int N;
	static List<List<Integer>> graph = new ArrayList<>();	// 부모 기준 그래프
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		// 구현
		int result = bfs(a, b);
		
		// 정답 출력
		System.out.println(result);
		
	}
	
	static int bfs(int start, int target) {
		Queue<int []> que = new LinkedList<>();
		que.add(new int [] {start, 0});	// 현재 위치, 현재까지 촌수
		
		boolean [] visited = new boolean[N+1];
		visited[start] = true;
		
		int count = -1;
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			if(point[0] == target) {
				count = point[1];
				break;
			}
			
			for(int next : graph.get(point[0])) {
				if(!visited[next]) {
					visited[next] = true;
					que.add(new int [] {next, point[1] + 1});
				}
			}
		}
		
		return count;
	}
	

}
