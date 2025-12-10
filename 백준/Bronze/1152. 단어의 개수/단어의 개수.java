import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        
        if(str.length() == 0) System.out.println(0);    // 공백만 존재
        else{
        String [] arr = str.split("\\s+");
        
        System.out.println(arr.length);
        }
        

    }
}