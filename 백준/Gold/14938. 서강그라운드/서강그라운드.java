import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [] item;
	static List<List<int []>> graph = new ArrayList<>();
	static boolean [] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 지역 수
		M = Integer.parseInt(st.nextToken());	// 수색범위
		int R = Integer.parseInt(st.nextToken());	// 길의 개수
		
		item = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			item[i] = Integer.parseInt(st.nextToken());	// 각 구역별 아이템 수
		}
		
		for(int i = 0; i <= N; i++) graph.add(new ArrayList<>());
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());	// 지역 번호 a
			int b = Integer.parseInt(st.nextToken());	// 지역 번호 b
			int c = Integer.parseInt(st.nextToken());	// 길이의 길이
			
			graph.get(a).add(new int [] {b, c});
			graph.get(b).add(new int [] {a, c});
		}
		
		// 구현
		int result = 0;
		for(int i = 1; i <= N; i++) {
			result = Math.max(result, bfs(i));	// 낙하 지점
		}
		
		// 정답
		System.out.println(result);

	}
	
	static int bfs(int start) {
		visited = new boolean[N+1];
		visited[start] = true;	// 출발지점 방문
		
		Queue<int []> que = new LinkedList<>();
		que.add(new int[] {start, 0});	// 정점, 도달 거리값
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			if(point[1] >= M) continue;	// 이미 수색범위 넘어감.
			
			for(int i = 0; i < graph.get(point[0]).size(); i++) {
				int [] arr = graph.get(point[0]).get(i);	// 정점 거리
				
				if(point[1] + arr[1] > M) continue;	// 넘어감
				
				visited[arr[0]] = true;
				que.add(new int [] {arr[0], point[1] + arr[1]});
				
			}
		}
		
		int count = 0;
		for(int i = 1; i <= N; i++) {
			if(visited[i]) count += item[i];
		}
		
		return count;
		
	}

}
