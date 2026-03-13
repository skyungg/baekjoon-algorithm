import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int [][] map;
	static List<int []> chickenList = new ArrayList<>();
	static List<int []> homeList = new ArrayList<>();
	static int result = Integer.MAX_VALUE;
	static int [] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) chickenList.add(new int[] {i, j});	// 치킨집 위치
				else if(map[i][j] == 1) homeList.add(new int[] {i, j});	// 집 위치
			}
		}
		
		if(M == chickenList.size()) {
			solve(chickenList);
		}else {
			arr = new int[M];
			recursion(0, 0);
		}
		
		// 출력
		System.out.println(result);
	}
	
	static void recursion(int depth, int start) {
		if(depth == M) {
			List<int []> tmp = new ArrayList<>();
			for(int idx : arr) {
				tmp.add(chickenList.get(idx));
			}
			solve(tmp);
			
			return;
		}
		
		for(int i = start; i < chickenList.size(); i++) {
			arr[depth] = i;
			recursion(depth+1, i+1);
		}
	}
	
	static void solve(List<int []> list) {
		int totalDist = 0;

		for(int i = 0; i < homeList.size(); i++) {
			int curMinDist = Integer.MAX_VALUE;
			int r1 = homeList.get(i)[0];
			int c1 = homeList.get(i)[1];
			
			for(int j = 0; j < list.size(); j++) {
				int r2 = list.get(j)[0];
				int c2 = list.get(j)[1];
				int dist = Math.abs(r1-r2) + Math.abs(c1-c2);
				curMinDist = Math.min(curMinDist, dist);	// 치킨집 리스트 중 치킨 거리 가장 작은 것 추출
			}
			totalDist+= curMinDist;

		}

		result = Math.min(result, totalDist);
	}

}
