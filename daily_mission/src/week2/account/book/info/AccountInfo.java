package week2.account.book.info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountInfo {


    private long id;
    private String date;
    private String who;
    private int income;
    private int outcome;

    private int money;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public AccountInfo(String date, String who, int income, int outcome) {
        this.date = date;
        this.who = who;
        this.income = income;
        this.outcome = outcome;
    }

    @Override
    public String toString() {
        return "정보 " +
                " 순번=" + id + '\'' +
                " 날짜 = '" + date + '\'' +
                ", 적요 = '" + who + '\'' +
                ", 수입 = " + income +
                ", 지출=" + outcome ;
    }
}
