import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int []>() {
			@Override
			public int compare(int [] a, int [] b) {
				if(a[0] == b[0]) return a[1] - b[1];
				return a[0] - b[0];
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int [] tmp : arr) {
			sb.append(tmp[0]+" "+tmp[1]+"\n");
		}
		
		System.out.println(sb);
	}

}
