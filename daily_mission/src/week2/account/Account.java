package week2.account;

import week2.account.book.info.AccountInfo;
import week2.account.book.info.AccountInfoRepository;
import week2.account.book.info.User;
import week2.account.book.info.UserRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Account {
    private Scanner sc = new Scanner(System.in);
    private User user;
    private AccountInfo accountInfo;
    private final AccountInfoRepository accountInfoRepository = new AccountInfoRepository();
    private final UserRepository userRepository = new UserRepository();
    private String date;
    private String who;
    private int income;
    private int outcome;

    public void getUserRegistration() {
        System.out.println("유저정보 등록");
        System.out.print("아이디와 비밀번호 입력 > ");
        String userName = sc.next();
        String password = sc.next();
        user = new User(userName, password);
        userRepository.save(user);
    }
    public void getMenu() {
        System.out.println("=================");
        System.out.println("1. 데이터 입력");
        System.out.println("2. 데이터 확인");
        System.out.println("3. 데이터 삭제");
        System.out.println("4. 데이터 수정");
        System.out.println("5. 월별 출력");
        System.out.println("6. 종료");
        System.out.print("번호 입력 > ");
        int num = sc.nextInt();
        switch (num){
            case 1:
                getAccountInfoRegistration();
                break;
            case 2:
                getAccountInfoList();
                break;
            case 3:
                removeAccountInfo();
                break;
            case 4:
                updateAccountInfo();
                break;
            case 5:
                getMonthAccountInfo();
                break;
            case 6:
                System.exit(0);

        }
    }

    private void getMonthAccountInfo() {
        System.out.println("=================");
        System.out.print("월을 입력해주세요 > ");
        String month = sc.next();
        accountInfoRepository.getList().stream()
                .filter(l -> l.getDate().startsWith(month))
                .forEach(System.out::println);

//        System.out.println("잔액 = " + accountInfo.getMoney());
        getMenu();
    }

    private void updateAccountInfo() {
        System.out.println("=================");
        System.out.print("수정할 정보에 순번을 입력해주세요 > ");
        long id = sc.nextLong();
        System.out.println(accountInfo);
        System.out.println("업데이트 정보입력 >");
        System.out.print("날짜(월 일) 주체 수입 지출 > ");
        date = sc.next();
        who = sc.next();
        income = sc.nextInt();
        outcome = sc.nextInt();
        accountInfo = new AccountInfo(date, who, income, outcome);
        accountInfoRepository.updateIndo(id, accountInfo);
        System.out.println(accountInfo);
        getMenu();
    }

    private void removeAccountInfo() {
        System.out.println("=================");
        System.out.print("삭제할 정보에 순번을 입력해주세요 > ");
        Long id = sc.nextLong();
        accountInfoRepository.removeInfo(id);

        getMenu();
    }

    private void getAccountInfoList() {
        List<AccountInfo> list = accountInfoRepository.getList();
        for (AccountInfo info : list) {
            System.out.println("=================");
            System.out.println(info);
        }
        getMenu();
    }


    public void getAccountInfoRegistration() {
        System.out.println("=================");
        System.out.println("가계부 데이터 입력");
        System.out.print("날짜(월 일) 주체 수입 지출 > ");

        date = sc.next();
        who = sc.next();
        income = sc.nextInt();
        outcome = sc.nextInt();

        accountInfo = new AccountInfo(date, who, income, outcome);
        accountInfoRepository.save(accountInfo);

        System.out.println(accountInfo);
        getMenu();
    }


    public void getAccount() {
        System.out.println("=================");
        System.out.println(accountInfo);
    }


}
