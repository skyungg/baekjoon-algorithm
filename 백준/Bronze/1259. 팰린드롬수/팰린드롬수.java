import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true){
            String str = br.readLine();
            if(str.equals("0")) break;
            
            StringBuilder s = new StringBuilder(str);
            
            if(str.equals(s.reverse().toString())) sb.append("yes"+"\n");
            else sb.append("no"+"\n");
        }
        
        System.out.println(sb);
    }
}