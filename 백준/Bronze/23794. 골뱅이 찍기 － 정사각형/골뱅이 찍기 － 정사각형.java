import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N + 2; i++){
            for(int j = 0; j < N + 2; j++){
                if(i == 0 || i == N+1 || j == 0 || j == N+1){
                    sb.append("@");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        
        // 출력
        System.out.println(sb);
    }
}