import java.io.*;
import java.util.*;

public class Main {
	static class Point{
		int num;
		String op;
		
		public Point(int num, String op) {
			this.num = num;
			this.op = op;
		}
	}
	static boolean [] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			Queue<Point> que = new LinkedList<>();
			que.add(new Point(A, ""));
			visited = new boolean[10000];
			visited[A] = true;		
			while(!que.isEmpty()) {
				Point p = que.poll();
				
				if(p.num == B) {	// B확정
					sb.append(p.op+"\n");
					break;
				}
				
				for(int i = 0; i < 4; i++) {
					if(i == 0) {
						// D
						int tmp = 2*p.num;
						if(tmp > 9999) {
							tmp %= 10000;
						}
						if(visited[tmp]) continue;	//이미 방문
						visited[tmp] = true;
						que.add(new Point(tmp, p.op+"D"));
						
					}else if(i == 1) {
						// S
						int tmp = p.num;
						if(tmp == 0) {
							tmp = 9999;
						}else {
							tmp = p.num - 1;							
						}
						
						if(visited[tmp]) continue;	//이미 방문
						visited[tmp] = true;
						que.add(new Point(tmp, p.op+"S"));

					}else if(i == 2) {
						int lNum = (p.num%1000) * 10 + (p.num/1000);
						if(visited[lNum]) continue;	//이미 방문
						visited[lNum] = true;
						que.add(new Point(lNum, p.op+"L"));
						
					}else {
						// R
						int rNum = (p.num%10)*1000 + (p.num/10);

						if(visited[rNum]) continue;	//이미 방문
						visited[rNum] = true;
						que.add(new Point(rNum, p.op+"R"));
					}
				}
			}
		}
		
		// 출력
		System.out.println(sb);
	}

}
