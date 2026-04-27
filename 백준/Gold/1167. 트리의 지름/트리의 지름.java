import java.io.*;
import java.util.*;

/*
 *  트리의 지름 : 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것
 *  -> 임의의 번호 하나 정해서 bfs 두 번 돌리기
 * */

public class Main {
	static int V;
	static List<List<int []>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int v = 0; v < V; v++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			
			while(true) {
				int next = Integer.parseInt(st.nextToken());
				if(next == -1) break;
				
				int cost = Integer.parseInt(st.nextToken());
				graph.get(start).add(new int[] {next, cost});
			}
		}
		
		// 1. 아무 노드에서 가장 먼 노드 찾기 (노드)
		int [] dist1 = bfs(1);
		int farNum = getMaxIdx(dist1);
		
		// 2. 1에서 나온 가장 먼 노드 기준 가장 먼 거리 찾기 (거리)
		int [] dist2 = bfs(farNum);
		int result = getMaxValue(dist2);
		
		// 출력
		System.out.println(result);
		
	}
	
	static int [] bfs(int start) {
		int [] dist = new int[V+1];
		Arrays.fill(dist, -1);
		
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		dist[start] = 0;	// 출발지점 -> 자기자신은 0
		
		while(!que.isEmpty()) {
			int point = que.poll();
			
			for(int [] next : graph.get(point)) {
				int nextNode = next[0];
				int nextCost = next[1];
				
				if(dist[nextNode] == -1) {
					dist[nextNode] = dist[point] + nextCost;
					que.add(nextNode);
				}
			}
		}
		
		return dist;
		
	}
	
	static int getMaxIdx(int [] dist) {
		int max = 0;
		int idx = 0;
		
		for(int i = 1; i <= V; i++) {
			if(dist[i] > max) {
				max = dist[i];
				idx = i;
			}
		}
		
		return idx;
	}
	
	static int getMaxValue(int [] dist) {
		int max = 0;
		
		for(int i = 1; i <= V; i++) {
			if(dist[i] > max) {
				max = dist[i];
			}
		}
		
		return max;
	}

}
