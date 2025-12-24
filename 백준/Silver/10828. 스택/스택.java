import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Point pStack = new Point();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			
			if(op.equals("push")) {		// 정수 x 스택에 넣기
				int num = Integer.parseInt(st.nextToken());
				pStack.push(num);
			}else if(op.equals("pop")) {		//스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				sb.append(pStack.pop()+"\n");
			}else if(op.equals("size")) {		//스택에 들어있는 정수의 개수를 출력
				sb.append(pStack.size()+"\n");
			}else if(op.equals("empty")) {		//스택이 비어있으면 1, 아니면 0을 출력
				sb.append(pStack.empty()+"\n");			
			}else{											//스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력
				sb.append(pStack.top()+"\n");	
			}
		}
		
		System.out.println(sb);

	}
	
	static class Point{
		List<Integer> list = new ArrayList<>();
		
		public Point() {};
		
		public void push(int num) {
			list.add(num);
		}
		
		public int pop() {
			if(list.isEmpty()) return -1;
			else {
				int result = list.get(list.size()-1);
				list.remove(list.size()-1);
				return result;
			}
		}
		
		public int size() {
			return list.size();
		}
		
		public int empty() {
			if(list.isEmpty()) return 1;
			else return 0;
		}
		
		public int top() {
			if(list.isEmpty()) return -1;
			else return list.get(list.size()-1);
		}
	}

}
