import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int [] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 정렬
        Arrays.sort(arr);
        int result = arr[0];
        for(int i = 1; i < N; i++){
            arr[i] += arr[i-1];
            result += arr[i];
        }
        
        // 출력
        System.out.println(result);
    }
}