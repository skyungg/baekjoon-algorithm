import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		List<Integer> nums = new ArrayList<>();
		List<Character> op = new ArrayList<>();
		op.add('0');
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '+' || str.charAt(i) == '-') {		// 기호는 op 에 저장
				op.add(str.charAt(i));
				
				// 숫자로 바꾸기
				nums.add(Integer.parseInt(sb.toString()));
				sb = new StringBuilder();	// sb 초기화
			}else {
				sb.append(str.charAt(i));
			}
		}
		if(sb != null) nums.add(Integer.parseInt(sb.toString()));

		
		boolean [] visited = new boolean[op.size()];	// 해당 기호 사용 여부 판단
		boolean [] nVisited = new boolean[nums.size()];
		
		// 구현
		int result = nums.get(0);	// 처음 숫자
		for(int i = 1; i < op.size(); i++) {
			if(op.get(i) == '-' && !visited[i]) {
				int idx = i+1;
				int tmp = nums.get(i);
				
				while(idx < op.size()) {							// 이 다음 -가 나올때까지 더해주기
					if(op.get(idx) == '-') break;	// - 나오면 탈출
					
					if(op.get(idx) == '+' && !visited[idx]) {
						tmp += nums.get(idx);
						visited[idx] = true;
					}
					idx++;
				}
				
				result -= tmp;
				
			}else if(op.get(i) == '+' && !visited[i]) {		// 덧셈 + 방문전 -> 그 다음 숫자 더해주기 
				result += nums.get(i);
				visited[i] = true;
			}
		}
		
		// 정답 출력
		System.out.println(result);



	}

}
