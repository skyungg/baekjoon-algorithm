import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(br.readLine());
        int[] B = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();

        List<Integer> result = new ArrayList<>();

        int aStart = 0;
        int bStart = 0;

        // 값 범위가 1~100이라서 가능
        for (int val = 100; val >= 1; val--) {
            while (true) {
                int aIdx = -1, bIdx = -1;

                // A에서 찾기
                for (int i = aStart; i < N; i++) {
                    if (A[i] == val) {
                        aIdx = i;
                        break;
                    }
                }

                // B에서 찾기
                for (int i = bStart; i < M; i++) {
                    if (B[i] == val) {
                        bIdx = i;
                        break;
                    }
                }

                // 둘 다 존재하면 채택
                if (aIdx != -1 && bIdx != -1) {
                    result.add(val);
                    aStart = aIdx + 1;
                    bStart = bIdx + 1;
                } else {
                    break;
                }
            }
        }

        System.out.println(result.size());
        if (!result.isEmpty()) {
            for (int num : result) {
                System.out.print(num + " ");
            }
        }
    }
}