import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char ch = str.charAt(0);
        
        if(ch == 'F'){
            System.out.println("Foundation");
        }else if(ch == 'C'){
            System.out.println("Claves");
        }else if(ch == 'V'){
            System.out.println("Veritas");
        }else{
            System.out.println("Exploration");
        }
    }
}