import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        int dif = A-B;
        int height = V-A;    // 정상에 도착한 날은 미끄러지지 않음.
        
        int result = 0;
        if(height == 0) result = 1;    // 오늘 하루만 오르면 끝
        else{
            result = height/dif;
            
            if(height%dif != 0) result++;    // 하루 더 올라야함
            result++;    // 하루 추가로 더 올라야하니까(V-A 했으니까)
        }
        
        System.out.println(result);
    }
}