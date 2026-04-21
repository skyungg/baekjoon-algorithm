import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int [] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        // 정렬
        Arrays.sort(arr);
        
        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(arr[i]+" ");
        }
        
        System.out.println(sb);
    }
}