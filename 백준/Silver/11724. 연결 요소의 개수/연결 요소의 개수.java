import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean [] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
				
			graph.get(a).add(b);	// 그래프 채우기 
			graph.get(b).add(a);
		}
		
		// dfs 풀이
		int dfsCount = 0;
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
				visited[i] = true;
				dfsCount++;
			}
		}
		
		// dfs 정답 출력
		System.out.println(dfsCount);
		
		// bfs 플이
//		int bfsCount = 0;
//		for(int i = 1; i <= N; i++) {
//			if(!visited[i]) {
//				bfs(i);
//				visited[i] = true;
//				bfsCount++;
//			}
//		}
//		
//		// bfs 정답 출력
//		System.out.println(bfsCount);

	}
	static void dfs(int num) {
		List<Integer> list = graph.get(num);
		
		for(int i = 0; i < list.size(); i++) {
			int nextNum = list.get(i);
			
			if(!visited[nextNum]) {
				visited[nextNum] = true;
				dfs(nextNum);
			}
		}
	}
	
	static void bfs(int num) {
		Queue<Integer> que = new LinkedList<>();
		que.add(num);
		
		while(!que.isEmpty()) {
			int curNum = que.poll();
			
			List<Integer> list = graph.get(curNum);		// 해당 숫자의 리스트
			
			for(int i = 0; i < list.size(); i++) {
				int nextNum = list.get(i);
				if(!visited[nextNum]) {
					visited[nextNum] = true;
					que.add(nextNum);
				}
			}
		}
	}
	

}
