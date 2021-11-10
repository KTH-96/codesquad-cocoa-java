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
    public void getMenu() {
        System.out.println("1. 데이터 입력");
        System.out.println("2. 데이터 확인");
        System.out.println("3. 데이터 삭제");
        System.out.println("4. 데이터 수정");
        System.out.println("5. 월별 출력");
        System.out.print("번호 입력 > ");
        int num = sc.nextInt();
        switch (num){
            case 1:
                getAccountInfoRegistration();
            case 2:
                getAccountInfoList();
            case 3:
                removeAccountInfo();
            case 4:
                updateAccountInfo();
            case 5:
                getMonthAccountInfo();
        }
    }
    //todo:해당 월의 지출내역 잔액필요
    private void getMonthAccountInfo() {
    }

    //todo:특정 순번 데이터 업데이트
    private void updateAccountInfo() {
    }

    //todo:특정 순번 데이터 삭제
    private void removeAccountInfo() {

    }
    //TODO:들어있는 데이터 확인
    private void getAccountInfoList() {

    }

    //TODO:가계부 정보 저장
    public void getAccountInfoRegistration() {
        System.out.println("가계부 데이터 입력");
        System.out.print("날짜(월 일) 주체 수입 지출 > ");
        String date = sc.next();
        String who = sc.next();
        int income = sc.nextInt();
        int outcome = sc.nextInt();
        accountInfo.save(new AccountInfo(date, who, income, outcome));
        System.out.println(accountInfo);

    }

    //TODO:화면에 출력
    public void getAccount() {
        System.out.println(accountInfo);
    }


}
