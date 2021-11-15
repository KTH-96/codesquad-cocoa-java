package week3.shell.runcommand;

import java.io.File;
import java.util.Optional;

public class CommandDirectory {
    File folder;
    Path path = new Path("/Users/taehyun/IdeaProjects/codesquad-cocoa-java/daily_mission/src/week3/shell/etc");


    //todo:폴더 안 파일들 보여주기
    public void listOfDirectory() {
        folder = new File(path.getPath());
        try {
            if (folder.exists()) {
                File[] files = folder.listFiles();
                for (File file : files) {
                    System.out.println(file);
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    //todo:폴더로 이동
    public void goToDirectory(Optional<String> fileOrDirectoryName) {
        path.setPath(path.getPath() + fileOrDirectoryName);
        if (fileOrDirectoryName.equals("/")){
            path.setPath("/Users/taehyun/IdeaProjects/codesquad-cocoa-java/daily_mission/src/week3/shell/etc");
        }
    }
    //todo:폴더 만들기
    public void createdDirectory(Optional<String> fileOrDirectoryName) {
        path.setPath(path.getPath() + fileOrDirectoryName);
        folder = new File(path.getPath());
        if (!folder.exists()){
            try {
                folder.mkdir();
            }catch (Exception e){
                e.getStackTrace();
            }
        }
    }
    //todo:폴더 삭제(삭제시 안에있는 파일 다삭제)
    public void removedDirectory(Optional<String> fileOrDirectoryName) {
        path.setPath(path.getPath() + fileOrDirectoryName);
        folder = new File(path.getPath());
        try {
            if (folder.exists()) {
                File[] files = folder.listFiles();
                for (File file : files) {
                    if (file.isFile()) {
                        file.delete();
                        continue;
                    }else {
                        removedDirectory(Optional.of(file.getName()));
                    }
                    file.delete();
                }
                folder.delete();
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
