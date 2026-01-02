import java.io.*;
import java.util.*;

/*
 * 동전의 개수 N -> 자료구조 배열이 적합(크기가 나와있으니까)
 * 최소 개수 -> 현재 M값을 나눌 때 몫이 1이상 가장 작은 수로 하기 -> 입력받으면서 나누어떨어지는 수 찾기
 * */

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 동전 개수
		int M = Integer.parseInt(st.nextToken());	// 만들어야 하는 값
		
		int [] arr = new int[N];
		int maxIdx = 0;	// M을 나눌 수 있는 가장 큰 값의 인덱스
		int maxCoin = 0;
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] > maxCoin) {
				maxCoin = arr[i];
				maxIdx = i;
			}
		}
		
		// 구현
		int count = 0;	// 최소 개수
		while(M > 0 && maxIdx >= 0) {
			count += M/arr[maxIdx];
			M = M%arr[maxIdx];
			
			maxIdx--;
		}
		
		System.out.println(count);

	}

}
