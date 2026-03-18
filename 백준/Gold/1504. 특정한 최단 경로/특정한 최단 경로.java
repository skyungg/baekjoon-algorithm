import java.io.*;
import java.util.*;

public class Main {
	static int N, E;
	static ArrayList<ArrayList<int []>> graph = new ArrayList<>();
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new int [] {b, c});
			graph.get(b).add(new int [] {a, c});
			
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int [] dist1 = dijkstra(1);		// 출발 정점이 1
		int [] distV1 = dijkstra(v1);	// 출발 정점이 v1
		int [] distV2 = dijkstra(v2);	// 출발 정점이 v2
		
		long tc1 = (long)dist1[v1] + distV1[v2] + distV2[N];	// start -> v1 -> v2 -> N
		long tc2 = (long)dist1[v2] + distV2[v1] + distV1[N];	// start -> v2 -> v1 -> N
		
		long result = Math.min(tc1, tc2);
		
		if(dist1[v1] == INF || distV1[v2] == INF || distV2[N] == INF) tc1 = INF;
        if(dist1[v2] == INF || distV2[v1] == INF || distV1[N] == INF) tc2 = INF;

        result = Math.min(tc1, tc2);

        // 구현 및 출력
        System.out.println(result >= INF ? -1 : result);
		
	}
	
	static int[] dijkstra(int start) {
		int [] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);// 가중치 작은 순서
		pq.add(new int [] {start, 0});	// 현재 정점, 가중치
		
		while(!pq.isEmpty()) {
			int [] point = pq.poll();
			
			int num = point[0];		// 현재 정점
			int cost = point[1];	// 현재 정점까지의 가중치
			
			if(cost > dist[num]) continue;
			
			for(int [] next : graph.get(num)) {
				int nextNum = next[0];
				int nextCost = cost + next[1];
				
				if(nextCost < dist[nextNum]) {
					dist[nextNum] = nextCost;
					pq.add(new int [] {nextNum, nextCost});
				}
			}
		}
		
		return dist;
		
	}

}
