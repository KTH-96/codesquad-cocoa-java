package week4.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiTest {
    public static void main(String[] args) {
        Frame f = new Frame("Test");
        f.setSize(300, 200);
        f.setLayout(null);//레이아웃 매니저의 설정 해제(컨테이너의 크키 변경시 자동으로 변경)\
        //f.setLayout(new FlowLayout()); //컴포넌트 크기들 따로 설정할 필요 없음

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();//화면 크기 구하기

//        Button b = new Button("확인");
//        b.setSize(100, 50);
//        b.setLocation(100, 75);//Frame 내에서 Button위치 설정.

//        Choice day = new Choice();
//        day.add("SUN");
//        day.add("MON");
//        day.add("TUE");
//        day.setSize(100, 50);
//        day.setLocation(100, 70);

//        List select = new List(6, true);
//        select.setLocation(20,40);
//        select.setSize(100, 120);
//        select.add("student");
//        select.add("teacher");

//        Label id = new Label("ID : ");
//        id.setBounds(50, 50, 30, 10);
//
//        Label password = new Label("Password : ");
//        id.setBounds(50, 65, 100, 10);

//        Label id = new Label("ID : ", Label.RIGHT);
//        Label password = new Label("Password : ", Label.RIGHT);
//
//        TextField textId = new TextField(10);//10개 글자 입력 필드 생성
//        TextField textPassword = new TextField(10);//
//        textPassword.setEchoChar('*'); // 입력값 대신 * 보이게

//        Scrollbar bar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 50, 0, 100);//호라이즌 엔 버티컬
//        bar.setSize(100, 15);
//        bar.setLocation(60, 30);

//        Canvas c = new Canvas();
//        c.setBackground(Color.GRAY);
//        c.setBounds(50, 50, 50, 50);

//        Panel p = new Panel();
//        p.setBackground(Color.green);
//        p.setSize(100, 100);
//        p.setLocation(50, 50);
//
//        Button button = new Button("ok");
//        p.add(button);//버튼을 panel에 포함
//        f.add(p);//panel를 frame에 포함

//        Dialog info = new Dialog(f, "Information", true);
//        info.setSize(140, 90);
//        info.setLocation(50, 50);//parent frame이 아닌, 화면기준 위치
//        info.setLayout(new FlowLayout());
//
//        Label msg = new Label("This is modal Dialog", Label.CENTER);
//        Button ok = new Button("Ok");
//        ok.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                info.dispose();//Dialog를 메모리에서 삭제
//            }
//        });
//        f.setVisible(ture);
//        info.setVisible(true);

//        MenuBar mb = new MenuBar();
//        Menu mFile = new Menu("File");
//
//        MenuItem miNew = new MenuItem("New");
//        MenuItem miOpen = new MenuItem("Open");
//        Menu mOthers = new Menu("Others");
//        MenuItem miExit = new MenuItem("Exit");
//
//        mFile.add(miNew);
//        mFile.add(miOpen);
//        mFile.add(mOthers);
//        mFile.addSeparator();//메뉴 분리선 넣는다.
//        mFile.add(miExit);
//
//        MenuItem miPrint = new MenuItem("Print.....");
//        MenuItem miPreview = new MenuItem("Print Preview");
//        MenuItem miSetup = new MenuItem("Print Setup....");
//        mOthers.add(miPrint);
//        mOthers.add(miPreview);
//        mOthers.add(miSetup);
//
//        Menu mEdit = new Menu("Edit");
//        Menu mView = new Menu("View");
//        Menu mHelp = new Menu("Help");
//        CheckboxMenuItem miStatusbar = new CheckboxMenuItem("Statusbar");
//        mView.add(miStatusbar);
//        mb.add(mFile); // MenuBar에 Menu를 추가한다.
//        mb.add(mEdit);
//        mb.add(mView);
//        mb.setHelpMenu(mHelp); // mHelp를 HelpMenu로 지정한다.

//        f.add(b); frame에 집어넣기

        f.setLocation(screenSize.width / 2 - 150, screenSize.height / 2 - 150);//화면크기의 절반값에서 Frame 이 화면 가운데 위치
        f.setVisible(true);
    }
}
