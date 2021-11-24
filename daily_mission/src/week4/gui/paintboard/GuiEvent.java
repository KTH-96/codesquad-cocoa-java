package week4.gui.paintboard;

import java.awt.*;
import java.awt.event.*;

public class GuiEvent extends Frame {
    Point startP,endP;

    public static void main(String[] args) {
        GuiEvent guiEvent = new GuiEvent("Paint");
//        guiEvent.makeCanvas();
        guiEvent.makePanel();
    }

    private void makeCanvas() {
        Canvas canvas = new Canvas();
        canvas.setBackground(Color.ORANGE);
        canvas.setBounds(0, 80, 500, 500);

        add(canvas);
    }

    private void makePanel() {
        Panel panel = new Panel();
        panel.setBackground(Color.green);
        panel.setBounds(0, 30, 500, 50);

        Button line = new Button("line");
        line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("=========라인 버튼 클릭");
                drawingLine();
            }
        });
        line.setBounds(0, 0, 50, 50);

        Button ark = new Button("ark");
        ark.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("=========곡선 버튼 클릭");
                drawingArk();
            }
        });
        ark.setBounds(55, 0, 50, 50);

        Button circle = new Button("circle");
        circle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("=========원 버튼 클릭");
                drawingCircle();
            }
        });
        circle.setBounds(110, 0, 50, 50);

        panel.add(line);
        panel.add(ark);
        panel.add(circle);
        add(panel);
    }

    private void drawingCircle() {
        System.out.println("========드로우 원");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startP = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endP = e.getPoint();
                Graphics graphics = getGraphics();
                graphics.drawOval(startP.x, startP.y, endP.x, endP.y);
            }
        });
    }

    private void drawingArk() {
        System.out.println("========드로우 곡선");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startP = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endP = e.getPoint();
                Graphics graphics = getGraphics();
                graphics.drawArc(startP.x, startP.y, endP.x, endP.y, 30,30);
            }
        });
    }

    private void drawingLine() {
        System.out.println("=======드로우 라인");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startP = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endP = e.getPoint();
                Graphics graphics = getGraphics();
                graphics.drawLine(startP.x, startP.y, endP.x, endP.y);
            }
        });

    }

    public GuiEvent(String title) {
        super(title);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().setVisible(false);
                e.getWindow().dispose();
                System.exit(0);
            }
        });
        setBounds(200, 200, 500, 500);
        setLayout(null);
        setVisible(true);
    }
}
