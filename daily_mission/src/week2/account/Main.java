package week2.account;

import week2.account.book.data.Data;
import week2.account.book.data.DataRepository;
import week2.account.book.member.Member;
import week2.account.book.member.MemberRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
    private static MemberRepository memberRepository = MemberRepository.getInstance();
    private static DataRepository dataRepository = DataRepository.getInstance();
    String name;
    int password;

    String date;
    String reciever;
    int income;
    int output;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        System.out.println("============가계부");
        main.selectMenu();
    }

    private void selectMenu() throws IOException {
        System.out.println("=========menu");
        System.out.println("1. 사용자 등록 ");
        System.out.println("2. 로그인 ");
        System.out.println("3. 종료 ");
        System.out.print("선택> ");
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(buf.readLine());
        switch (num){
            case 1:
                writeMemberInfo();
                selectMenu();
                break;
            case 2:
                login();
                break;
            case 3:
                break;
        }
    }

    private void login() throws IOException {
        Member member = new Member();
        System.out.print("이름 비밀번호 입력 ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        try {
            name = st.nextToken();
            password = Integer.parseInt(st.nextToken());
        }catch (NoSuchElementException no){
            System.out.println("뜨워쓰기 해라");
            login();
        }
//        if (!member.getName().equals(name) || member.getPassword() != password) {
//            System.out.println("아이디 비번이 틀림");
//            selectMenu();
//        } nullpoint의 원흉!!!
        getMenu(name, password);

    }

    private void getMenu(String name, int password) throws IOException{
        System.out.println("========Menu========");
        System.out.println("1. 데이터 등록");
        System.out.println("2. 데이터 확인");
        System.out.println("3. 데이터 수정");
        System.out.println("4. 데이터 삭제");
        System.out.println("5. 메인 메뉴");
        System.out.print("선택 > ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        switch (num){
            case 1:
                writeDataInfo();
                break;
            case 2:

            case 3:
            case 4:
            case 5:
                selectMenu();
                break;
        }
    }

    public void writeMemberInfo() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(" 이름과 비밀번호를 입력해 주세여(띄어쓰기 필수) >");
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        try {
            name = st.nextToken();
            password = Integer.parseInt(st.nextToken());
        }catch (NoSuchElementException no){
            System.out.println("뜨워쓰기 해라");
            writeMemberInfo();
        }
        Member member = new Member(name,password);
        memberRepository.save(member);
    }

    public void writeDataInfo() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(" 날짜, 적요, 수입, 지출을 입력해주세여(띄어쓰기 필수) >");
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        try {
            date = st.nextToken();
            reciever = st.nextToken();
            income = Integer.parseInt(st.nextToken());
            output = Integer.parseInt(st.nextToken());
        }catch (NoSuchElementException no){
            System.out.println("뜨워쓰기 해라");
            writeDataInfo();
        }
        Data data = new Data(date, reciever, income, output);
        dataRepository.dataSave(data);
    }

}
