import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int num = 0;
        for(int i = 0; i < N; i++){
            num = Integer.parseInt(st.nextToken());
            if(num < X) sb.append(num+" ");
        }
        
        // 결과 출력 
        System.out.println(sb);
    }
}