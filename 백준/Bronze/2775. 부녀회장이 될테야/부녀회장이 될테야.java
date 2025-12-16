import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        int [][] room = new int[15][15];
        for(int i = 1; i <= 14; i++){
            room[0][i] = i;
            room[i][1] = 1;
        }
        
        for(int i = 1; i <= 14; i++){
            for(int j = 2; j <= 14; j++){
                room[i][j] = room[i][j-1]+room[i-1][j];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            int k = Integer.parseInt(br.readLine());    // 층
            int n = Integer.parseInt(br.readLine());    // 호

            sb.append(room[k][n]+"\n");
        }
        
        System.out.println(sb);
    }
}