import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int [] count = new int[26];
        Arrays.fill(count, -1);
        for(int i = 0; i < str.length(); i++){
            int idx = str.charAt(i) - 'a';
            if(count[idx] == -1){
                count[idx] = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            sb.append(count[i]+" ");
        }
        
        System.out.println(sb);
    }
}