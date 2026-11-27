import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int X = Integer.parseInt(br.readLine());
            
            if(X == 0){    // 출력
                if(pq.isEmpty()) sb.append(0+"\n");
                else sb.append(pq.poll()+"\n");
            }else{
                pq.add(X);
            }
        }
        
        // 출력
        System.out.println(sb);
    }
}