import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 수
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			String fc = br.readLine();	// 수행 할 함수
			int n = Integer.parseInt(br.readLine());	// 배열에 들어 있는 개수 n
			String str = br.readLine();
			
			int [] arr = new int[n];
			if(n > 0) {
				// 숫자 배열 전처리
				String [] tmp = str.substring(1, str.length()-1).split(",");
				int len = tmp.length;
				
				for(int i = 0; i < len; i++) {
					arr[i] = Integer.parseInt(tmp[i]);
				}				
			}
			
			// 구현
			sb.append(solve(fc, arr)+"\n");
			
		}
		
		// 출력
		System.out.println(sb);
	}
	
	static String solve(String op, int [] arr) {
		int start = 0;	// 정수 배열 첫 번째 위치
		int end = arr.length-1;	// 정수 배열 마지막 위치
		boolean flag = true;	// 정방향, 역방향
		
		for(int i = 0; i < op.length(); i++) {
			char ch = op.charAt(i);	// 함수
			
			if(ch == 'R') {
				flag = !flag;	// 방향 뒤집기
			}else {
				// 배열에서 첫번째 수 버리기
				if(start > end) return "error";		// 비어 있음 -> 에러
				if(flag) start++;	// 정방향 -> 맨 앞 원소 삭제
				else end--;	// 정방향 -> 맨 뒤 원소 삭제
			}
		}
		
		StringBuilder sr = new StringBuilder("[");
		if(flag) {
			// 정방향
			for(int i = start; i <= end; i++) {
				sr.append(arr[i]);
				if(i < end) sr.append(",");
			}
		}else {
			for(int i = end; i >= start; i--) {
				sr.append(arr[i]);
				if(i > start) sr.append(",");
			}
		}
		sr.append("]");
		
		return sr.toString();
	}

}
