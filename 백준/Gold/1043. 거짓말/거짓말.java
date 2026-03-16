import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [] parent;
	static Set<Integer> set = new HashSet<>();
	static List<List<Integer>> party = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for(int i = 1; i <= N; i++) parent[i] = i;	// 자기자신으로 초기화
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());	// 진실 아는 사람 수
		
		for(int t = 0; t < T; t++) {
			set.add(Integer.parseInt(st.nextToken()));	// 처음부터 진실 알고 있는 사람
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());	// 현재 파티 참석한 사람 수
			
			List<Integer> tmp = new ArrayList<>();
			for(int j = 0; j < cnt; j++) {
				tmp.add(Integer.parseInt(st.nextToken()));
			}
			
			party.add(tmp);
		}
		
		// union
		for(List<Integer> list : party){
			int first = list.get(0);
			
			for(int i = 1; i < list.size(); i++) {
				union(first, list.get(i));
			}
		}
		
		// 진실 
		Set<Integer> truth = new HashSet<>();
		for(int s : set) {
			truth.add(find(s));
		}
		
		// 정답 
		int result = 0;
		for(List<Integer> list : party) {
			boolean flag = true;
			
			for(int n : list) {
				if(truth.contains(find(n))) {
					flag = false;
					break;
				}
			}
			
			if(flag) result++;
		}
		
		// 출력
		System.out.println(result);
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int a, int b) {
		int pa = find(a);	// a의 부모
		int pb = find(b);	// b의 부모
		
		if(pa != pb) parent[pb] = pa;
	}

}
