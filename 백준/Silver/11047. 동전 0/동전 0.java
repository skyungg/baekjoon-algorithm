import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int [] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int count = 0;
        int idx = N-1;
        while(K > 0){
            if(arr[idx] <= K){
                int cnt = K/arr[idx];
                K -= arr[idx]*cnt;
                count += cnt;
            } 
            idx--;
       }
        
        // 출력
        System.out.println(count);
    }
}