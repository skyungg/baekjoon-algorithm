import java.io.*;
import java.util.*;


/*
 * 퀸은 좌,우,대각선 공격 다 가능
 * -> 한 행에는 하나의 퀸만 배치
 * */
public class Main {
	static int N;
	static int count = 0;
	static int [] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		dfs(0);
		
		// 출력
		System.out.println(count);
		
	}
	
	static void dfs(int depth) {
		// 모든 퀸 배치 
		if(depth == N) {
			count++;
			
			return;
		}
		
		// 현재 행에서 열 선택하기
		for(int i = 0; i < N; i++) {
			arr[depth] = i;		// 인덱스: 열, 값: 행
			
			//
			if(checkQuene(depth)) {	// 퀸 배치 가능 -> 다음 퀸으로
				dfs(depth+1);
			}
		}
	}
	
	static boolean checkQuene(int col) {
		for(int i = 0; i < col; i++) {
			if(arr[col] == arr[i]) return false;	// 같은 열에 이미 퀸 존재 -> 만족 X	
			else if(Math.abs(col-i) == Math.abs(arr[col] - arr[i])) return false;
		}
		
		return true;
	}
}
