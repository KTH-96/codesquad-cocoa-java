package week3.shell;

import week3.shell.runcommand.CommandDirectory;
import week3.shell.runcommand.CommandFile;

import javax.swing.text.Document;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.StringTokenizer;

public class Shell {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    CommandFile showFile = new CommandFile();
    CommandDirectory goDirectory = new CommandDirectory();
    public boolean start() throws IOException {
        System.out.print("Yan Java Shell>");
        st = new StringTokenizer(br.readLine(), " ");
        String mainCommand = st.nextToken();
        Optional<String> fileOrDirectoryName;
        try {
            fileOrDirectoryName = Optional.ofNullable(st.nextToken());
        }catch (NoSuchElementException e){
            fileOrDirectoryName = null;
        }

        switch (mainCommand){
            case "ls":
                goDirectory.listOfDirectory();
                return true;
            case "cd":
                goDirectory.goToDirectory(fileOrDirectoryName);
                return true;
            case "mkdir":
                goDirectory.createdDirectory(fileOrDirectoryName);
                return true;
            case "rm-r"://todo: rm -r 형식으로 하고싶다.
                goDirectory.removedDirectory(fileOrDirectoryName);
                return true;
            case "nano":
                showFile.createdAndWriteFile(fileOrDirectoryName);
                return true;
            case "rm":
                showFile.removedFile(fileOrDirectoryName);
                return true;
            case "cat":
                showFile.findFileLocation(fileOrDirectoryName);
                return true;
            case ":wq":
                br.close();
                return false;
        }
        br.close();
        return true;
    }
}