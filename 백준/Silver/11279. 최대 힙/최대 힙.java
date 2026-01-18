import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < N; i++){
            long num = Long.parseLong(br.readLine());
            if(num == 0){
                if(!pq.isEmpty()) sb.append(pq.poll()+"\n");
                else sb.append(0+"\n");
            }else pq.add(num);
        }
            
        // 출력
        System.out.println(sb);
        
    }
}