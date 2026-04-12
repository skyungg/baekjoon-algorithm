import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            int[] cnt = new int[26];

            // 첫 문자열 +1
            for (int j = 0; j < a.length(); j++) {
                cnt[a.charAt(j) - 'a']++;
            }

            // 두 번째 문자열 -1
            for (int j = 0; j < b.length(); j++) {
                cnt[b.charAt(j) - 'a']--;
            }

            boolean possible = true;
            for (int j = 0; j < 26; j++) {
                if (cnt[j] != 0) {
                    possible = false;
                    break;
                }
            }

            if (possible) System.out.println("Possible");
            else System.out.println("Impossible");
        }
    }
}