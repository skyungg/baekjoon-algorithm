import java.util.*;
/*
초기 위치 (1, 1) , 상대진영 (n, m);
가중치 같음 -> 0-1 어쩌고?
*/
class Solution {
    int [] dx = {0, 0, 1, -1};  // 동서남북
    int [] dy = {1, -1, 0, 0};
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }
    
    public int bfs(int [][] map){
        Queue<int []> que = new LinkedList<>();
        que.add(new int [] {0, 0, 1});  // x,y,가중치
        
        int N = map.length;
        int M = map[0].length;
        
        boolean [][] visited = new boolean[N][M];
        visited[0][0] = true;
        
        int cnt = Integer.MAX_VALUE;
        
        while(!que.isEmpty()){
            int [] point = que.poll();
            
            if(point[0] == N-1 && point[1] == M-1){
                cnt = Math.min(cnt, point[2]);
                continue;
            }
            
            for(int i = 0; i < 4; i++){
                int tx = point[0] + dx[i];
                int ty = point[1] + dy[i];
                
                if(tx >= 0 && tx < N && ty >= 0 && ty < M){
                    if(map[tx][ty] == 1 && !visited[tx][ty]){
                        visited[tx][ty] = true;
                        que.add(new int [] {tx, ty, point[2]+1});
                    }
                }
            }
        }
        
        // 판별
        if(cnt == Integer.MAX_VALUE) return -1;
        else return cnt;
    }
}