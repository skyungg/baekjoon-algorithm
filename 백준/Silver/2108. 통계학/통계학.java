import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		double sum = 0;
		int [] nums = new int[N];
		HashMap<Integer, Integer> hmap = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());	
			sum += nums[i];
			hmap.put(nums[i], hmap.getOrDefault(nums[i], 0)+1);
		}

		StringBuilder sb = new StringBuilder();
		// 1. 산술평균
		sb.append(Math.round((sum/N))+"\n");		// 첫 번째 자리에서 반올림
		
		// 정렬하기
		Arrays.sort(nums);
		
		// 2. 중앙값
		if(N%2 == 0) sb.append(nums[(N/2)-1]+"\n");
		else sb.append(nums[N/2]+"\n");

		// 3. 최빈값
		int count = 0;
		List<Integer> list = new ArrayList<>();
		for(int key : hmap.keySet()) {
			if(hmap.get(key) > count) {
				list.clear();
				list.add(key);
				count = hmap.get(key);
			}else if(hmap.get(key) == count) {
				list.add(key);
			}
		}
		
		if(list.size() > 1) {
			Collections.sort(list);
			sb.append(list.get(1)+"\n");
		}else {			
			sb.append(list.get(0)+"\n");
		}
		
		// 4. 범위
		sb.append((nums[N-1] - nums[0])+"\n");
		
		
		// 정답 출력
		System.out.println(sb);
	}

}
