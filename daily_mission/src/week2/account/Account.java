package week2.account;

import week2.account.book.info.AccountInfo;
import week2.account.book.info.User;

import java.util.Scanner;

public class Account {
    private Scanner sc = new Scanner(System.in);
    private User user;
    private AccountInfo accountInfo;


    //TODO:유저 저장
    public void getUserRegistration() {
        System.out.println("유저정보 등록");
        System.out.print("아이디와 비밀번호 입력 > ");
        String userName = sc.next();
        String password = sc.next();
        user = new User(userName, password);
    }

    //TODO:가계부 정보 저장
    public void getAccountInfoRegistration() {
        System.out.println("가계부 데이터 입력");
        System.out.print("날짜(월 일) 주체 수입 지출 > ");
        String date = sc.next();
        String who = sc.next();
        int income = sc.nextInt();
        int outcome = sc.nextInt();
        accountInfo = new AccountInfo(date, who, income, outcome);
    }

    //TODO:화면에 출력
    public void getAccount() {
        System.out.println(accountInfo);
    }
}
