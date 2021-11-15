package week3.shell.runcommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Optional;

public class CommandFile {
    Path path;
    File file;
    //todo:파일 생성
    public void createdWriteFile(Optional<String> fileOrDirectoryName) {
        file = new File(path.getPath() + fileOrDirectoryName);
        try {
            OutputStream fileOutputStream = new FileOutputStream(file, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    //todo:파일 제거
    public void removedFile(Optional<String> fileOrDirectoryName) {
        file = new File(path.getPath() + fileOrDirectoryName);
        file.delete();
    }
    //todo:파일 위치 보여주기
    public void findFileLocation(Optional<String> fileOrDirectoryName) {
        System.out.println(path.getPath()+fileOrDirectoryName);
    }
}
