import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        HashMap<Character, Character> map = new HashMap<>();
        
        map.put('l', 'L');
        map.put('I', 'i');
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < str.length(); i++){
            sb.append(map.get(str.charAt(i)));
        }
        
        // 출력
        System.out.println(sb);
    }
}