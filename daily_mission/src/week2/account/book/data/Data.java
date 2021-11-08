package week2.account.book.data;



public class Data {
    private Long id;
    private String date;
    private String reciever;
    private int income;
    private int output;

    public Data() {
    }

    public Data(String date, String reciever, int income, int output) {
        this.date = date;
        this.reciever = reciever;
        this.income = income;
        this.output = output;
    }

    public Data(Long id, String date, String reciever, int income, int output) {
        this.id = id;
        this.date = date;
        this.reciever = reciever;
        this.income = income;
        this.output = output;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }
}
