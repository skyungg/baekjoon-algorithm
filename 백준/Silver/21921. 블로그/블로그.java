import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        long [] arr = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            long cnt = Long.parseLong(st.nextToken());
            if(i == 1){
                arr[i] = cnt;
            }else{
                arr[i] = cnt + arr[i-1];
            }
            
        }
        
        // 판별
        long maxCount = 0;
        long freCount = 0;
        for(int i = X; i <= N; i++){
            long num = arr[i] - arr[i-X];
            if(maxCount == num){
                freCount++;
            }else if(maxCount < num){
                maxCount = num;
                freCount = 1;
            }
        }
        
        // 출력
        StringBuilder sb = new StringBuilder();
        if(maxCount == 0){
            sb.append("SAD");
        }else{
            sb.append(maxCount+"\n"+freCount);
        }
        System.out.println(sb);
        
    }
}