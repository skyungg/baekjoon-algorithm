import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스의 수
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());    // 문서 개수
            int M = Integer.parseInt(st.nextToken());    // 찾을 문서
            
            int [] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            Queue<int []> que = new LinkedList<>();
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                que.add(new int[]{i, arr[i]});    // 순번, 우선순위
            }
            
            // 정렬
            Arrays.sort(arr);
            int idx = N-1;    // 우선순위 큰 값부터
            
            int count = 0;
            while(true){
                int [] point = que.poll();    // 꺼내기
                if(arr[idx] == point[1]){    // 진행할 우선순위일때
                    count++;
                    idx--;
                    if(point[0] == M)    break;    // 찾을 문서일경우
                }else{
                    que.add(point);    // 다시 집어넣기
                }
                
            }
            
            // 저장
            sb.append(count+"\n");
            
        }
        
        // 출력
        System.out.println(sb);
        
    }
}