package week2.account.book.info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountInfo {
    String date;
    String who;
    int income;
    int outcome;

    public String getDate() {
        return date;
    }

    Long id = 0L;
    int money = 0;
    Map<Long, AccountInfo> store = new HashMap<>();
    public AccountInfo save(AccountInfo accountInfo) {
        id++;
        getMoney();
        store.put(id, accountInfo);
        return accountInfo;
    }
    public int getMoney(){
        money += income + outcome;
        return money;
    }

    public void getReturnMoney() {
        money -= income + outcome;
    }

    public List<AccountInfo> getList() {
        System.out.println("리스트");
        return new ArrayList<>(store.values());
    }

    public void removeInfo(Long id) {
        store.remove(id);
    }

    public void updateIndo(Long id , AccountInfo accountInfo) {
        removeInfo(id);
        store.put(id, accountInfo);
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
