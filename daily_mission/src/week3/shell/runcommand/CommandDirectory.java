package week3.shell.runcommand;

import java.io.File;
import java.util.Optional;

public class CommandDirectory {
    String path = "/Users/taehyun/IdeaProjects/codesquad-cocoa-java/daily_mission/src/week3/shell/etc";
    File folder;

    //todo:폴더 안 파일들 보여주기
    public void listOfDirectory() {

    }
    //todo:폴더로 이동
    public void goToDirectory(Optional<String> fileOrDirectoryName) {

    }
    //todo:폴더 만들기
    public void createdDirectory(Optional<String> fileOrDirectoryName) {
        folder = new File(path + fileOrDirectoryName);
        if (!folder.exists()){
            folder.mkdir();
        }
    }
    //todo:폴더 삭제(삭제시 안에있는 파일 다삭제)
    public void removedDirectory(Optional<String> fileOrDirectoryName) {

    }
}
