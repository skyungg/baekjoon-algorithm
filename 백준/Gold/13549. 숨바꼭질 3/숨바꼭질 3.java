import java.io.*;
import java.util.*;

public class Main {
	static class Point implements Comparable<Point>{
		int num;
		int time;
		
		public Point(int num, int time) {
			this.num = num;
			this.time = time;
		}
		
		@Override
		public int compareTo(Point p) {
			return this.time - p.time;		// time 작은순으로 정렬
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 현재 위치
		int K = Integer.parseInt(st.nextToken());	// 동생
		
		// 구현 및 정답
		System.out.println(bfs(N, K));

	}
	
	static int bfs(int start, int target) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		pq.add(new Point(start, 0));
		int result = 0;
		
		int [] minTime = new int[100001];	// 해당 위치 방문 시, 최솟값 비교
		Arrays.fill(minTime, Integer.MAX_VALUE);
		minTime[start] = 0;	// 출발 위치는 0
		
		while(!pq.isEmpty()) {
			Point point = pq.poll();
			
			if(point.num == target) {
				result = point.time;
				break;
			}
			
			int [] tmp = {point.num-1, point.num+1, point.num*2};
			
			for(int i = 0 ; i < 3; i++) {
				if(!checkRange(tmp[i])) continue;	// 범위 벗어남
				int curTime = point.time;
				if(i != 2) curTime++;
				
				if(curTime < minTime[tmp[i]]) {
					minTime[tmp[i]] = curTime;
					pq.add(new Point(tmp[i], curTime));
				}
			}
		}
		
		return result;
	}
	
	static boolean checkRange(int n) {
		return n >= 0 && n <=100000;
	}

}
