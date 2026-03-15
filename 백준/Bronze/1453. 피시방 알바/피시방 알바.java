import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean [] visited = new boolean[101];
        
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!visited[num]){
                visited[num] = true;
            }else{
                count++;
            }
        }
        
        // 출력
        System.out.println(count);
    }
}