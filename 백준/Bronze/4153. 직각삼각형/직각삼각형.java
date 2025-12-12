import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            long [] arr = new long[3];
            for(int i = 0; i < 3; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;
            
            // 정렬
            Arrays.sort(arr);
            
            if(arr[2]*arr[2] == (arr[0]*arr[0] + arr[1]*arr[1])){
                sb.append("right"+"\n");
            }else{
                sb.append("wrong"+"\n");
            }
            
            /*
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            long C = Long.parseLong(st.nextToken());
            

            if(A == 0 && B == 0 && C == 0) break;
            if(C*C == A*A + B*B)sb.append("right"+"\n");
            else sb.append("wrong"+"\n");
            */
        }
        
        System.out.println(sb);
    }
               
}