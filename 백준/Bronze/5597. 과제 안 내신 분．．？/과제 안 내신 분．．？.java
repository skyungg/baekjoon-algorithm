import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean [] visited = new boolean[31];
        for(int i = 0; i < 28; i++){
            int num = Integer.parseInt(br.readLine());
            visited[num] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 30; i++){
            if(!visited[i])sb.append(i+"\n");
        }
        
        // 출력
        System.out.println(sb);
    }
}