/*
-> 영역 구하기
1. 1~n까지 dfs 돌려서 연결연결 visited 배열 표시하기
2. 1의 과정거치면서 방문하지 않은 경우-> 네트워크 1증가
*/

import java.util.*;

class Solution {
    boolean [] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i< n; i++){
            if(!visited[i]){
                dfs(i, n, computers);
                answer++;
            }
        }
        return answer;
    }
    
    void dfs(int start, int n, int [][] computers){
        visited[start] = true;
        
        for(int j = 0; j < n; j++){
            if(computers[start][j] == 1 && !visited[j]){
                dfs(j, n, computers);
            }
        }
    }
}