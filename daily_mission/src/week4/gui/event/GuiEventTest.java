package week4.gui.event;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GuiEventTest {
    public static void main(String[] args) {
        Frame f = new Frame("Login");
        f.setSize(300, 200);
        //EventHandler클래스의 객체를 생성해서 Frame의 WindowListener로 등록한다.
        f.addWindowListener(new EventHandler());
        f.setVisible(true);
    }

    private static class EventHandler implements WindowListener {
        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            e.getWindow().dispose();//메모리에서 제거
            System.exit(0);//프로그램 종료
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }
}
