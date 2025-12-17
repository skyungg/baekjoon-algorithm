import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        System.out.println(dfs(N));
    }
    
    static int dfs(int n){
        if(n == 0 || n == 1) return 1;
        
        return n*dfs(n-1);
    }
}