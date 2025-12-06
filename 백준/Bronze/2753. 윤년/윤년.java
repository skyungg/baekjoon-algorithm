import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        
        System.out.println(checkLeapYear(year));
        
    }
    
    static public int checkLeapYear(int y){
        if(y%4 == 0){
            if(y%100 != 0 || y%400 == 0) return 1;
        }
        
        return 0;
    }
}