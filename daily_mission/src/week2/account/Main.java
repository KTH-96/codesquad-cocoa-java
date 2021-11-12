package week2.account;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Account account = new Account();
        account.getUserRegistration();
        account.getMenu();
        account.getAccountInfoRegistration();
        account.getAccount();
    }
}
