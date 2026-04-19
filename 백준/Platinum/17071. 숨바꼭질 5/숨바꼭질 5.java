import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 500000;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> que = new LinkedList<>();
		boolean [][] visited = new boolean[2][MAX+1];	// 짝수, 홀수 시간 방문 여부
		
		visited[0][N] = true;
		que.add(N);	// 수빈 위치, 시간
		
		int time = 0;
		int result = Integer.MAX_VALUE;
		while(!que.isEmpty()) {
			if(N == K) {
				result = 0;
				break;
			}
			
			time++;
			
			int sis = K + time * (time+1)/2;
			
			if(sis > MAX) {
				time = -1;
				break;
			}
			
			int size = que.size();
			for(int i = 0; i < size; i++) {
				int point = que.poll();	// 현재 수빈 위칙
				
				int [] next = {point-1, point+1, point*2};
				
				for(int nx : next) {
					if((nx >= 0 && nx <= MAX) && !visited[time%2][nx]) {
						visited[time%2][nx] = true;
						que.add(nx);	// 다음 위치 삽입
					}
				}
			}
			
			if(visited[time%2][sis]) {
				result = time;
				break;
			}	
		}
		
		// 정답 출력
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(time);

	}

}
