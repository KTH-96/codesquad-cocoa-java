package week2.account.book.info;

public class AccountInfo {
    String date;
    String who;
    int income;
    int outcome;

    public AccountInfo(String date, String who, int income, int outcome) {
        this.date = date;
        this.who = who;
        this.income = income;
        this.outcome = outcome;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "date='" + date + '\'' +
                ", who='" + who + '\'' +
                ", income=" + income +
                ", outcome=" + outcome +
                '}';
    }
}
