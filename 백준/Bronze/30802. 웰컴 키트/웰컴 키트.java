import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 참가자 수
        
        int [] size = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 6; i++){
            int s = Integer.parseInt(st.nextToken());
            size[i] = s;
        }
        
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        int total_count = 0;
        for(int i = 0; i < size.length; i++){
            int d = size[i]/T;
            int m = size[i]%T;
            
            total_count += d;
            if(m > 0) total_count++;
        }
        
        System.out.println(total_count);
        System.out.println((N/P)+" "+N%P);    // 연필 묶음 수

    }
}