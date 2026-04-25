import java.io.*;
import java.util.*;

/*
 * (구) -> T초 후 남아있는 미세먼지 양 구하기
 * 미세먼지 초기 위치: (r, c)
 * 1. 미세먼지 확산
 * 	(1)인접 네 방향으로 확산 (공기청정기, 범위 밖 -> X)
 * 	(2) 확산되는 양, A[i][j]/5 , 
 *  (3) (i, j) 에 남은 미세먼지 양 -> a[i][j] - a[i][j]/5
 * 2. 공기청정기 작동
 * 	(1) 위쪽 공기청정기  -> 반시계, 아래쪽 공기청정기 -> 시계 방향
 *  (2) 바람 불면 -> 미세먼지가 발마의 방향대로 모두 한 칸씩 이동
 *  (3) 공기청정기에서 부는 바람은 미세먼지가 없는 바람
 *  
 *  
 * */
public class Main {
	static int R, C, T;
	static int [][] A;
	static int [] air = new int[2];
	
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		A = new int[R][C];
		
		int idx = 0;
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				
				if(A[i][j] == -1) {		// 공기 청정기 위치
					air[idx++] = i;		// 존재 행 저장
				}
			}
		}
		
		while(T > 0) {
			// 1. 확산
			spread();
			
			// 2. 공기 청정기
			clean();
			
			T--;
		}
		
		// 미세먼지 양 산출
		System.out.println(cal());
	}
	
	static void spread() {
		int [][] nextA = new int[R][C];	// 확산 후, 방
		
		for(int i = 0; i < 2; i++) {
			nextA[air[i]][0] = -1;	// 공기 청정기 유지
		}

		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(A[i][j] > 0) {		// 현재 위치에 미세먼지 존재
					int amount = A[i][j] / 5;
					int count = 0;
					
					for(int idx = 0; idx < 4; idx++) {
						int tx = i + dx[idx];
						int ty = j + dy[idx];
						
						if(isRange(tx, ty) && A[tx][ty] != -1) {
							nextA[tx][ty] += amount;
							count++;
						}
					}
					
					nextA[i][j] += A[i][j] - (amount*count);
				}
			}
		}
		
		A = nextA;
	}
	
	static boolean isRange(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
	
	static void clean() {
		int top = air[0];
		int bottom = air[1];
		
		// 1. 위쪽 공기청정기 (시계방향)
	    for (int i = top - 1; i > 0; i--) A[i][0] = A[i - 1][0];
        for (int j = 0; j < C - 1; j++) A[0][j] = A[0][j + 1];
        for (int i = 0; i < top; i++) A[i][C - 1] = A[i + 1][C - 1];
        for (int j = C - 1; j > 1; j--) A[top][j] = A[top][j - 1];
        A[top][1] = 0;
        
		// 2. 아래쪽 공기청정기	(시계반대방향)
        for (int i = bottom + 1; i < R - 1; i++) A[i][0] = A[i + 1][0];
        for (int j = 0; j < C - 1; j++) A[R - 1][j] = A[R - 1][j + 1];
        for (int i = R - 1; i > bottom; i--) A[i][C - 1] = A[i - 1][C - 1];
        for (int j = C - 1; j > 1; j--) A[bottom][j] = A[bottom][j - 1];
        A[bottom][1] = 0;
	}
	
	static int cal() {
		int result = 0;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(A[i][j] > 0) result += A[i][j];
			}
		}
		
		return result;
	}

}
