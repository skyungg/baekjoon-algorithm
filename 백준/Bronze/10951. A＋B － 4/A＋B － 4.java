import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            String str = br.readLine();
            
            if(str == null) break;    // 아무 입력 X -> 종료
            String [] nums = str.split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            
            sb.append((a+b)+"\n");
        }
        
        System.out.println(sb);
    }
}