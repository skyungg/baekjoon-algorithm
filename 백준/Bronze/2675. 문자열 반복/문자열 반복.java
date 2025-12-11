import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            for(int i = 0; i < S.length(); i++){
                for(int j = 0; j < n; j++){
                    sb.append(S.charAt(i));
                }
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}
