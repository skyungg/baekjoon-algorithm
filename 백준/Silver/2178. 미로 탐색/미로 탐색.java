import java.io.*;
import java.util.*;

/*
    (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수
    -> bfs
*/

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int [][] map = new int[N][M];
        
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        // 미로 탐색하기
        bfs(map, N, M, 0, 0);
        
        // 결과 출력
        System.out.println(map[N-1][M-1]);    
        
    }
    
    static void bfs(int [][] map, int N, int M, int x, int y){
        Queue<int []> que = new LinkedList<>();
        que.add(new int [] {x, y});
        
        boolean [][] visited = new boolean[N][M];
        visited[x][y] = true;
        
        
        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, 1, 0, -1};
        
        while(!que.isEmpty()){
            int [] point = que.poll();
            
            if(point[0] == N-1 && point[1] == M-1) break;
            
            for(int i = 0; i < 4; i++){
                int tx = point[0] + dx[i];
                int ty = point[1] + dy[i];
                
                if(tx >= 0 && tx < N && ty >= 0 && ty < M){        // 범위 내 위치 만족
                    if(!visited[tx][ty] && map[tx][ty] == 1){    // 방문 전 및 이동 가능 위치
                        visited[tx][ty] = true;
                        que.add(new int [] {tx, ty});
                        map[tx][ty] = map[point[0]][point[1]] + 1;
                    }
                }
            }
        }
    }
}