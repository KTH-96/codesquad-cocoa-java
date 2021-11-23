package week4.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.EventHandler;

public class GuiLoginTest extends Frame {
    Label lid;
    Label lpwd;
    TextField tfId;
    TextField tfPwd;
    Button ok;

    public static void main(String[] args) {
        GuiLoginTest loginTest = new GuiLoginTest("Login");
    }

    private GuiLoginTest(String title) {
//        super(title); //Frame(String title)을 호출한다.
//        그냥 매개변수로 받은 title 쓰면 안되나?
        lid = new Label("ID :", Label.RIGHT); // Label의 text 정렬을 오른쪽으로
        lpwd = new Label("Password :", Label.RIGHT);

        tfId = new TextField(10);
        tfPwd = new TextField(10);
        tfPwd.setEchoChar('*');

        ok = new Button("OK");
        tfId.addActionListener(new EventHandler());
        tfPwd.addActionListener(new EventHandler());
        ok.addActionListener(new EventHandler());

        setLayout(new FlowLayout());//LayoutManager를 FlowLayout으로
        add(lid);
        add(lpwd);
        add(tfId);
        add(tfPwd);
        add(ok);
        setSize(450, 65);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().setVisible(false);
                e.getWindow().dispose();
                System.exit(0);
            }
        });
        setVisible(true);
    }
    class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = tfId.getText();
            String password = tfPwd.getText();
            if (!id.equals("javachobo")){
                System.out.println("입력하신 id가 유효하지 않습니다. 다시 입력해 주세여");
                tfId.requestFocus();
                tfId.selectAll();//tfId에 입력된 text가 선택되게 한다.
            } else if (!password.equals("asdf")) {
                System.out.println("입력하신 password가 유효하지 않습니다. 다시 입력해 주세여");
            }
        }
    }
}
