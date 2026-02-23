import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		
		Deque<long[]> dq = new ArrayDeque<>();
		int limit = (int)Math.pow(10, 9);
		
		boolean [] visited = new boolean[limit+1];
		
		long result = Long.MAX_VALUE;
		dq.add(new long[] {A, 0});

		while(!dq.isEmpty()) {
			long [] point = dq.poll();
			
			if(point[0] == B) {
				result = point[1];
				break;
			}
			
			long n1 = point[0] * 2;
			long n2 = point[0]*10+1;
			
			long [] arr = {n1, n2};
			
			for(int i = 0; i < 2; i++) {
				long num = arr[i];
				if(num > limit) continue;	// 범위 체크
				if(visited[(int) num]) continue;	// 이미 방문
				
				visited[(int) num] = true;
				dq.add(new long[] {num, point[1]+1});
			}
					
		}
		
		if(result == Long.MAX_VALUE) System.out.println(-1);
		else System.out.println(result+1);

	}

}
