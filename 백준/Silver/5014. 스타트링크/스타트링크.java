import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int F = Integer.parseInt(st.nextToken());	// 총 높이
		int S = Integer.parseInt(st.nextToken());	// 강호
		int G = Integer.parseInt(st.nextToken());	// 스타트링크
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		boolean [] visited = new boolean[F+1];
		
		Queue<int []> que = new LinkedList<>();
		que.add(new int[] {S, 0});	// 현재 위치, 횟수
		visited[S] = true;
		
		int count = -1;
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			if(point[0] == G) {
				count = point[1];
				break;
			}
			
			int [] floor = {point[0]+U, point[0]-D};
			
			for(int i = 0; i < 2; i++) {
				int tf = floor[i];
				
				if(tf < 1 || tf > F) continue;	// 범위 밖
				
				if(!visited[tf]) {
					visited[tf] = true;
					que.add(new int [] {tf, point[1] + 1});
				}
			}
		}
		
		if(count == -1) {
			System.out.println("use the stairs");
		}
		else System.out.println(count);
		

	}

}
