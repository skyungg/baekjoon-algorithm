import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Point que = new Point();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			
			if(op.equals("push")) {		// 정수 x 스택에 넣기
				int num = Integer.parseInt(st.nextToken());
				que.push(num);
			}else if(op.equals("pop")) {		
				sb.append(que.pop()+"\n");
			}else if(op.equals("size")) {		
				sb.append(que.size()+"\n");
			}else if(op.equals("empty")) {		
				sb.append(que.empty()+"\n");			
			}else if(op.equals("front")){											
				sb.append(que.front()+"\n");	
			}else {
				sb.append(que.back()+"\n");
			}
		}
		
		System.out.println(sb);
	}
	
	static class Point{
		List<Integer> list;
		
		public Point() {
			this.list = new LinkedList<>();
		};

		
		
		public void push(int num) {		// 정수 X를 큐에 넣는 연산
			list.add(num);
		}
		
		public int pop() {		// pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			if(list.isEmpty()) return -1;
			else {
				int result = list.get(0);
				list.remove(0);
				return result;
			}
		}
		
		public int size() {		// 큐에 들어있는 정수의 개수를 출력
			return list.size();
		}
		
		public int empty() {	// 큐가 비어있으면 1, 아니면 0을 출력
			if(list.isEmpty()) return 1;
			else return 0;
		}
		
		public int front() {		// 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
			if(list.isEmpty()) return -1;
			else return list.get(0);
		}
		
		public int back() {		// 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
			if(list.isEmpty()) return -1;
			else return list.get(list.size()-1);
		}
		
	}
}
