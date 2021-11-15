package week3.shell;

import week3.shell.runcommand.CommandDirectory;
import week3.shell.runcommand.CommandFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shell {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    CommandFile showFile = new CommandFile();
    CommandDirectory goDirectory = new CommandDirectory();
    public boolean start() throws IOException {
        System.out.print("Yan Java Shell>");
        String command = br.readLine();
        switch (command){
            case "ls":
                goDirectory.listOfDirectory();
            case "cd":
                goDirectory.goToDirectory();
            case "mkdir":
                goDirectory.createdDirectory();
            case "rm -r":
                goDirectory.removedDirectory();
        }
        return true;
    }
}