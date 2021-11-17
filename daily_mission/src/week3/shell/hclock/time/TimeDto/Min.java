package week3.shell.hclock.time.TimeDto;

public enum Min {
    M1(1,"일", 4, 1),
    M2(2,"이", 4, 2),
    M3(3,"삼", 4, 3),
    M4(4,"사", 4, 4),
    M5(5,"오", 5, 1),
    M6(6,"육", 4, 5),
    M7(7,"칠", 5, 2),
    M8(8,"팔", 5, 3),
    M9(9,"구", 5, 4),
    M10(10,"십", 3, 5),
    M20(20,"이",3,1),
    M30(30,"삼",3,2),
    M40(40,"사",3,3),
    M50(50, "오", 3, 4);

    private final int min;
    private final String hangulMin;
    private final int y;
    private final int x;

    Min(int min, String hangulMin, int y, int x) {
        this.min = min;
        this.hangulMin = hangulMin;
        this.y = y;
        this.x = x;
    }

    public int getMin() {
        return min;
    }

    public String getHangulMin() {
        return hangulMin;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
