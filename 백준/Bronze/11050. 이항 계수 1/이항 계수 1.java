import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        System.out.println(dfs(N) / (dfs(K)*dfs(N-K)));

	}
	
	static long dfs(int num){
        if(num == 1 || num == 0) return 1;
        
        return num * dfs(num - 1);
    }

}
