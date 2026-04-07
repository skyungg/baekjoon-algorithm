import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] arr = input.split("\\|");

        int minor = 0; // A-minor
        int major = 0; // C-major

        for (String s : arr) {
            char first = s.charAt(0);

            if (first == 'A' || first == 'D' || first == 'E') {
                minor++;
            }
            if (first == 'C' || first == 'F' || first == 'G') {
                major++;
            }
        }

        // 같으면 마지막 문자로 판단
        if (minor == major) {
            char last = input.charAt(input.length() - 1);

            if (last == 'A' || last == 'D' || last == 'E') {
                minor++;
            }
            if (last == 'C' || last == 'F' || last == 'G') {
                major++;
            }
        }

        if (minor > major) {
            System.out.println("A-minor");
        } else {
            System.out.println("C-major");
        }
    }
}