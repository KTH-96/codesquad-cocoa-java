package week4.gui.paintboard;

import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.event.*;

public class GuiEvent extends Frame implements MouseMotionListener{
//    Point startP,endP;
    int x = 0;
    int y = 0;
    private Color color;

    private Image image = null;
    private Graphics graphics = null;

    private ButtonCommand buttonCommand;
    public GuiEvent(String title) {
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
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        setBounds(screenSize.width / 2 - 500, screenSize.height / 2 - 250, 1000, 500);

        makePanel();

        setVisible(true);

        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        graphics.drawString("좌클릭 후 이동해주세요", x, y);
        repaint();

    }

    public void update(Graphics graphics) {
        paint(graphics);
    }
    public void paint(Graphics g) {
        if (image == null) return;
        g.drawImage(image, 0, 0, this);
    }


    public void makePanel() {
        Panel p = new Panel();
        p.setBackground(Color.GRAY);
        Button sketch = new Button("스케치");
        Button line = new Button("선");
        Button rect = new Button("사각형");
        Button circle = new Button("원");
        Button clear = new Button("지우기");

        sketch.addActionListener(new CommandHandler());
        line.addActionListener(new CommandHandler());
        rect.addActionListener(new CommandHandler());
        circle.addActionListener(new CommandHandler());
        clear.addActionListener(new CommandHandler());

        p.add(sketch);
        p.add(line);
        p.add(rect);
        p.add(circle);
        p.add(clear);
        add(p,"North");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getModifiersEx() != MouseEvent.BUTTON1_DOWN_MASK) return;
        graphics.drawLine(x, y, e.getX(), e.getY());
        x = e.getX();
        y = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();
    }
}
