import java.io.*;
import java.util.*;

public class Main {
	static int E, V, K;
	static List<List<int []>> graph = new ArrayList<>();
	static int [] dist;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());	// 정점의 번호
		
		for(int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());	// 가중치
			
			graph.get(u).add(new int [] {v, w});
		}
		
		dist = new int[V+1];	// K에서 각 정점마다 최소 거리 
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		
		// 구현
		dijkstra(K);
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			sb.append(dist[i] != Integer.MAX_VALUE ? dist[i] : "INF" ).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void dijkstra(int start) {
		PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.add(new int [] {start, 0});	// 출발점
		dist[K] = 0;	// 출발점은 0
		
		while(!pq.isEmpty()) {
			int [] point = pq.poll();
			
			List<int []> tmp = graph.get(point[0]);
			for(int i = 0; i < tmp.size(); i++) {
				int [] cur = tmp.get(i);

				if(point[1] + cur[1] < dist[cur[0]]) {
					dist[cur[0]] = point[1]+cur[1];
					pq.add(new int [] {cur[0], dist[cur[0]]});
				}
			}
		}
		
	}

}
