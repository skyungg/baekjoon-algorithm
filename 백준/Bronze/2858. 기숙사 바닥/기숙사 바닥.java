import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int R = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int L = 0;
        int W = 0;
        
        for(int i = 1; i * i <= B; i++){
            if(B % i == 0){
                int a = i;
                int b = B / i;

                L = b + 2;
                W = a + 2;

                if(L * W == R + B){
                    break;
                }
            }
        }
        
        // 출력
        System.out.println(L + " " + W);
    }
}