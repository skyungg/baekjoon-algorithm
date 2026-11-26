import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());    // 필요 운동시간
        int m = Integer.parseInt(st.nextToken());    // 초기 맥박 및 맥박 최솟값 
        int M = Integer.parseInt(st.nextToken());    // 맥박 최댓값
        int T = Integer.parseInt(st.nextToken());    // 맥박 증가량
        int R = Integer.parseInt(st.nextToken());    // 맥박 감소
        
        
        int min = 0;
        int totalMin = 0;
        int curM = m;
        
        if(m+T > M){
            System.out.println(-1);
            return;
        }
        
        while(min < N){
            if(curM+T <= M){    // 운동 O -> 맥박 증가
                curM += T;
                min++;
            }else{    // 운동 X -> 맥박 감소
                curM = Math.max(curM-R, m);
            }
            
            totalMin++;    // 전체 시간
       }
        
        
        // 출력
        System.out.println(totalMin);

    }
}