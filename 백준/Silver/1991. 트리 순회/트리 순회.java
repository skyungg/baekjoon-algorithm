import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static HashMap<String, List<String>> map = new HashMap<>();	// key:부모, value 자식
	static String result;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String p = st.nextToken();
			List<String> list = new ArrayList<>();
			list.add(st.nextToken());
			list.add(st.nextToken());
			
			map.put(p, list);
		}
		
		System.out.println(search());
		
		// 출력
		
	}
	
	static String search() {
		StringBuilder sb = new StringBuilder();
		
		init();
		preOrder("A");
		sb.append(result+"\n");		// 전위 순회
		
		init();
		inOrder("A");
		sb.append(result+"\n");		// 중위 순회
		
		init();
		postOrder("A");
		sb.append(result+"\n");		// 후위 순회
		
		return sb.toString();
	}

	
	static void preOrder(String node) {
		// 1. "."인지 판단하기
		if(node.equals(".")) return;

		result += node;
		
		List<String> list = map.get(node);
		
		preOrder(list.get(0));	// 왼쪽 자식
		preOrder(list.get(1));  // 오른쪽 자식
	}
	
	static void inOrder(String node) {
		// 1. "."인지 판단하기
		if(node.equals(".")) return;

		
		List<String> list = map.get(node);
		
		inOrder(list.get(0));	// 왼쪽 자식
		result += node;
		inOrder(list.get(1));  // 오른쪽 자식
	}
	
	static void postOrder(String node) {
		// 1. "."인지 판단하기
		if(node.equals(".")) return;

		
		List<String> list = map.get(node);
		
		postOrder(list.get(0));	// 왼쪽 자식
		postOrder(list.get(1));  // 오른쪽 자식
		result += node;
	}
	
	
	static void init() {
		result = "";
	}
	
}
