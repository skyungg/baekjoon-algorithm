import java.io.*;
import java.util.*;

/*
몫: 호수
나머지: 층
*/

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int H, W, N;
        StringBuilder sb = new StringBuilder();
        int f, r;    // 층수, 호실
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            
            if(N%H == 0){        // 마지막 층
                f = H;
                r = N/H;
            }else{
                f = N%H;
                r = N/H + 1;
            }
            
            if(r <= 9) sb.append(f+"0"+r+"\n");
            else sb.append(f+""+r+"\n");
        }
        
        System.out.println(sb);

    }
}




