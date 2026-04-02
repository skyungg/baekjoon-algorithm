import java.io.*;
import java.util.*;


/*
 * 퀸은 좌,우,대각선 공격 다 가능
 * -> 한 행에는 하나의 퀸만 배치
 * */
public class Main {
	static int N;
	static int count = 0;
	static boolean [] col;	// 열 체크
	static boolean [] diag1;	// 오른쪽 아래 대각선
	static boolean [] diag2;	// 왼쪽 아래 대각선
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		col = new boolean[N];
		diag1 = new boolean[2*N];
		diag2 = new boolean[2*N];
		
		dfs(0);
		
		// 출력
		System.out.println(count);
		
	}
	
	static void dfs(int row) {
		// 모든 행에 퀸 배치 완료
		if(row == N) {
			count++;
			
			return;
		}
		
		// 현재 행에서 열 선택하기
		for(int c = 0; c < N; c++) {
			// 선택한 열이, 다른 퀸들에 의해 공격 당할 수 있는 위치
			if(col[c] || diag1[row+c] || diag2[row - c + N]) continue;
			
			// 배치
			col[c] = true;
			diag1[row+c] = true;
			diag2[row-c+N] = true;
			
			dfs(row+1);	// 다음 행으로 이동
			
			// 백트래킹
			col[c] = false;
			diag1[row+c] = false;
			diag2[row-c+N] = false;
		}
		
		
	}
}
