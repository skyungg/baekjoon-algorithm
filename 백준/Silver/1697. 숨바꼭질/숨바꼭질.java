import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<int []> que = new LinkedList<>();
		que.add(new int[] {N, 0});	// 현재 위치, 초
		
		int result = 0;
		boolean [] visited = new boolean[100001];
		visited[N] = true;
		
		while(!que.isEmpty()) {
			int [] point = que.poll();
			
			if(point[0] == K) {
				result = point[1];
				break;
			}
			
			int [] nums = {point[0] + 1, point[0] - 1, point[0]*2};
			for(int num : nums) {
				if(num >= 0 && num <= 100000) {
					if(!visited[num]) {
						visited[num] = true;
						que.add(new int[] {num, point[1]+1});
					}					
				}
			}
		}
		
		System.out.println(result);

	}

}
