import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static List<int []> chickenList = new ArrayList<>();
	static List<int []> homeList = new ArrayList<>();
	static int [][] dist;
	static boolean [] visited;
	static int minDist = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 2) chickenList.add(new int[] {i, j});	// 치킨집 위치
				else if(num == 1) homeList.add(new int[] {i, j});	// 집 위치
			}
		}
		
		// 각 집마다 - 치킨집별  치킨 거리 구하기
		dist = new int[homeList.size()][chickenList.size()];
		
		for(int i = 0; i < homeList.size(); i++) {
			int r1 = homeList.get(i)[0];
			int c1 = homeList.get(i)[1];
			
			for(int j = 0; j < chickenList.size(); j++) {
				int r2 = chickenList.get(j)[0];
				int c2 = chickenList.get(j)[1];
				dist[i][j] = Math.abs(r1-r2) + Math.abs(c1-c2);
			}
		}
		
		// M개 치킨집 뽑기
		visited = new boolean[chickenList.size()];
		recursion(0, 0);
		
		// 출력
		System.out.println(minDist);
	}
	
	static void recursion(int depth, int start) {
		if(depth == M) {
			minDist = Math.min(minDist, calDist());
			
			return;
		}
		
		for(int i = start; i < chickenList.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				recursion(depth+1, i+1);
				visited[i] = false;
			}
		}
	}
	
	static int calDist() {
		int totalDist = 0;

		for(int i = 0; i < homeList.size(); i++) {
			int curMinDist = Integer.MAX_VALUE;
			for(int j = 0; j < chickenList.size(); j++) {
				if(visited[j]) {
					curMinDist = Math.min(curMinDist, dist[i][j]);
				}
			}
			totalDist += curMinDist;
		}
		
		return totalDist;
	}

}
