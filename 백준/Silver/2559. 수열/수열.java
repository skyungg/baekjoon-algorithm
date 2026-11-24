import java.io.*;
import java.util.*;

class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int [] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num + arr[i-1];
        }
        
        int result = Integer.MIN_VALUE;
        //판별
        for(int i = K; i <= N; i++){
            int dif = arr[i]-arr[i-K];
            result = Math.max(result, dif);
        }
        
        // 출력
        System.out.println(result);
        
    }
}