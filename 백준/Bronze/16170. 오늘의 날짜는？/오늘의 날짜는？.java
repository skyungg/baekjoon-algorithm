import java.io.*;
import java.time.*;

public class Main{
    public static void main(String [] args) throws IOException{
        LocalDate now = LocalDate.now(ZoneOffset.UTC);

        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());
    }
}
    