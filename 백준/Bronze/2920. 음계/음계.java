import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] arr = br.readLine().split(" ");
        int pre = Integer.parseInt(arr[0]);    // 이전값
        
        boolean cFlag = false;    // 증가 확인 여부
        boolean dFlag = false;    // 감소 확인 여부
        
        for(int i = 1; i < arr.length; i++){
            int num = Integer.parseInt(arr[i]);
            
            if(i == 1){
                if(num > pre) cFlag = true;   // 증가
                else dFlag = true;            // 감소
                pre = num;
            }else{
                if(num > pre){            // 현재 상태 - 증가
                    pre = num;
                    cFlag = true;
                }else if(num < pre){
                    pre = num;
                    dFlag = true;
                    
                }
            }
        }
        
        if(cFlag && !dFlag) System.out.println("ascending");
        if(!cFlag && dFlag) System.out.println("descending");
        if(cFlag && dFlag) System.out.println("mixed");
    }
}
