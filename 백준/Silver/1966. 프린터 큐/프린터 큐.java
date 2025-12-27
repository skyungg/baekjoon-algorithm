import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());	// 문서의 개수
			int M = Integer.parseInt(st.nextToken());	// 궁금한 문서의 현재 순번 
			
			Queue<int []> que = new LinkedList<>();
			PriorityQueue<Integer> pQue = new PriorityQueue<>(Collections.reverseOrder());	// 주어진 문서들의 우선순위 내림차순 정렬하기

			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				que.add(new int [] {num, i});	// 우선순위, 순번
				pQue.add(num);	// 현재 들어온 값들의 우선순위
			}
			
			// 몇 개있는지 판단하기
			int count = 0;		// target 보다 큰 수
			
			while(true) {
				int [] point = que.poll();
				
				if(point[0] == pQue.peek()) {	// 현재 문서가 최대 우선순위 일 경우
					pQue.poll();
					count++;
					
					if(point[1] == M) {			// 해당 문서의 순서가 내가 찾으려는 문서일 경우
						sb.append(count+"\n");
						break;
					}
				}else {
					que.add(point);		// 최고점보다 우선순위가 낮음 -> 다시 뒤로 보내기
				}
			}
		}
		
		System.out.println(sb);
	}

}
