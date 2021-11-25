package week4.gui.paintboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandHandler implements ActionListener {
    private ButtonCommand buttonCommand;
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("=======ActionEvent = " + e.getActionCommand());
        buttonCommand = new ButtonCommand(e.getActionCommand());
    }
}
