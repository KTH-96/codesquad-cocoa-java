package week3.shell.hclock;

import week3.shell.hclock.service.DateService;
import week3.shell.hclock.service.TimeService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class hclock {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        //포맷팅
        String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd/HH/mm"));
        String calendar = formatedNow.substring(0, 10);
        String clock = formatedNow.substring(11, formatedNow.length());

        TimeService timeService = new TimeService();
        System.out.println(clock);
        timeService.run(clock);
    }
}
