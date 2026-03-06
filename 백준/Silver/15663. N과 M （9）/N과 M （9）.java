import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [] arr;
	static int [] nums;
	static int [] count;
	static List<Integer> list = new ArrayList<>();
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		arr = new int[M];
		count = new int[10001];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			count[nums[i]]++;
			if(!list.contains(nums[i])) list.add(nums[i]);
		}
		
		// 정렬
		Arrays.sort(nums);
		Collections.sort(list);
		
		// 재귀
		sb = new StringBuilder();
		recursion(0, 0);
		
		// 출력
		System.out.println(sb);
		
	}
	
	static void recursion(int depth, int idx) {
		if(depth == M) {
			for(int n : arr) {
				sb.append(n+" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i = 0; i < list.size(); i++) {
			if(count[list.get(i)] > 0) {
				arr[depth] = list.get(i);
				count[list.get(i)]--;
				recursion(depth+1, idx);
				count[list.get(i)]++;
			}
		}
	}

}
