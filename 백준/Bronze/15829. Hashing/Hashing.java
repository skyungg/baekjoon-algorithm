import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        
        char [] arr = br.readLine().toCharArray();
        long r = 31;
        long m = 1234567891;        // 범위 확인
        long result = 0;
        long pow = 1;
        
        for(int i = 0; i < L; i++){
            long n = arr[i] - 'a' + 1;    // a = 1
            result = (result + n*pow) % m;
            pow = (pow*r)%m;
        }
        
        System.out.println(result);
        
    }
}