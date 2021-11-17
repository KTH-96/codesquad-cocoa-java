package week3.shell.hclock;

import week3.shell.hclock.time.TimeService;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class hclock {
    public static void main(String[] args) {
        TimeService service = new TimeService();
        service.run();
    }
}
