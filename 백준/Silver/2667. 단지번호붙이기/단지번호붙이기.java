import java.io.*;
import java.util.*;

public class Main{
 static int N;
 static int[][] map;
 static boolean [][] visited;
 static int [] dx = {-1, 0, 1, 0};
 static int [] dy = {0, 1, 0, -1};
    
 public static void main(String [] args) throws IOException{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  N = Integer.parseInt(br.readLine());
  map = new int[N][N];
  visited = new boolean[N][N];
  
  // input
  for(int i=0; i < N; i++){
     String str = br.readLine();
     for(int j=0; j < N; j++){
         map[i][j] = str.charAt(j) - '0';
     }
  }
  
  List<Integer> list = new ArrayList<>();
  for(int i=0; i < N; i++){
     for(int j=0; j < N; j++){
         if(map[i][j] == 1 && !visited[i][j]){
           list.add(bfs(i, j));
         }
     }
  }
     
  // output
  StringBuilder sb = new StringBuilder();
  sb.append(list.size()+"\n");
  Collections.sort(list);
     
  for(int num : list) sb.append(num+"\n");
  System.out.println(sb);
     
 }
    
  static int bfs(int x, int y){
    Queue<int []> que = new LinkedList<>();
    que.add(new int[]{x, y});
    visited[x][y] = true;
    int count = 1;
      
    while(!que.isEmpty()){
      int [] point = que.poll();
      
      for(int i = 0; i < 4; i++){
          int tx = point[0] + dx[i];
          int ty = point[1] + dy[i];
          
          if(isRange(tx, ty) && !visited[tx][ty]){
              if(map[tx][ty] == 1){
                  visited[tx][ty] = true;
                  count++;
                  que.add(new int [] {tx, ty});
              }
          }
      }
    }
    return count;
  }
    
  static boolean isRange(int x, int y){
      return x >= 0 && x < N && y >= 0 && y < N;
  }
}