package week4.gui.paintboard;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GuiEvent extends Frame {
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
        setVisible(true);
    }
}
