import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder("<");
		Queue<Integer> que = new LinkedList<>();
		for(int i = 1; i <= N; i++) que.offer(i);	// 초기 셋팅
		
		while(!que.isEmpty()) {
			 // 1. k-1번째까지 뒤로 보내기
			for(int i = 0; i < K-1; i++) que.offer(que.poll());
			
			// 2. k번째 꺼내기
			int num = que.poll();
			sb.append(num);
			if(!que.isEmpty()) sb.append(", ");		// 다음 숫자가 있는 경우에만 해당
		}
		
		sb.append(">");
		System.out.println(sb);

	}

}
