/*
-> 영역 구하기
1. 1~n까지 bfs 돌려서 연결연결 visited 배열 표시하기
2. 1의 과정거치면서 방문하지 않은 경우-> 네트워크 1증가
*/

import java.util.*;

class Solution {
    int n;
    int [][] computers;
    boolean [] visited;
   
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.n = n;
        this.computers = computers;
        visited = new boolean[n];
        
        for(int i = 0; i< n; i++){
            if(!visited[i]){
                bfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    void bfs(int start){
        visited[start] = true;
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        
        while(!que.isEmpty()){
            int cur = que.poll();
            
            for(int j = 0; j < n; j++){
                if(cur != j){   // 자기자신 제외
                    if(computers[cur][j] == 1 && !visited[j]){
                        visited[j] = true;
                        que.add(j);
                    }
                }
            }
        }
    }
}