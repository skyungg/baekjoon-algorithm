import java.io.*;
import java.util.*;

/*
 * 특이하게도 도착을 하게 되면 시작을 하였을 때보다 시간이 뒤로 가게 된다 -> 음수 사이클
 * -> 일반 다익스트라X, 벨만포드
 * 
 * 도로: 양방향, +시간
 * 웜홀 : 단방향, -시간
 * */
public class Main {
	static class Point{
		int from;
		int to;
		int cost;
		
		public Point(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());	// 지점 수
			int M = Integer.parseInt(st.nextToken());	// 도로의 개수
			int W = Integer.parseInt(st.nextToken());	// 웜홀 개수
			
			List<Point> graph = new ArrayList<>();
			
			// 도로 (양방향)
			for(int i = 0; i < M; i++ ) {
				st = new StringTokenizer(br.readLine());
				
				int s = Integer.parseInt(st.nextToken());	// 지점 번호
				int e = Integer.parseInt(st.nextToken());	// 지점 번호
				int t = Integer.parseInt(st.nextToken());	// 이동 시간
				
				graph.add(new Point(s, e, t));
				graph.add(new Point(e, s, t));
			}
			
			// 웜홀 정보 (단방향, 음수)
			for(int i = 0; i < W; i++ ) {
				st = new StringTokenizer(br.readLine());
				
				int s = Integer.parseInt(st.nextToken());	// 지점 번호
				int e = Integer.parseInt(st.nextToken());	// 지점 번호
				int t = Integer.parseInt(st.nextToken());	// 이동 시간
				
				graph.add(new Point(s, e, -t));
			}
			
			int [] dist = new int[N+1];
			Arrays.fill(dist, 0);
			
			boolean flag = false;
			
			// 벨만 포드만
			for(int i = 1; i <= N; i++) {
				for(Point p :graph) {
					if(dist[p.to] > dist[p.from] + p.cost) {	// 더 짧은 경로 발견r
						dist[p.to] = dist[p.from] + p.cost;
						
						if(i == N) flag = true;
					}
				}
			}
			
			if(flag)sb.append("YES\n");
			else sb.append("NO\n");	
		}
		
		// 정답 출력
		System.out.println(sb);

	}

}
