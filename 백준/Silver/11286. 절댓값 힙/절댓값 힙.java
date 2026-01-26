import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int [] a, int [] b) {
				if(a[0] == b[0]) return a[1] - b[1];		// 절댓값 같은 경우 -> 원래 값 작은 순서로
				else return a[0] - b[0];					// 기본: 절댓값 작은순서
			}
		});

		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(pq.isEmpty()) sb.append(0+"\n");
				else sb.append(pq.poll()[1]+"\n");
			}else {
				pq.add(new int [] {Math.abs(num), num});				
			}
		}
		
		// 정답 출력
		System.out.println(sb);		

	}

}
