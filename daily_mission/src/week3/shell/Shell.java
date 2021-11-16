package week3.shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Shell {

    StringTokenizer st;
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
                break;
            case "cd":
                String move = command.goToDirectory(fileOrDirectoryName);
                start(move);
                break;
            case "mkdir":
                command.createdDirectory(fileOrDirectoryName);
                break;
            case "rm-r"://todo: rm -r 형식으로 하고싶다.
                command.removedDirectory(fileOrDirectoryName);
                break;
            case "nano":
                command.createdWriteFile(fileOrDirectoryName);
                break;
            case "rm":
                command.removedFile(fileOrDirectoryName);
                break;
            case "cat":
                command.findFileLocation(fileOrDirectoryName);
                break;
            case "help":
                showCommand();
                break;
            case ":wq":
                return false;
        }
        return true;
    }
    //todo: 명령어 정리해서 보여주기
    private void showCommand() {
        System.out.println(":wq = 셸 종료");
        System.out.println("ls = 폴더안 파일들 보여줌");
        System.out.println("cd = 이동");
        System.out.println("mkdir = 폴더 생성");
        System.out.println("rm-r = 폴더 제거");
        System.out.println("nano = 파일 생성");
        System.out.println("rm = 파일 제거");
        System.out.println("cat = 파일 보기");
        System.out.println("help = 명령어 보여주기");
    }
}