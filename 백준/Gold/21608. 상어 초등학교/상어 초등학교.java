import java.io.*;
import java.util.*;

/*
 * |r1 - r2| + |c1 - c2| = 1을 만족하는 두 칸이 (r1, c1)과 (r2, c2) -> 4방탐색
 * 
 * 1. 좋아하는 학생이 인접칸에 가장 많은 칸
 * 2. 1을 만족하는 칸이 여러개 -> 인접한 칸 중 비어있는 칸이 가장 많은 칸으로 자리 정하기
 * 3. 2를 만족하는 칸이 여러개 -> 행 번호 가장 작은 칸, 열 번호 가장 작은 칸
 * */
public class Main {
	static int N;
	static int [][] map;
	static int total_student;	// 총 학생 수
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	static List<List<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		total_student = N*N;
		
		for(int i = 0; i <= total_student; i++) {
			list.add(new ArrayList<>());
		}
		
		// 1. 입력 및 자리배치
		map = new int[N][N];
		for(int i = 0; i < total_student; i++) {
			// (1) 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int target = Integer.parseInt(st.nextToken());
			for(int j = 0; j < 4; j++) {
				list.get(target).add(Integer.parseInt(st.nextToken()));
			}
			
			// (2) 자리 배치
			solve(target);
			
		}		
		
		// 2. 만족도 조사
		int [] score = {0, 1, 10, 100, 1000};
		int total_score = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int cnt = 0;	// 좋아하는 학생 수
				
				for(int k = 0; k < 4; k++) {
					int tx = i + dx[k];
					int ty = j + dy[k];
					
					if(!checkRange(tx, ty)) continue;
					if(list.get(map[i][j]).contains(map[tx][ty])) {
						cnt++;	// 인접 영역에 좋아하는 학생 존재
					}
				}
				
				// 만족도 조사
				total_score += score[cnt];
			}
		}
		
		// 결과 출력
		System.out.println(total_score);
		
		
	}
	
	static void solve(int target) {
		int r = N;
		int c = N;
		int count = 0;	// 좋아하는 학생의 수
		int empty = 0;	// 주변에 비어있는 칸의 수
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] != 0) continue;	// 이미 차있음
				
				int curCount = 0;	// 현재 칸 기준, 좋아하는 학생 수
				int curEmpty = 0;	// 현재 칸 기준, 비어있는 칸 수
				for(int k = 0; k < 4; k++) {
					int tx = i + dx[k];
					int ty = j + dy[k];
					
					if(!checkRange(tx, ty)) continue;
					if(map[tx][ty] == 0)curEmpty++;
					if(list.get(target).contains(map[tx][ty])) {
						curCount++;	// 인접 영역에 좋아하는 학생 존재
					}
					
				}
				
				if(curCount > count) {
					
					r = i;
					c = j;
					count = curCount;
					empty = curEmpty;
				}else if(curCount == count) {
					if(curEmpty > empty) {
						r = i;
						c = j;
						count = curCount;
						empty = curEmpty;
					}else if(curEmpty == empty) {
						if(i < r) {
							r = i;
							c = j;
							count = curCount;
							empty = curEmpty;
						}else if(i == r) {
							if(j < c) {
								r = i;
								c = j;
								count = curCount;
								empty = curEmpty;
							}
						}
					}
				}
			}
		
		}
		
		// 자리 확정
		map[r][c] = target;
	}
	
	static boolean checkRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
