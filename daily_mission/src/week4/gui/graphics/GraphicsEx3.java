package week4.gui.graphics;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GraphicsEx3 extends Frame implements MouseMotionListener {
    int x = 0;
    int y = 0;

    Image img = null;
    Graphics gImg = null;

    public static void main(String[] args) {
        new GraphicsEx3("GraphicsEx3");
    }

    public GraphicsEx3(String title) {
        super(title);
        addMouseMotionListener(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().setVisible(false);
                e.getWindow().dispose();
                System.exit(0);
            }
        });
        setBounds(100, 100, 500, 500);
        setVisible(true);

        img = createImage(500, 500);
        gImg = img.getGraphics();
        gImg.drawString("왼쪽마우스를 누른채 움직여보세요", getX(), getY());
        repaint();
    }
    public void paint(Graphics g){
        if (img == null) return;
        g.drawImage(img, 0, 0, this);//가상화면에 그려진 이미지 복사
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getModifiersEx() != MouseEvent.BUTTON1_DOWN_MASK) return;
        gImg.drawLine(x, y, e.getX(), e.getY());
        x = e.getX();
        y = e.getY();
        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = getX();
        y = getY();
        repaint();
    }
}
