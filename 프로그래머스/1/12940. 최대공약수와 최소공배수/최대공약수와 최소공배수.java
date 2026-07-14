import java.util.*;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int tmp = n;
        if(n < m){
            n = m;
            m = tmp;
        }
        answer[0] = gcd(n, m);   // 최대 공약수
        answer[1] = n*m / answer[0];   // 최소 공배수
            
        return answer;
    }
    
    int gcd(int n, int m){
        if(n % m == 0) return m;
        
        return gcd(m, n%m);
    }
}