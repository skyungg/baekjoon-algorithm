import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 현재 위치
		int K = Integer.parseInt(st.nextToken());	// 동생
		
		// 구현 및 정답
		System.out.println(dijkstra(N, K));

	}
	
	static int dijkstra(int start, int target) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(start);

		int [] minTime = new int[100001];	// 해당 위치 방문 시, 최솟값 비교
		Arrays.fill(minTime, Integer.MAX_VALUE);
		minTime[start] = 0;	// 출발 위치는 0
		
		int result = 0;
		
		while(!dq.isEmpty()) {
			int curPoint = dq.poll();
			int curTime = minTime[curPoint];
			
			if(curPoint == target) {
				result = curTime;
				break;
			}
			
			int nextPoint = curPoint-1;
			if(checkRange(nextPoint) && (curTime+1 < minTime[nextPoint])) {
				minTime[nextPoint] = curTime+1;
				dq.addLast(nextPoint);
			}
			
			nextPoint = curPoint+1;
			if(checkRange(nextPoint) && (curTime+1 < minTime[nextPoint])) {
				minTime[nextPoint] = curTime+1;
				dq.addLast(nextPoint);
			}
			
			nextPoint = curPoint*2;
			if(checkRange(nextPoint) && (curTime < minTime[nextPoint])) {
				minTime[nextPoint] = curTime;
				dq.addFirst(nextPoint);
			}
		}
		
		return result;
	}
	
	static boolean checkRange(int n) {
		return n >= 0 && n <=100000;
	}

}
