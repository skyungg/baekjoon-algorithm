import java.io.*;
import java.util.*;

public class Main {
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean [] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= N; i++) graph.add(new ArrayList<>());
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		// 오름차순 정렬
		for(int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i));
		}
		visited = new boolean[N+1];
		// dfs 방문하기
		dfs(V);
		sb.append("\n");
		
		// bfs 방문하기
		bfs(V);

		System.out.println(sb);
	}
	
	static void dfs(int start) {
		visited[start] = true;
		sb.append(start+" ");
		
		for(int i = 0; i < graph.get(start).size(); i++) {
			int num = graph.get(start).get(i);
			
			if(!visited[num]) {
				dfs(num);
			}
		}
		
		return;
	}
	
	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		Arrays.fill(visited, false);	// 방문배열 false 로 초기화
		visited[start] = true;
		
		while(!que.isEmpty()) {
			int num = que.poll();
			sb.append(num+" ");
			for(int i = 0; i < graph.get(num).size(); i++) {
				int next = graph.get(num).get(i);
				
				if(!visited[next]) {
					visited[next] = true;
					que.add(next);
				}
			}
		}
	}
}
