package week4.gui.paintboard;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ToolBox extends Panel{

    private List<Button> buttons;
    private MouseAdapter mouseAdapter;

    public ToolBox() {
        buttons = makeButtons();
        makePanel();
        addButtonActionEvent();
    }

    private void addButtonActionEvent() {
        for (Button button : buttons) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeMouseListenerFromPaintFrame(e);
                    addMouseListenerPaint(e);
                }
            });
        }
    }

    private void removeMouseListenerFromPaintFrame(ActionEvent e) {
        Button b = (Button) e.getSource();
        MakeFrame paintFrame = (MakeFrame) b.getParent().getParent();
        paintFrame.removeMouseMotionListener(mouseAdapter);
        paintFrame.removeMouseListener(mouseAdapter);
    }
    private void addMouseListenerPaint(ActionEvent e){
        Button b = (Button) e.getSource();
        MakeFrame paintFrame = (MakeFrame) b.getParent().getParent();
        Graphics g = paintFrame.getGraphics();
        Graphics2D g2 = paintFrame.getGraphics2D();

        switch (b.getLabel()) {
            case "스케치" :
                mouseAdapter = new MouseAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        paintFrame.setStartX(e.getX());
                        paintFrame.setStartY(e.getY());
                    }

                    @Override
                    public void mouseDragged(MouseEvent e) {
                        if (e.getModifiersEx() != MouseEvent.BUTTON1_DOWN_MASK) {
                            return;
                        }
                        g.drawLine(paintFrame.getX(), paintFrame.getY(), e.getX(), e.getY());
                        paintFrame.setStartX(e.getX());
                        paintFrame.setStartY(e.getY());
                    }
                };
                paintFrame.addMouseListener(mouseAdapter);
                break;
        }
    }

    private void makePanel() {
        setLayout(new GridLayout(1, 6));
        setBounds(0, 30, 1000, 30);

        for (Button button : buttons) {
            add(button);
        }
    }

    private List<Button> makeButtons() {
        String[] buttonName =  {"스케치", "직선", "원", "사각형"};
        List<Button> makeButton = new ArrayList<>();
        for (String button : buttonName) {
            makeButton.add(new Button(button));
        }
        return makeButton;
    }
}
