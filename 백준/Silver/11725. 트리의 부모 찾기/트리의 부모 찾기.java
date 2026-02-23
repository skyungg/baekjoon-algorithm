import java.io.*;
import java.util.*;

public class Main {
	static int [] result;
	static List<List<Integer>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		// 그래프 입력
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());	// 부모
			int b = Integer.parseInt(st.nextToken());	// 자식
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		// 루트 1 출발
		result = new int[N+1];
		result[1] = -1;
		
		bfs(1);
		
		// 정답 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i <= N; i++) {
			sb.append(result[i]+"\n");
		}

		System.out.println(sb);
		
	}
	
	static void bfs(int curNum) {
		Queue<Integer> que = new LinkedList<>();
		que.add(curNum);

		while(!que.isEmpty()) {
			int mP = que.poll();	// may parents로 가정
			
			List<Integer> list = graph.get(mP);	// 탐색 할 list
			for(int i = 0; i < list.size(); i++) {
				int num = list.get(i);
				
				if(result[num] == 0) {	// mP가 부모임이 확실한 경우
					result[num] = mP;
					que.add(num);
				}
			}
			
			
		}
	}

}
