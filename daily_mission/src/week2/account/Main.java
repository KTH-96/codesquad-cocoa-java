package week2.account;

import week2.account.book.data.Data;
import week2.account.book.data.DataRepository;
import week2.account.book.member.Member;
import week2.account.book.member.MemberRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.NoSuchElementException;
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

    Long dataId;

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        switch (num){
            case 1:
                writeMemberInfo();
                selectMenu();
                break;
            case 2:
                login();
                break;
            case 3:
                return;
        }
    }

    private void login() throws IOException {
        Member member = new Member();
        //멤버에 데이터가 없다면?
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
        getMenu(member);

    }

    private void getMenu(Member member) throws IOException{
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
                writeDataInfo(member);
                break;
            case 2:
                listData(member);
            case 3:
                updateData(member);
            case 4:
            case 5:
                selectMenu();
                break;
        }
    }

    private void updateData(Member member) throws IOException {
        System.out.println("업데이트 할 데이터 입력");
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
            writeDataInfo(member);
        }
//        Data data = dataRepository.findById(dataId);
//        data.setDate(date);
//        data.setReciever(reciever);
//        data.setIncome(income);
//        data.setOutput(output);
        Data data = new Data(date, reciever, income, output);
        dataRepository.update(dataId - 1, data);

        getMenu(member);
    }

    private void listData(Member member) throws IOException {
        List<Data> data = dataRepository.findByAll();
        for (Data datas : data) {
            System.out.println("===============================");
            System.out.println("날짜 = "+datas.getDate());
            System.out.println("적요 = "+datas.getReciever());
            System.out.println("수입 = "+datas.getIncome());
            System.out.println("지출 = "+datas.getOutput());
            System.out.println("===============================");
        }
        getMenu(member);
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

    public void writeDataInfo(Member member) throws IOException{
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
            writeDataInfo(member);
        }
        Data data = new Data(date, reciever, income, output);
        Data savedData = dataRepository.dataSave(data);
        dataId = savedData.getId();


        getMenu(member);

    }

}
