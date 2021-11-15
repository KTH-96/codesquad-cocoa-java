package week3.shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Shell {

    StringTokenizer st;
//    CommandFile showFile = new CommandFile();
//    CommandDirectory goDirectory = new CommandDirectory();
    Command command = new Command();

    public boolean start(String name) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (name == null || name.equals("/")) {
            name = "";
        }
        System.out.print("Yan Java Shell "+name+">");
        st = new StringTokenizer(br.readLine(), " ");
        String mainCommand = st.nextToken();
        String fileOrDirectoryName;
        try {
            fileOrDirectoryName = st.nextToken();
        }catch (NoSuchElementException e){
            fileOrDirectoryName = null;
        }

        switch (mainCommand){
            case "ls":
                command.listOfDirectory();
                return true;
            case "cd":
                String move = command.goToDirectory(fileOrDirectoryName);
                start(move);
                return true;
            case "mkdir":
                command.createdDirectory(fileOrDirectoryName);
                return true;
            case "rm-r"://todo: rm -r 형식으로 하고싶다.
                command.removedDirectory(fileOrDirectoryName);
                return true;
            case "nano":
                command.createdWriteFile(fileOrDirectoryName);
                return true;
            case "rm":
                command.removedFile(fileOrDirectoryName);
                return true;
            case "cat":
                command.findFileLocation(fileOrDirectoryName);
                return true;
            case "help":
                showCommand();
                return true;
            case ":wq":
                return false;
        }
        return true;
    }
    //todo: 명령어 정리해서 보여주기
    private void showCommand() {
        System.out.println("명령어를 보여줍니다.");
    }
}