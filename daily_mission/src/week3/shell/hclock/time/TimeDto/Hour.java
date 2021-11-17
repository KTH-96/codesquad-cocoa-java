package week3.shell.hclock.time.TimeDto;

public enum Hour {
    H1(1,"한", 0, 0),
    H2(2, "두", 0, 1),
    H3(3, "세", 0, 2),
    H4(4, "네", 0, 3),
    H5(5, "다", 0, 4),
    H5_2(5, "섯", 0, 5),

    H6(6, "여", 1, 0),
    H6_2(6, "섯", 1, 1),

    H7(7, "일", 1, 2),
    H7_2(7, "곱", 1, 3),

    H8(8, "여", 1, 4),
    H8_2(8, "덟", 1, 5),

    H9(9, "아", 2, 0),
    H9_2(9, "홉", 2, 1),

    H10(10, "열", 2, 2),

    H11(10, "열", 2, 2),
    H11_2(10, "한", 2, 3),

    H12(10, "열", 2, 2),
    H12_2(10, "두", 2, 4),

    MIDNIGHT(0, "자", 3, 1),
    MIDNIGHT_2(0, "정", 4, 1),
    NOON(12, "정", 4, 1),
    NOON_2(12, "오", 5, 1);

    private final int hour;
    private final String hangulHour;
    private final int y;
    private final int x;

    Hour(int hour, String hangulHour, int y, int x) {
        this.hour = hour;
        this.hangulHour = hangulHour;
        this.y = y;
        this.x = x;
    }

    public int getHour() {
        return hour;
    }

    public String getHangulHour() {
        return hangulHour;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
