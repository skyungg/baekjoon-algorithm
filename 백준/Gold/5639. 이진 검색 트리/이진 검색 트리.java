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
		
		while(idx <= end && list.get(idx) < root) {		// 현재 root 기준 왼쪽 트리의 마지막 인덱스 찾기
			idx++;
		}
		
		// 후위 순회
		solve(start + 1, idx - 1);	// root 기준 왼쪽 트리 (root보다작은값)
		solve(idx, end);	// root 기준 오른쪽 트리 (root보다작은값)
		
		sb.append(root+"\n");

	}

}
