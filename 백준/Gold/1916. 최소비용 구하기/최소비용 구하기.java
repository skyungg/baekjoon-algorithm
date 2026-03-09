import java.io.*;
import java.util.*;

public class Main{
	static int N, M;
	static List<List<int []>> graph = new ArrayList<>();
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(s).add(new int[] {e, cost});
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		// 구현 및 출력
		System.out.println(bfs(start, end));
		
	}
	
	static int bfs(int start, int end) {
		PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);	// 비용 기준 올림차순 정렬
		
		int [] arr = new int[N+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[start] = 0;

		pq.add(new int [] {start, 0});	// 현재 위치, 누적 비용
		int minCost = Integer.MAX_VALUE;
		
		while(!pq.isEmpty()) {
			int [] point = pq.poll();
			if(point[1] > arr[point[0]]) continue;	// 구하지 않아도 이미 비용이 기존값보다 큼
			
			if(point[0] == end) {
				minCost = point[1];
				break;
			}
			
			List<int []> list = graph.get(point[0]);
			
			for(int i = 0; i < list.size(); i++) {
				int [] curPoint = list.get(i);
				
				if(curPoint[1]+point[1] >= arr[curPoint[0]]) continue;
				
				arr[curPoint[0]] = curPoint[1]+point[1];
				pq.add(new int [] {curPoint[0], arr[curPoint[0]]});			
			}
		}
		
		return minCost;
		
	}
}
