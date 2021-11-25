package week4.gui.paintboard;

public class ButtonCommand {
    private String command;

    public ButtonCommand(String command) {
        System.out.println("======들어오는 커맨드 확인 = " + command);
        this.command = command;
    }

    public String getCommand() {
        System.out.println("=======나가는 커맨드 확인 = " + this.command);
        return command;
    }

}
