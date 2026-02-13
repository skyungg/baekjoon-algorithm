import java.io.*;
import java.util.*;

public class Main {
	static class Point{
		int point;
		int cost;
		
		public Point(int point, int cost) {
			this.point = point;
			this.cost = cost;
		}
	}
	
	static HashMap<Integer, Integer> ladder = new HashMap<>();
	static HashMap<Integer, Integer> snake = new HashMap<>();
	static int [] dice = {1, 2, 3, 4, 5, 6};
	static int [] nums;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		nums = new int[101];
		
		// 사다리 위치
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			nums[start] = 1;	// 사다리
			ladder.put(start, end);
		}
		
		// 뱀 위치
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			nums[start] = 2;	// 뱀
			snake.put(start, end);
		}
		
		// 구현 및 출력
		System.out.println(bfs());
		
	}
	
	static int bfs() {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(1, 0));	// 초기 위치
		boolean [] visited = new boolean[101];
		int result = Integer.MAX_VALUE;
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			if(p.point == 100) {		// 탈출구 도착
				result = p.cost;
//				result = Math.min(result, p.cost);
				break;
			}
			
			for(int i = 0; i < 6; i++) {
				int tx = p.point + dice[i];	// 주사위 이동
				
				if((tx >= 0 && tx <= 100) && !visited[tx]) {	// 범위 내 + 아직 방문 전
					if(nums[tx] == 1) {		// 사다리인 경우
						que.add(new Point(ladder.get(tx), p.cost + 1));
					}else if(nums[tx] == 2) {	// 뱀인 경우
						que.add(new Point(snake.get(tx), p.cost + 1));
					}else {
						que.add(new Point(tx, p.cost+1));	// 아무것도 없는 경우 - > 그냥 이동
					}
					visited[tx] = true;
				}
			}
		}
		
		return result;
	}

}
