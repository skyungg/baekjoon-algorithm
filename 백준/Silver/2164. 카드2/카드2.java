import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> que = new LinkedList<>();
		for(int i = 1; i <= N; i++) que.add(i);
		
		while(que.size() > 1) {
			// 1. 첫번째 원소 날리기
			que.poll();
			
			// 사이즈 체크
			if(que.size() == 1) break;
			
			// 2. 꺼내서 다시 넣기
			int tmp = que.poll();
			que.add(tmp);
		}
		
		System.out.println(que.poll());

	}

}
