import java.io.*;
import java.util.*;

public class Main {
	static int N, M, X;
	static List<List<int []>> graph = new ArrayList<>();
	static List<List<int []>> reverseGraph = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
			reverseGraph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new int [] {b, c});
			reverseGraph.get(b).add(new int [] {a, c});
		}
		
		int [] dist1 = dijkstra(graph);		// X -> i
		int [] dist2 = dijkstra(reverseGraph);		// i -> X
		
		int result = 0;
		for(int i = 1; i <= N; i++) {
			result = Math.max(result, dist1[i]+dist2[i]);
		}
		
		// 출력
		System.out.println(result);
		
	}
	
	static int [] dijkstra(List<List<int []>> gp) {
		int [] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);	// 시간이 작은 순으로 정렬
		
		dist[X] = 0;
		pq.add(new int [] {X, 0});
		
		while(!pq.isEmpty()) {
			int [] arr = pq.poll();
			int now = arr[0];
			int cost = arr[1];
			
			if(dist[now] < cost) continue;		// 이미 now까지 최단거리가 존재
			
			for(int i = 0; i < gp.get(now).size(); i++) {
				int next = gp.get(now).get(i)[0];
				int nextCost = gp.get(now).get(i)[1] + cost;
				
				if(dist[next] > nextCost) {
					dist[next] = nextCost;
					pq.add(new int [] {next, nextCost});
				}
				
			}
		}
		
		return dist;
	}
}
