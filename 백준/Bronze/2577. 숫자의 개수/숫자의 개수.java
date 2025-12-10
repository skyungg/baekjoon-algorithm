import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long total = 1;
        for(int i = 0; i < 3; i++){
            total *= Integer.parseInt(br.readLine());
        }
        
        // int -> String
        String str = String.valueOf(total);
        
        int [] nums = new int[10];
        for(int i = 0; i < str.length(); i++){
            nums[str.charAt(i)-'0']++;
        }
        
        // 결과 출력 
        for(int i = 0; i < 10; i++){
            System.out.println(nums[i]);
        }
    }
}