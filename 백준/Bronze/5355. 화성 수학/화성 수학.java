import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            String [] arr = br.readLine().split(" ");
            double num = Double.parseDouble(arr[0]);
            for(int i = 1; i < arr.length; i++){
                String op = arr[i];
                if(op.equals("@")){
                    num *= 3;
                }else if(op.equals("%")){
                    num += 5;
                }else{
                    num -= 7;
                }
            }
            
            // 저장
            sb.append(String.format("%.2f\n", num));
        }
        
        // 출력
        System.out.println(sb);
    }
}