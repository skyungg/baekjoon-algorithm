import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        str = str.toUpperCase();    // 대문자
        
        int [] arr = new int[26];
        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i)-'A']++;
        }
        
        int max = -1;
        char result = '?';
        
        for(int i = 0; i < 26; i++){
            if(arr[i] > max){
                max = arr[i];
                result = (char)(i + 'A');
            }else if(arr[i] == max){
                result = '?';
            }
        }
        
        // 출력
        System.out.println(result);
        
        
    }
}