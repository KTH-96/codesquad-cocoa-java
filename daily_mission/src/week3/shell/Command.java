package week3.shell;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Command {
    File file;
    Path path = new Path("/Users/taehyun/IdeaProjects/codesquad-cocoa-java/daily_mission/src/week3/shell");

    //todo:폴더 안 파일들 보여주기
    public void listOfDirectory() {
        file = new File(path.getPath());
        System.out.println("==========="+file.toPath());
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
    //todo: 이동
    public String goToDirectory(String fileOrDirectoryName) {
        setPath(fileOrDirectoryName);
        System.out.println("======="+file.toPath());
        if (fileOrDirectoryName.equals("/")) {
            path.setPath("C:/Users/taehyun/IdeaProjects/codesquad-cocoa-java/daily_mission/src/week3/shell");
        }
        return fileOrDirectoryName;
    }

    //todo:폴더 만들기

    public String createdDirectory(String fileOrDirectoryName) {
        setPath(fileOrDirectoryName);
        file = new File(path.getPath());
        System.out.println("==========="+file.toPath());
        if (!file.exists()){
            try {
                file.mkdir();
            }catch (Exception e){
                e.getStackTrace();
            }
        }
        return fileOrDirectoryName;
    }
    //todo:폴더 삭제(삭제시 안에있는 파일 다삭제)
    public void removedDirectory(String fileOrDirectoryName) {
        setPath(fileOrDirectoryName);
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
        setFileLocation(fileOrDirectoryName);
        System.out.println("========="+file.getPath());
        try {
            if (!file.exists()) {
                OutputStream fileOutputStream = new FileOutputStream(file, false);
            }else {
                OutputStream fileOutputStream = new FileOutputStream(file, true);
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            System.out.print("파일 내용작성 해주세요");
            bw.write(br.readLine());
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //todo:파일 제거

    public void removedFile(String fileOrDirectoryName) {
        setFileLocation(fileOrDirectoryName);
        file.delete();
    }
    //todo:파일 위치 보여주기
    public void findFileLocation(String fileOrDirectoryName) {
        System.out.println(path.getPath() + "/" + fileOrDirectoryName);
    }
    //todo:파일 복사하기
    public void copyFile(String fileOrDirectoryName) {
        System.out.print("복사될 파일 이름을 적어주세요>");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String copyFileName = br.readLine();
            setFileLocation(fileOrDirectoryName);
            File newFile = new File(path.getPath() + "/" + copyFileName);
            System.out.println("=========="+file.toPath());
            System.out.println("=========="+newFile.toPath());

            Files.copy(file.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setFileLocation(String fileOrDirectoryName) {
        file = new File(path.getPath() + "/" + fileOrDirectoryName);
    }

    private void setPath(String fileOrDirectoryName) {
        path.setPath(path.getPath() + "/" + fileOrDirectoryName);
    }
}
