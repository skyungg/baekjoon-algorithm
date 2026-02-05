import java.io.*;
import java.util.*;

public class Main {
	static int N, r, c;
	static int result = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		
		// 분할정복
		solve(N, r, c);
		
		// 출력
		System.out.println(result);
		
	}
	
	static void solve(int n, int x, int y) {
		if(n == 0) return;	// 더이상 구할 게 X
		
		int fullLength = (int) Math.pow(2, n);		// 전체 한변의 길이
		int mid = fullLength / 2;					//반으로 나눈 길이
		int count = mid*mid;			// 한 변이 mid인 정사각형 사분면에 해당되는 크기
		
		if(x < mid && y < mid) {	// 1사분면
			solve(n-1, x, y);		// 현재는 사분면 -> 다음 차례에는 full사각형
			
		}else if(x < mid && y >= mid ) {	// 2사분면
			result += count;
			solve(n-1, x, y - mid);		// (0, 0)이 시작점인 full 사각형으로 가니까 mid만큼 빼기
			
		}else if(x >= mid && y < mid ) {	// 3사분면
			solve(n-1, x-mid, y);
			result += count*2;
			
		}else {		// 4사분면
			solve(n-1, x-mid, y-mid);
			result += count*3;
		}
		
		
		
	}

}
