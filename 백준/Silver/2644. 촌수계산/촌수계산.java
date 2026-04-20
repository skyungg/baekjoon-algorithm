import java.io.*;
import java.util.*;

/*
 * 트리?
 * */
public class Main {
	static int N;
	static List<List<Integer>> pGraph = new ArrayList<>();	// 부모 기준 그래프
	static List<List<Integer>> cGraph = new ArrayList<>();	// 자식 기준 그래프
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= N; i++) {
			pGraph.add(new ArrayList<>());
			cGraph.add(new ArrayList<>());
		}
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			pGraph.get(x).add(y);
			cGraph.get(y).add(x);
		}
		
		// 구현
		int result = bfs(a, b);
		
		// 정답 출력
		System.out.println(result);
		
	}
	
	static int bfs(int x, int y) {
		Queue<int []> que = new LinkedList<>();
		
		que.add(new int [] {x, 0});	// 현재 위치, 현재까지 촌수
		boolean [] visited = new boolean[N+1];
		visited[x] = true;
		
		int count = -1;
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			int curX = point[0];
			int cnt = point[1];
			
			if(curX == y) {
				count = cnt;
				break;
			}
			
			// 자식 방향
            for(int next : pGraph.get(curX)) {
                if(!visited[next]) {
                    visited[next] = true;
                    que.add(new int[] {next, cnt+1});
                }
            }

            // 부모 방향
            for(int next : cGraph.get(curX)) {
                if(!visited[next]) {
                    visited[next] = true;
                    que.add(new int[] {next, cnt+1});
                }
            }
		}
		
		return count;
	}
	

}
