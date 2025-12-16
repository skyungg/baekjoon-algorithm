import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        if(N > M){            // N 작은 수, M 큰 수
            int tmp = N;
            N = M;
            M = tmp;
        }
        
        int gcd = getGcd(N, M);
        System.out.println(gcd);    // 최대 공약수
        System.out.println((N*M)/gcd);    // 최소 공배수
        
    }
    
    static int getGcd(int n, int m){
        if(m%n == 0) 
            return n;
        
        return getGcd(m%n, n);
    }
    
}