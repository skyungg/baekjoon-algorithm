import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int t = 0; t < T; t++){
            char [] arr = br.readLine().toCharArray();
            
            int sum = 0;
            int pre = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == 'O'){
                    pre++;
                    sum += pre;
                }else{
                    pre = 0;
                }
            }
            sb.append(sum+"\n");
        }
        
        System.out.println(sb);
        
    }
}