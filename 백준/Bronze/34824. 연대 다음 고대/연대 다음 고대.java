import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            String uni = br.readLine();
            
            if(uni.equals("korea")){
                if(!flag){
                    sb.append("Yonsei Lost...");
                    break;
                }
            }else if(uni.equals("yonsei")){
                if(!flag){
                    sb.append("Yonsei Won!");
                    break;
                }
            }
        }
        
        // 출력
        System.out.println(sb);
    }
}