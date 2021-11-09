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
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
                System.exit(0);
        }
    }

    private void login() throws IOException {
        Member member = new Member();
        //멤버에 데이터가 없다면?
        System.out.print("이름 비밀번호 입력 ");

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String name = st.nextToken();
        int password = Integer.parseInt(st.nextToken());
        if (!member.getName().equals(name) || member.getPassword() != password){

        }

        getMenu();
    }

    private void getMenu() throws IOException{
        System.out.println("========Menu========");
        System.out.println("1. 데이터 등록");
        System.out.println("2. 데이터 확인");
        System.out.println("3. 데이터 수정");
        System.out.println("4. 데이터 삭제");
        System.out.println("5. 메인 메뉴");
        System.out.print("선택 > ");

        int num = Integer.parseInt(br.readLine());
        switch (num){
            case 1:
                writeDataInfo();
                break;
            case 2:
                listData();
            case 3:
                updateData();
            case 4:
            case 5:
                selectMenu();
                break;
        }
    }

    private void updateData() throws IOException {
        System.out.println("업데이트 할 데이터 번호 입력");
        long id = Long.parseLong(br.readLine());
        System.out.print(" 날짜, 적요, 수입, 지출을 입력해주세여(띄어쓰기 필수) >");
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String date = st.nextToken();
        String reciever = st.nextToken();
        int income = Integer.parseInt(st.nextToken());
        int output = Integer.parseInt(st.nextToken());

        Data data = new Data(date, reciever, income, output);
        dataRepository.update(id, data);

    }

    private void listData() throws IOException {
        List<Data> data = dataRepository.findByAll();
        for (Data datas : data) {
            System.out.println("===============================");
            System.out.println("번호 = "+datas.getId());
            System.out.println("날짜 = "+datas.getDate());
            System.out.println("적요 = "+datas.getReciever());
            System.out.println("수입 = "+datas.getIncome());
            System.out.println("지출 = "+datas.getOutput());
            System.out.println("===============================");
        }

    }

    public void writeMemberInfo() throws IOException{
        System.out.print(" 이름과 비밀번호를 입력해 주세여(띄어쓰기 필수) >");
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        String name = st.nextToken();
        int password = Integer.parseInt(st.nextToken());

        Member member = new Member(name,password);
        memberRepository.save(member);
    }

    public void writeDataInfo() throws IOException{
        System.out.print(" 날짜, 적요, 수입, 지출을 입력해주세여(띄어쓰기 필수) >");
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        String date = st.nextToken();
        String reciever = st.nextToken();
        int income = Integer.parseInt(st.nextToken());
        int output = Integer.parseInt(st.nextToken());

        Data data = new Data(date, reciever, income, output);
        dataRepository.dataSave(data);
        getMenu();

    }

}
