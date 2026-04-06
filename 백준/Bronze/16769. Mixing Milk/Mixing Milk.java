import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] c = new int[3]; // 용량
        int[] m = new int[3]; // 현재 우유
        
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            c[i] = Integer.parseInt(st.nextToken());
            m[i] = Integer.parseInt(st.nextToken());
        }
        
        // 100번 반복
        for (int i = 0; i < 100; i++) {
            int from = i % 3;
            int to = (i + 1) % 3;
            
            int move = Math.min(c[to] - m[to], m[from]);
            
            m[from] -= move;
            m[to] += move;
        }
        
        // 출력
        for (int i = 0; i < 3; i++) {
            System.out.println(m[i]);
        }
    }
}