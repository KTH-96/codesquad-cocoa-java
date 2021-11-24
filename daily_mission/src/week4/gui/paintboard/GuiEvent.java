package week4.gui.paintboard;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GuiEvent extends Frame {
    int startX = 0;
    int startY = 0;
    int endX = 0;
    int endY = 0;
    public static void main(String[] args) {
        GuiEvent guiEvent = new GuiEvent("Paint");
        guiEvent.makePanel();
        guiEvent.makeCanvas();
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
                System.out.println("hello");
            }
        });
        line.setBounds(0, 0, 50, 50);

        Button ark = new Button("ark");
        ark.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hello!!");
            }
        });
        ark.setBounds(55, 0, 50, 50);

        Button circle = new Button("circle");
        circle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hello!!");
            }
        });
        circle.setBounds(110, 0, 50, 50);

        panel.add(line);
        panel.add(ark);
        panel.add(circle);
        add(panel);
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
