import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			set.add(nums[i]);
		}
		
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);		// 오름차순 정렬
		HashMap<Integer, Integer> hmap = new HashMap<>();
		for(int i = 0; i < list.size(); i++) {
			if(hmap.containsKey(list.get(i))) continue;
			else hmap.put(list.get(i), i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(hmap.get(nums[i]) + " ");
		}
		
		// 출력
		System.out.println(sb);
	}

}
