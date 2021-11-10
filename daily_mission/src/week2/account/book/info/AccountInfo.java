package week2.account.book.info;

import java.util.HashMap;
import java.util.Map;

public class AccountInfo {
    String date;
    String who;
    int income;
    int outcome;

    Long id = 0L;
    int money = 0;
    Map<Long, AccountInfo> store = new HashMap<>();
    public AccountInfo save(AccountInfo accountInfo) {
        id++;
        money = income + outcome;
        store.put(id, this);
        return this;
    }

    public AccountInfo(String date, String who, int income, int outcome) {
        this.date = date;
        this.who = who;
        this.income = income;
        this.outcome = outcome;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", who='" + who + '\'' +
                ", income=" + income +
                ", outcome=" + outcome +
                '}';
    }
}
