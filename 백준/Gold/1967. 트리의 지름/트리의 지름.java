import java.io.*;
import java.util.*;

/*
 * 트리의 지름 : 존재하는 모든 경로들 중에서 가장 긴 것의 길이
 * */
public class Main {
	static int N;
	static List<List<int []>> tree = new ArrayList<>();
	static final int minValue = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= N; i++) {
			tree.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			tree.get(a).add(new int [] {b, c});		// 양방향
			tree.get(b).add(new int [] {a, c});
		}

		// 가장 긴 노선 찾기 및 출력
		int [] first = bfs(1);	// 1울 시작으로 가장 먼 노드 찾기
		int [] result = bfs(first[0]);

		// 정답
		System.out.println(result[1]);
		
	}
	
	static int [] bfs(int start) {	
		Queue<int []> que = new LinkedList<>();	
		que.add(new int [] {start, 0});
		
		boolean [] visited = new boolean[N+1];
		visited[start] = true;
		
		int maxNode = start;
		int maxDist = 0;		// 가장 먼 길이
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			int node = point[0];	// 현재 노드
			int dist = point[1];	// 거리
			
			// 가장 먼 노드 갱신
			if(dist > maxDist) {
				maxDist = dist;
				maxNode = node;
			}
			
			for(int [] next : tree.get(node)) {
				int nextNode = next[0];
				int nextCost = next[1];

				if(!visited[nextNode]) {
					visited[nextNode] = true;
					que.add(new int [] {nextNode, dist + nextCost});
				}
			}
		}
		
		return new int [] {maxNode, maxDist};
	}

}
