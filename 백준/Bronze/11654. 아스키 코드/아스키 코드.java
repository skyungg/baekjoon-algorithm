import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char ch = br.readLine().charAt(0);    // char 로 변환
        System.out.println((int)ch);
    }
}