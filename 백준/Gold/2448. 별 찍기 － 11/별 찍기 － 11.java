import java.io.*;
import java.util.*;

/*
 * 삼각형 하나를 3개의 작은 삼각형으로 쪼개는 재귀
 * 삼각형 하나를 복사해서 3군데에 붙이는 재귀
 * */
public class Main {
	static char [][] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new char[N][2*N];
		
		// 초기화
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2*N; j++) {
				arr[i][j] = ' ';
			}
		}
		
		draw(0, N-1, N);	// (0, N-1): 꼭대기 별 위치, N: 삼각형 높이
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(arr[i]).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	/*
	 * (x, y)를 꼭짓점으로 하는
	 * 높이가 size인 삼각형을 그린다
	 * 
	 * */
	static void draw(int x, int y, int size) {
		if(size == 3) {							// 삼각형 하나 만들어짐
			arr[x][y] = '*';
			arr[x+1][y-1] = '*';
			arr[x+1][y+1] = '*';
			
			for(int i = -2; i <= 2; i++) {
				arr[x+2][y+i] = '*';
			}
			return;
		}
		
		int half = size/2;
		
		// 위
		draw(x, y, half);
		
		// 왼쪽 아래
		draw(x + half, y - half, half);
		
		// 오른쪽 아래
		draw(x + half, y + half, half);
	}

}
