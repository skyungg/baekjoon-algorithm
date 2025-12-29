import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());	// 행
		int N = Integer.parseInt(st.nextToken());	// 열
		
		String [] board = new String[M];
		
		for(int i = 0; i < M; i++) {
			board[i] = br.readLine();
		}
		
		int minCount = Integer.MAX_VALUE;
		for(int i = 0; i <= M-8; i++) {
			for(int j = 0; j <= N-8; j++) {
				int count = getCount(i, j, board);
				
				if(minCount > count) minCount = count;	// 갱신하기
			}
		}
		
		// 정답 출력
		System.out.println(minCount);
	}
	
	static int getCount(int x, int y, String [] board) {
		String [] tmp = {"WBWBWBWB", "BWBWBWBW"};
		
		int wCount = 0;	// 첫행, 첫열이 화이트
		
		for(int i = 0; i < 8; i++) {
			int row = x + i;
			for(int j = 0; j < 8; j++) {
				int col = y + j;
				if(board[row].charAt(col) != tmp[row%2].charAt(j)) wCount++;
			}
		}
		
		return Math.min(wCount, 64-wCount);
		
	}

}
