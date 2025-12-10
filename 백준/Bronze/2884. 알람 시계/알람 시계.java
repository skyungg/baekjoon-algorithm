import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int total = (h*60 + m) - 45;
        if(total < 0 ) total += 24*60;    // 전날밤
        System.out.print(total/60 + " "+total%60);
    }
}