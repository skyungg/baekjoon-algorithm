import java.io.*;
import java.util.*;

public class Main{
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean [] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= N; i++) graph.add(new ArrayList<>());
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);		// 2차원 인접 리스트
			graph.get(b).add(a);
		}
		
		visited = new boolean[N+1];
		// dfs접근
		dfs(1);
		int result = 0;
		for(boolean flag : visited) {
			if(flag) result++;
		}
		System.out.println(result-1);
		
		// bfs 접근
//		System.out.println(bfs(1));
	}
	
	static void dfs(int num) {
		if(visited[num]) return;
		
		visited[num] = true;
		
		for(int i = 0; i < graph.get(num).size(); i++) {
			int target = graph.get(num).get(i);
			if(visited[target]) continue;
			dfs(target);
		}
	}
	
	static int bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		visited[start] = true;
		int count = 0;
		
		while(!que.isEmpty()) {
			int num = que.poll();
			
			for(int i = 0; i < graph.get(num).size(); i++) {
				int target = graph.get(num).get(i);
				if(visited[target]) continue;
				que.add(target);
				visited[target] = true;
				count++;
			}
		}
		
		return count;
	}

}
