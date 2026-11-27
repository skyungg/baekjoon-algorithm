import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int idx = 1;
        while(list.size() <= B){
            for(int i = 0; i < idx; i++){
                list.add(idx);
            }
            idx++;
        }
        
        int sum = 0;
        for(int i = A; i <= B; i++){
            sum += list.get(i);
        }
        
        // 출력
        System.out.println(sum);
        
    }
}