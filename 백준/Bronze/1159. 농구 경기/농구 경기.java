import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[26];

        for(int i = 0; i < N; i++){
            String name = br.readLine();
            cnt[name.charAt(0) - 'a']++;
        }

        boolean flag = false;

        for(int i = 0; i < 26; i++){
            if(cnt[i] >= 5){
                System.out.print((char)(i + 'a'));
                flag = true;
            }
        }

        if(!flag){
            System.out.println("PREDAJA");
        }
    }
}