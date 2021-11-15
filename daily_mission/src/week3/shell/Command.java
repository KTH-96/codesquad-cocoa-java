package week3.shell;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Command {
    File file;
    Path path = new Path("/Users/taehyun/IdeaProjects/codesquad-cocoa-java/daily_mission/src/week3/shell/");

    //todo:폴더 안 파일들 보여주기
    public void listOfDirectory() {
        file = new File(path.getPath());
        try {
            if (file.exists()) {
                File[] files = file.listFiles();
                for (File file : files) {
                    System.out.println(file);
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    //todo:폴더로 이동
    public String goToDirectory(String fileOrDirectoryName) {
        path.setPath(path.getPath() + fileOrDirectoryName);
        System.out.println("======="+path.getPath());
        if (fileOrDirectoryName.equals("/")){
            path.setPath("C:/Users/taehyun/IdeaProjects/codesquad-cocoa-java/daily_mission/src/week3/shell/");
        }
        return fileOrDirectoryName;
    }
    //todo:폴더 만들기
    public void createdDirectory(String fileOrDirectoryName) {
        path.setPath(path.getPath() +"/"+ fileOrDirectoryName);
        file = new File(path.getPath());
        if (!file.exists()){
            try {
                file.mkdir();
            }catch (Exception e){
                e.getStackTrace();
            }
        }
    }
    //todo:폴더 삭제(삭제시 안에있는 파일 다삭제)
    public void removedDirectory(String fileOrDirectoryName) {
        path.setPath(path.getPath() + "/" + fileOrDirectoryName);
        file = new File(path.getPath());
        try {
            if (file.exists()) {
                File[] files = file.listFiles();
                for (File file : files) {
                    if (file.isFile()) {
                        file.delete();
                        continue;
                    }else {
                        removedDirectory(file.getName());
                    }
                    file.delete();
                }
                file.delete();
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    //todo:파일 생성
    public void createdWriteFile(String fileOrDirectoryName) {
        file = new File(path.getPath() + "/" + fileOrDirectoryName);
        System.out.println("========="+file.getPath());
        try {
            OutputStream fileOutputStream = new FileOutputStream(file, false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    //todo:파일 제거
    public void removedFile(String fileOrDirectoryName) {
        file = new File(path.getPath() + "/" + fileOrDirectoryName);
        file.delete();
    }
    //todo:파일 위치 보여주기
    public void findFileLocation(String fileOrDirectoryName) {
        System.out.println(path.getPath() + "/" + fileOrDirectoryName);
    }
}
