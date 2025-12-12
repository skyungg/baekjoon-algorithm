import java.io.*;
import java.util.*;

/*에스트라테네스의 체?*/
public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int [] nums = new int[N];
        int maxNum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            maxNum = Math.max(maxNum, nums[i]);
        }
        
        // maxNum 까지의 소수 구하기
        boolean [] isPrime = new boolean[maxNum+1];
        isPrime[0] = true;    // 소수 아님
        isPrime[1] = true;
        
        for(int i = 2; i <= Math.sqrt(maxNum); i++){
            if(!isPrime[i]) {
                for(int j = i * i; j < isPrime.length; j = j+i) {
			        isPrime[j] = true;
        	    }
            };
            
            
        }
        
        int count = 0;
        for(int num : nums){
            if(!isPrime[num]) count++;
        }
        
        System.out.println(count);
    }
}