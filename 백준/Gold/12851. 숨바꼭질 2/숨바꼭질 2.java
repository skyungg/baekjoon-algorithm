import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> que = new LinkedList<>();
		que.add(N);	// 현재 위치
		
		int [] dist = new int[100001];	// N에서 i까지 도착하는 데 걸린 최단 시간
		Arrays.fill(dist, -1);
		dist[N] = 0;
		
		int minTime = Integer.MAX_VALUE;	// 가장 빠른 시간
		int cnt = 0;	// 횟수
		
		while(!que.isEmpty()) {
			int point = que.poll();
			
			if(point == K) {
				minTime = dist[point];
				cnt++;
				continue;	// 다른 방법 존재하는지 넘어가기(어차피 이미 K도착했으니 현재 정점에서 더 할 일 없음)1
			}
			
			int [] next = {point-1, point+1, 2*point};
			
			for(int nx : next) {
				if(nx < 0 || nx > 100000) continue;
				
				// 아직 안 갔거나, 같은 시간으로 도착하는 경우
				if(dist[nx] == -1 || dist[nx] == dist[point]+1){
					dist[nx] = dist[point]+1;	// 1초 증가
					que.add(nx);
				}
			}
		}
		
		// 출력
		System.out.println(minTime);
		System.out.println(cnt);
	}

}
