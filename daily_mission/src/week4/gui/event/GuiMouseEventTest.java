package week4.gui.event;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GuiMouseEventTest extends Frame {
    Label location;

    public static void main(String[] args) {
        GuiMouseEventTest mouseEventTest = new GuiMouseEventTest();
        mouseEventTest.MouseTest("MouseEventTest");
    }

    private void MouseTest(String title) {
        location = new Label("Mouse Pointer Location : ");
        location.setSize(250, 15);
        location.setLocation(5, 30);
        location.setBackground(Color.yellow);
        add(location);

        addMouseMotionListener(new EventHandler());

        setSize(300, 300);
        setLayout(null);
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

    private class EventHandler implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            location.setText("Mouse Pointer Location : (" + e.getX() + ", " + e.getY() + ")");
        }
    }
}
