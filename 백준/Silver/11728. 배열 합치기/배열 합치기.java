import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int [] A = new int[N];
        int [] B = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        long [] result = new long[N+M];
        
        int aIdx = 0;
        int bIdx = 0;
        int idx = 0;
        while(true){
            if(aIdx >= N && bIdx >= M) break;    // 배열 합치기 종료
            
            if(aIdx < N && bIdx < M){
                if(A[aIdx] <= B[bIdx]){
                    result[idx] = A[aIdx];
                    aIdx++;
                }else if(A[aIdx] > B[bIdx]){
                    result[idx] = B[bIdx];
                    bIdx++;
                }
                idx++;
            }
            if(aIdx >= N && bIdx < M){
                while(bIdx < M){
                    result[idx++] = B[bIdx++];
                }
            }
            if(aIdx < N && bIdx >= M){
                while(aIdx < N){
                    result[idx++] = A[aIdx++];
                }
            }
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(long res : result) sb.append(res+" ");
        System.out.println(sb);
    }
}