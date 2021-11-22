package week4.gui;

import java.awt.*;

public class GuiTest {
    public static void main(String[] args) {
        Frame f = new Frame("Login");
        f.setSize(300, 200);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();//화면 크기 구하기

        Button b = new Button("확인");
        b.setSize(100, 50);


        f.add(b);
        f.setLocation(screenSize.width / 2 - 150, screenSize.height / 2 - 150);//화면크기의 절반값에서 Frame 이 화면 가운데 위치
        f.setVisible(true);
    }
}
