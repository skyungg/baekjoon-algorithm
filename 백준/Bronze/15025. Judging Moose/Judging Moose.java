import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 1. 둘 다 0
        if (L == 0 && R == 0) {
            System.out.println("Not a moose");
        }
        // 2. 같은 경우
        else if (L == R) {
            System.out.println("Even " + (L * 2));
        }
        // 3. 다른 경우
        else {
            System.out.println("Odd " + (Math.max(L, R) * 2));
        }
    }
}