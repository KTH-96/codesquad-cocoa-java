package week4.gui.paintboard;

import week1.makename.Make;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MakeFrame extends Frame {

    private Graphics graphics;
    private Graphics2D graphics2D;
    private int startX = 0;
    private int startY = 0;
    private ToolBox toolBox;
    private MakeFrame makeFrame;
    public MakeFrame(String title) {
        super(title);
        toolBox = new ToolBox();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setBounds(screenSize.width / 2 - 500, screenSize.height / 2 - 500, 1000, 1000);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().setVisible(false);
                e.getWindow().dispose();
                System.exit(0);
            }
        });
        add(toolBox);

        setVisible(true);

        Graphics graphics = getGraphics();
        Graphics2D graphics2D = (Graphics2D) graphics;
    }

    @Override
    public Graphics getGraphics() {
        return graphics;
    }

    public Graphics2D getGraphics2D() {
        return graphics2D;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }
}
