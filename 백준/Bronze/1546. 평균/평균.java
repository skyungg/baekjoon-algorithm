import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = 0;    // 점수중 최댓값
        int [] score = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            score[i] = Integer.parseInt(st.nextToken());
            M = Math.max(M, score[i]);    // 최댓값 차기
        }
        
        // 점수 조정하기
        double sum = 0;
        for(int i = 0; i < N; i++){
            sum += ((double)score[i]/M)*100;
        }
        
        // 결과 출력
        System.out.println(sum/N);
    }
}