package week3.shell.hclock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class hclock {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        String formattedNow = now.format(DateTimeFormatter.ofPattern("HH시 mm분"));
    }
}
