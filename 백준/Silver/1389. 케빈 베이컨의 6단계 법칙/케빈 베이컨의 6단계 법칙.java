import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][] count = new int[N+1][N+1];
		for(int i = 0 ; i <= N; i++) {
			Arrays.fill(count[i], Integer.MAX_VALUE);
			count[i][i] = 0;
		}
		
		List<List<Integer>> list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
//			count[a][b] = 1;
//			count[b][a] = 1;
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		// 구현
		int result = Integer.MAX_VALUE;
		int index = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++) {
			int tmpSum = 0;
			for(int j = 1; j <= N; j++) {
				if(i == j) continue;
				if(count[i][j] == Integer.MAX_VALUE) {
					// 찾기
					Queue<int []> que = new LinkedList<>();
					que.add(new int[] {i, 0});	// i와 연결된 값들
					
					while(!que.isEmpty()) {
						int [] point = que.poll();
						
						List<Integer> tmpList = list.get(point[0]);
						for(int k = 0; k  < tmpList.size(); k++) {
							int num = tmpList.get(k);
							
							if(count[i][num] == Integer.MAX_VALUE) {
								count[i][num] = point[1] + 1;
								que.add(new int[] {num, count[i][num]});
							}
						}
					}
					
				}
				
				tmpSum += count[i][j];
			}
			
			if(tmpSum < result) {
				result = tmpSum;
				index = i;
			}else if(tmpSum == result) {
				if(i < index) index = i;
			}
		}

		
		// 출력
		System.out.println(index);

	}

}
