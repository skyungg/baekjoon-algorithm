import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			if(Math.abs(a) == Math.abs(b)) return a - b;		// 절댓값 같은 경우 -> 원래 값 작은 순서로
			else return  Math.abs(a) - Math.abs(b);					// 기본: 절댓값 작은순서}
		});

		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(pq.isEmpty()) sb.append(0+"\n");
				else sb.append(pq.poll()+"\n");
			}else {
				pq.add(num);				
			}
		}
		
		// 정답 출력
		System.out.println(sb);		

	}

}
