import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		while(true) {
			String str = br.readLine();
			
			if(str == null || str.equals("")) break;
			list.add(Integer.parseInt(str));
		}

		solve(0, list.size() - 1);
		
		System.out.println(sb);
	}
	
	static void solve(int start, int end) {
		if(start > end) return;
		
		int root = list.get(start);
		
		int idx = start + 1;
		
		while(idx <= end && list.get(idx) < root) {
			idx++;
		}
		
		solve(start + 1, idx - 1);	// 왼쪽
		solve(idx, end);	// 오른쪽
		
		sb.append(root+"\n");

	}

}
