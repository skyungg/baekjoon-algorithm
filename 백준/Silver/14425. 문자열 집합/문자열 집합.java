import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            set.add(str);
        }
        
        // 집합S에 포함된 문자열 구하기
        int result = 0;
        for(int i = 0; i < M; i++){
            String str = br.readLine();
            
            if(set.contains(str)){    // 포함된 경우
                result++;
            }
        }
        
        // 결과 출력
        System.out.println(result);
        
    }
}