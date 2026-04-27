import java.io.*;
import java.util.*;

/*
 * 최소비용, 가중치 다름 -> PriorityQueue
 * 
 * 1. 출발지점에서 모든 점으로 가는 최단거리 저장하기
 * 2. 기존처럼 구하는 과정에서 최단거리를 만들어주는 이전 노드값 저장하기
 * */

public class Main {
	static class Point implements Comparable<Point>{
		int dest;
		int cost;
		
		public Point(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Point p) {	
			return this.cost - p.cost;		// 비용 오름차순
		}
	}
	
	static int N;
	static List<List<Point>> graph = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= N; i++) graph.add(new ArrayList<>());
		
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());	
			int c = Integer.parseInt(st.nextToken());	
			
			graph.get(s).add(new Point(d, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());		// 출발지
		int end = Integer.parseInt(st.nextToken());		// 도착지
		
		// 구현
		dijkstra(start, end);
		
		// 출력
		System.out.println(sb);
		
	}
	
	static void dijkstra(int start, int end) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(start, 0));
		
		int [] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		int [] preNum = new int[N+1];
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();

			
			if(dist[p.dest] < p.cost) continue;	// 이미 저장된 경로보다 지금 경로값이 더 큼 -> 해당 정점으로 탐색 더이상X
			
			List<Point> list = graph.get(p.dest);
			for(int i = 0; i < list.size(); i++) {
				int nextNum = list.get(i).dest;
				int nextCost = list.get(i).cost + p.cost;
				
				if(nextCost < dist[nextNum]) {
					dist[nextNum] = nextCost;
					preNum[nextNum] = p.dest;
					pq.add(new Point(nextNum, nextCost));
				}
			}
		}
		
		// 1. 출발 -> 도착 최소 비용
		sb.append(dist[end]+"\n");
		
		
		Stack<Integer> stack = new Stack<>();
		int pre = end;
		while(pre != 0) {
			stack.push(pre);
			pre = preNum[pre];
		}
		// 2. 최소 비용 가는 경로에 포함되어 있는 도시의 개수 출력하기
		sb.append(stack.size()+"\n");
		
		// 3. 최소 비용을 갖는 경로를 방문하는 도시 순서대로 출력하기
		while(!stack.isEmpty()) {
			sb.append(stack.pop()+" ");
		}
		
	}

}
