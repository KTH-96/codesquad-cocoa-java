package week4.gui.graphics;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GraphicsEx1 extends Frame {
    public static void main(String[] args) {
        new GraphicsEx1("GraphicsEx1");
    }

    public void paint(Graphics graphics) {
        graphics.setFont(new Font("Serif", Font.PLAIN, 15));
        graphics.drawString("Graphics를 이용해서 그림을 그립니다.", 10, 50);

        graphics.drawOval(50, 100, 50, 50);
        graphics.setColor(Color.BLUE);
        graphics.fillOval(100,100, 50,50);
        graphics.setColor(Color.red);
        graphics.drawLine(100,100, 150,150);
        graphics.fillRoundRect(200, 100, 120, 80, 30, 30);
        graphics.setColor(Color.orange);
        graphics.fillPolygon(new int[]{ 50, 100, 150, 200}, new int[]{250, 200, 200, 250}, 4);
        graphics.setColor(Color.cyan);
        graphics.fillArc(250, 200, 100, 100, 0, 120);
    }

    public GraphicsEx1(String title) {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().setVisible(false);
                e.getWindow().dispose();
                System.exit(0);
            }
        });
        setBounds(100, 100, 400, 300);
        setVisible(true);
    }
}
