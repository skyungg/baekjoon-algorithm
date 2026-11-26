import java.io.*;
import java.util.*;

/*
   "서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사"
   == 총 몇 마리의 지렁이가 필요한지
   == 인접 영역이 몇 개 인지 구하기
*/

public class Main{
    static int N, M;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, 1, 0, -1};
    static int [][] map;
    static boolean [][] visited;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());    // 테스트케이스의 개수
        StringBuilder sb = new StringBuilder();
        
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());    // 가로(열)
            N = Integer.parseInt(st.nextToken());    // 세로(행)
            int K = Integer.parseInt(st.nextToken());    // 심어진 배추 개수
            
            map = new int[N][M];
            visited = new boolean[N][M];
            Queue<int []> que = new LinkedList<>();
            
            // 유기농 배추 있는 위치
            for(int k = 0; k < K; k++){
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                
                map[r][c] = 1;    // 배추 표시
                que.add(new int[]{r, c});
            }
            
            // 영역 구하기
            int result = 0;
            while(!que.isEmpty()){
               int [] point = que.poll();
                
               if(visited[point[0]][point[1]]) continue;    // 이미 방문 완료
                
               
               dfs(point[0], point[1]);
               
               result++;
            }
            
            sb.append(result+"\n");

        }
        
        // 결과 출력
        System.out.println(sb);
        
    }
    
    static void dfs(int x, int y){
        visited[x][y] = true;    // 방문 처리
        
        for(int i = 0; i < 4; i++){
            int tx = x + dx[i];
            int ty = y + dy[i];
                    
            if(tx >= 0 && tx < N && ty >= 0 && ty < M){    // 범위 내 존재
               if(!visited[tx][ty] && map[tx][ty] == 1){    // 방문 전 + 배추 심어진 위치   
                  dfs(tx, ty);
               }
            }
        }           
    }
}